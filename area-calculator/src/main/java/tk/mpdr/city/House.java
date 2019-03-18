package tk.mpdr.city;

import tk.mpdr.shape.HasArea;

public class House implements HasArea {
    private int floorNumber;
    private double areaPerFloor;

    public House(int floorNumber, double areaPerFloor) {
        this.floorNumber = floorNumber;
        this.areaPerFloor = areaPerFloor;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public double getAreaPerFloor() {
        return areaPerFloor;
    }

    @Override
    public double getArea() {
        return floorNumber * areaPerFloor;
    }
}
