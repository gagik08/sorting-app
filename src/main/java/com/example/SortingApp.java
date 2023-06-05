package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The SortingApp class is a Java application that performs quicksort on a list of integer numbers.
 * It takes command-line arguments as the numbers to be sorted and prints the sorted numbers.
 */
public class SortingApp {
    private static final Logger logger = LogManager.getLogger(SortingApp.class);
    private static int[] sortedNumbers;

    /**
     * The main method is the entry point of the SortingApp application.
     * It parses the command-line arguments, performs quicksort on the numbers, and prints the sorted numbers.
     *
     * @param args The command-line arguments containing the numbers to be sorted.
     */
    public static void main(String[] args) {
        logger.info("Starting SortingApp");

        if (args.length == 0) {
            logger.warn("No arguments provided.");
            System.out.println("No arguments provided.");
            sortedNumbers = new int[0];
            return;
        }

        int[] numbers = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            try {
                numbers[i] = Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                logger.error("Invalid argument format: " + args[i]);
                System.out.println("Invalid argument format: " + args[i]);
                sortedNumbers = new int[0];
                return;
            }
        }

        quickSort(numbers, 0, numbers.length - 1);
        sortedNumbers = numbers;

        logger.info("Sorting completed successfully");
        System.out.println("Sorted numbers:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }


    /**
     * Sorting implementation details...
     */
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }


    /**
     * Partitioning implementation details...
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }


    /**
     * Swap implementation details...
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Gets the sorted numbers after the quicksort operation.
     *
     * @return An array of integers representing the sorted numbers.
     */
    public static int[] getSortedNumbers() {
        return sortedNumbers;
    }
}

