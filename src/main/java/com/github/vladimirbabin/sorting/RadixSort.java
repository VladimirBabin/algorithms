package com.github.vladimirbabin.sorting;


public class RadixSort implements Sort {
    @Override
    public void sort(int[] array) {
        if (hasNegativeValues(array)) {
            throw new IllegalArgumentException("This implementation of Radix sort is only applied to positive integers");
        }
        int max = findMaxNumber(array);
        int digitsNumber = calculateNumberOfDigits(max);
        int placeValue = 1;
        while (digitsNumber-- > 0) {
            applyCountingSort(array, placeValue);
            placeValue *= 10;
        }
    }

    private boolean hasNegativeValues(int[] array) {
        for (int i : array) {
            if (i < 0) {
                return true;
            }
        }
        return false;
    }

    private void applyCountingSort(int[] array, int placeValue) {
        int range = 10;

        int[] counts = new int[range];
        for (int i : array) {
            int digit = (i / placeValue) % range;
            counts[digit]++;
        }

        // increment each array elements after the 2nd by value of previous element
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        // fill the result array with elements from the initial array ar indexes they should appear
        // starting from the end allows to maintain stable sort
        int[] sorted = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            int el = (array[i] / placeValue) % range;
            sorted[counts[el]-- - 1] = array[i];
        }

        System.arraycopy(sorted, 0, array, 0, array.length);
    }

    private int calculateNumberOfDigits(int max) {
        int digitsNum = 0;
        while (max > 0) {
            digitsNum++;
            max /= 10;
        }
        return digitsNum;
    }

    private int findMaxNumber(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
