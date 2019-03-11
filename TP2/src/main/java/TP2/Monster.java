package TP2;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element {

    public Monster(Position position) {
        super(position);
    }

    public Position move() {
        Random random = new Random();
        int choice = random.nextInt(5);
        switch (choice) {
            case 0:
                return new Position(getX() - 1, getY());
            case 1:
                return new Position(getX() + 1, getY());
            case 2:
                return new Position(getX(), getY() + 1);
            case 3:
                return new Position(getX(), getY() - 1);
            default:
                return position;
        }
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "M");
    }
}
