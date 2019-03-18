package tk.mpdr.shape;

public class Square implements AreaShape {
    private double side;

    public double getSide() {
        return side;
    }

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public String draw() {
        return this.getClass().getName();
    }
}
