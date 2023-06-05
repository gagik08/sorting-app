package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;


/**
 * The SortingAppTest class is responsible for testing the SortingApp class.
 * It includes parameterized unit tests to cover different scenarios.
 */
@RunWith(Parameterized.class)
public class SortingAppTest {
    private final int[] input;
    private final int[] expectedOutput;


    /**
     * Constructs a new instance of SortingAppTest with the given input and expected output.
     *
     * @param input          The input array to be sorted.
     * @param expectedOutput The expected output array after sorting.
     */
    public SortingAppTest(int[] input, int[] expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    /**
     * Provides the test data for the parameterized tests.
     *
     * @return A collection of input and expected output arrays for sorting.
     */
    @Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {new int[]{}, new int[]{}},                // Corner case: No input numbers
                {new int[]{1}, new int[]{1}},             // Corner case: Single input number
                {new int[]{5, 3, 8, 1}, new int[]{1, 3, 5, 8}},  // Normal case
                // Add more test cases as needed
        });
    }


    /**
     * Tests the sorting functionality of the SortingApp class.
     * It verifies that the sorted output matches the expected output.
     */
    @Test
    public void testSortNumbers() {
        String[] args = new String[input.length];
        for (int i = 0; i < input.length; i++) {
            args[i] = String.valueOf(input[i]);
        }

        SortingApp.main(args);

        assertArrayEquals(expectedOutput, SortingApp.getSortedNumbers());
    }
}


