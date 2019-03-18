package tk.mpdr.shape;

public class Rectangle implements AreaShape {
    private double widht;
    private double height;

    public Rectangle(double widht, double height) {
        this.widht = widht;
        this.height = height;
    }

    public double getWidht() {
        return widht;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return height * widht;
    }

    @Override
    public String draw() {
        return this.getClass().getName();
    }
}
