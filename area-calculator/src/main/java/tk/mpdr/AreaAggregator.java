package tk.mpdr;

import tk.mpdr.shape.HasArea;

import java.util.ArrayList;
import java.util.List;

public class AreaAggregator implements SumProvider{
    private List<HasArea> shapes = new ArrayList<>();

    public void addArea(HasArea shape) {
        shapes.add(shape);
    }

    @Override
    public double sum() {
        double sum = 0;
        for (HasArea shape: shapes) {
            sum += shape.getArea();
        }
        return sum;
    }

}
