package tk.mpdr.shape;

public class Circle implements AreaShape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius,2);
    }

    @Override
    public String draw() {
        return this.getClass().getName();
    }
}
