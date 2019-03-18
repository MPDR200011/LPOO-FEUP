package tk.mpdr.shape;

public class Line implements Shape {
    private double width;

    public Line(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public String draw() {
        return this.getClass().getName();
    }
}
