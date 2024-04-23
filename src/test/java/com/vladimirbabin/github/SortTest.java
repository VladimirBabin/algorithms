package com.vladimirbabin.github;

import com.github.vladimirbabin.sorting.RadixSort;
import com.github.vladimirbabin.sorting.Sort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    Sort sort;

    @BeforeEach
    void setUp() {
        sort = new RadixSort();
    }

    @Test
    void testOnSmallArray() {
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] actual = {6, 3, 7, 9, 1, 2, 4, 10, 5, 8};

        sort.sort(actual);

        System.out.println(Arrays.toString(actual));

        assertArrayEquals(expected, actual);
    }

    @Test
    void testOnSmallArrayWithDuplicates() {
        int[] expected = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 8, 8, 9, 10};

        int[] actual = {6, 3, 8, 7, 9, 1, 2, 3, 0, 8, 4, 10, 5, 8};

        sort.sort(actual);

        System.out.println(Arrays.toString(actual));

        assertArrayEquals(expected, actual);
    }

    @Test
    void testOnArrayWithNegativeElementsAndDuplicates() {
        int[] expected = {-23, -10, -3, 0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 8, 8, 9, 10, 92};

        int[] actual = {6, 3, 92, 8, -23, 7, 9, 1, -3, -10, 2, 3, 0, 8, 4, 10, 5, 8};

        sort.sort(actual);

        System.out.println(Arrays.toString(actual));

        assertArrayEquals(expected, actual);
    }
}