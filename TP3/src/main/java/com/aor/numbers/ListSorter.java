package com.aor.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * An utility class to sort list of numbers.
 */
public class ListSorter implements IListSorter {
    private final List<Integer> list;

    public ListSorter(List<Integer> list) {
        this.list = list;
    }

    /**
     * Really stupid way to sort a list.
     * @return A sorted version of the list.
     */
    public List<Integer> sort() {
        List<Integer> sorted = new ArrayList();
        for (Integer number : list)
            sorted.add(number);

        sorted.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer.compareTo(t1);
            }
        });

        return sorted;
    }
}
