package com.github.vladimirbabin.sorting;

public class CountingSort implements Sort {
    @Override
    public void sort(int[] array) {
        int[] minMax = minMax(array);
        int min = minMax[0];
        int max = minMax[1];
        int range = max - min + 1;

        int shift = -min;

        // create an array with range number of indices and count times they repeat
        int[] counts = new int[range];
        for (int i : array) {
            counts[i + shift]++;
        }

        // increment each array elements after the 2nd by value of previous element
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        // fill the result array with elements from the initial array ar indexes they should appear
        // starting from the end allows to maintain stable sort
        int[] sorted = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            int el = array[i];
            int indexAt = counts[el + shift]-- - 1;
            sorted[indexAt] = el;
        }

        System.arraycopy(sorted, 0, array, 0, array.length);
    }


    private int[] minMax(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        return new int[]{min, max};
    }
}
