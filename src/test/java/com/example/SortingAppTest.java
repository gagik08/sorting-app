package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortingAppTest {
    private int[] sortedNumbers;

    @Before
    public void setup() {
        String[] args = {"5", "3", "2", "7", "1"};
        SortingApp.main(args);
        sortedNumbers = SortingApp.getSortedNumbers();
    }

    @Test
    public void testSortingAppWithMultipleNumbers() {
        int[] expected = {1, 2, 3, 5, 7};
        assertArrayEquals(expected, sortedNumbers);
    }

    @Test
    public void testSortingAppWithSingleNumber() {
        String[] args = {"5"};
        SortingApp.main(args);
        int[] expected = {5};
        sortedNumbers = SortingApp.getSortedNumbers();
        assertArrayEquals(expected, sortedNumbers);
    }

    @Test
    public void testSortingAppWithNoNumbers() {
        String[] args = new String[0];
        SortingApp.main(args);
        int[] expected = new int[0];
        sortedNumbers = SortingApp.getSortedNumbers();
        assertArrayEquals(expected, sortedNumbers);
    }
}




