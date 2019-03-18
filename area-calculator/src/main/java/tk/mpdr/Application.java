package tk.mpdr;

import tk.mpdr.city.City;
import tk.mpdr.city.House;
import tk.mpdr.shape.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        AreaAggregator aggregator = new AreaAggregator();

        aggregator.addArea(new Square(10));
        aggregator.addArea(new Circle(5));
        aggregator.addArea(new Circle(2));
        aggregator.addArea(new Ellipse(2, 3));
        aggregator.addArea(new Rectangle(10, 5));
        aggregator.addArea(new Triangle(10, 2));
        aggregator.addArea(new House(100, 50));

        printArea(aggregator);

        List<House> houses = new ArrayList<>();
        houses.add(new House(50, 100));
        houses.add(new House(150, 50));

        City city = new City(houses);

        printArea(city);
    }

    private static void printArea(SumProvider provider) {
        AreaStringOutputter stringOut = new AreaStringOutputter(provider);
        AreaXMLOutputter xmlOut = new AreaXMLOutputter(provider);

        System.out.println(stringOut.output());
        System.out.println(xmlOut.output());
    }
}
