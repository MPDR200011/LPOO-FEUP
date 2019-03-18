package tk.mpdr.shape;

public class Triangle implements AreaShape {
    private double baseSize;
    private double height;

    public Triangle(double baseSize, double height) {
        this.baseSize = baseSize;
        this.height = height;
    }

    public double getBaseSize() {
        return baseSize;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return baseSize * height / 2;
    }

    @Override
    public String draw() {
        return this.getClass().getName();
    }
}
