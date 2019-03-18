package tk.mpdr;

public class AreaStringOutputter {
    private SumProvider aggregator;

    public AreaStringOutputter(SumProvider aggregator) {
        this.aggregator = aggregator;
    }

    public String output() {
        return "Sum of areas: " + aggregator.sum();
    }
}
