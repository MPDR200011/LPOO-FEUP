package TP2;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.*;

class Arena {
    private int width;
    private int height;
    private Hero hero;

    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.hero = new Hero(1, 1);
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        Set<Position> positions = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            Position pos = getUniquePosition(random, positions);
            coins.add(new Coin(pos));
        }
        return coins;
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        Set<Position> positions = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            Position pos = getUniquePosition(random, positions);
            monsters.add(new Monster(pos));
        }
        return monsters;
    }

    private Position getUniquePosition(Random random, Set<Position> positions) {
        Position pos;
        do {
            pos = new Position(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
        } while (!positions.add(pos));
        return pos;
    }

    private void moveMonsters() {
        for (Monster m: monsters) {
            Position pos = m.move();
            if (canElementMove(pos)) {
                m.setPosition(pos);
            }
        }
    }

    private void verifyMonsterCollisions () {
        for (Monster m: monsters) {
            if (hero.getPosition().equals(m.getPosition())) {
                System.out.println("You died, noob.");
                System.exit(0);
            }
        }
    }

    public void processKey(KeyStroke key) {
        moveMonsters();
        verifyMonsterCollisions();
        switch (key.getKeyType()) {
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            default:
                break;
        }
        verifyMonsterCollisions();
    }

    private void moveHero(Position position) {
        if (canElementMove(position)) {
            hero.setPosition(position);
        }
        retrieveCoins();
    }

    private boolean canElementMove(Position position) {
        for (Wall wall : walls) {
            if (position.equals(wall.getPosition())) {
                return false;
            }
        }
        return true;
    }

    private void retrieveCoins() {
        for (Coin c : coins) {
            if (hero.getPosition().equals(c.getPosition())) {
                coins.remove(c);
                break;
            }
        }
        if (coins.size() == 0) {
            System.out.println("You win, bro.");
            System.exit(0);
        }
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        for (Wall wall : walls) {
            wall.draw(graphics);
        }
        for (Coin c : coins) {
            c.draw(graphics);
        }
        hero.draw(graphics);
        for (Monster m: monsters) {
            m.draw(graphics);
        }
    }
}
