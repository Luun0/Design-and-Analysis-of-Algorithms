package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeterministicSelectTest {

    @Test
    void testSelectMin() {
        int[] arr = {5, 2, 9, 1};
        assertEquals(1, DeterministicSelect.select(arr, 0));
    }

    @Test
    void testSelectMax() {
        int[] arr = {5, 2, 9, 1};
        assertEquals(9, DeterministicSelect.select(arr, 3));
    }

    @Test
    void testSelectMiddle() {
        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        assertEquals(7, DeterministicSelect.select(arr, 3));
    }

    @Test
    void testSelectSingleElement() {
        int[] arr = {42};
        assertEquals(42, DeterministicSelect.select(arr, 0));
    }

    @Test
    void testSelectWithDuplicates() {
        int[] arr = {5, 1, 5, 1, 5};
        assertEquals(1, DeterministicSelect.select(arr, 0));
    }

    @Test
    void testSelectNegativeNumbers() {
        int[] arr = {-10, -20, -30, -5};
        assertEquals(-20, DeterministicSelect.select(arr, 1));
    }

    @Test
    void testSelectRandomOrder() {
        int[] arr = {100, 50, 200, 150};
        assertEquals(150, DeterministicSelect.select(arr, 2));
    }

    @Test
    void testSelectAllEqual() {
        int[] arr = {7, 7, 7, 7};
        assertEquals(7, DeterministicSelect.select(arr, 2));
    }

    @Test
    void testSelectLargeArrayFirst() {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) arr[i] = i;
        assertEquals(0, DeterministicSelect.select(arr, 0));
    }

    @Test
    void testSelectLargeArrayLast() {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) arr[i] = i;
        assertEquals(999, DeterministicSelect.select(arr, 999));
    }
}