package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {
    List<Integer> list;

    @Before
    public void setupList() {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
    }

    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        assertEquals(14, sum);
    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(5, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        assertEquals(1, min);
    }

    @Test
    public void distinct() {

        class DeduplicatorStub implements IListDeduplicator {
            @Override
            public List<Integer> deduplicate(IListSorter sorter) {
                return new ArrayList<>(Arrays.asList(1,2,4,5));
            }
        }

        IListSorter sorter = new IListSorter() {
            @Override
            public List<Integer> sort() {
                return new ArrayList<>(Arrays.asList(1,2,2,4,5));
            }
        };

        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(new DeduplicatorStub(), sorter);

        assertEquals(4, distinct);
    }

    @Test
    public void maxBugTest() {
        list = new ArrayList<>(Arrays.asList(-1,-4,-5));
        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();
        assertEquals(-1,max);
    }

    @Test
    public void distinctBudTest() {

        IListDeduplicator deduplicator = new IListDeduplicator() {
            @Override
            public List<Integer> deduplicate(IListSorter listSorter) {
                return new ArrayList<>(Arrays.asList(1,2,4));
            }
        };

        IListSorter sorter = new IListSorter() {
            @Override
            public List<Integer> sort() {
                return new ArrayList<>(Arrays.asList(1,2,2,4));
            }
        };

        list = new ArrayList<>(Arrays.asList(1,2,4,2));
        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(deduplicator, sorter);
        assertEquals(3,distinct);
    }
}