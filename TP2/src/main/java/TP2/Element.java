package TP2;

import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    protected Position position;

    public Element(int x, int y) {
        this.position = new Position(x,y);
    }

    public Element(Position position) {
        this.position = position;
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract void draw(TextGraphics graphics);
}
