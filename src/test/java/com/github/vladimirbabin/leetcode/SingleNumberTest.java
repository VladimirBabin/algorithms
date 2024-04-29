package com.github.vladimirbabin.leetcode;

import org.junit.jupiter.api.Test;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;

class SingleNumberTest {
    SingleNumber singleNumber = new SingleNumber();

    @Test
    void easyTest() {
        int[] input = new int[]{4,1,2,1,2};
        int expected = 4;

        int res = singleNumber.singleNumber(input);

        assertEquals(expected, res);
    }

    @Test
    void hardTest() {
        int[] input = new int[]{1,2,0,3,-4,5,90,-80,70,60,50,90,70,70,-80,5,-4,3,60,1,50,2,0};
        int expected = 70;

        int res = singleNumber.singleNumber(input);
        System.out.println(new String(new char[]{'1', '2'}));
        assertEquals(expected, res);
    }
}