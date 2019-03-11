package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {

    private List<Integer> list;

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
    public void deduplicate() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(new ListSorter(list));

        assertEquals(expected, distinct);
    }

    @Test
    public void deduplicateBugTest() {

        list = new ArrayList<>(Arrays.asList(1,2,4,2));

        IListSorter sorter = new IListSorter() {
            @Override
            public List<Integer> sort() {
                return new ArrayList<>(Arrays.asList(1,2,2,4));
            }
        };

        List<Integer> expected = new ArrayList<>(Arrays.asList(1,2,4));

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> deduplicated = deduplicator.deduplicate(sorter);

        assertEquals(expected, deduplicated);
    }
}