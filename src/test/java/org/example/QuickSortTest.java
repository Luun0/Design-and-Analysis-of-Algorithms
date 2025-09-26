package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void testEmptyArray() {
        int[] arr = {};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {1};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{1}, arr);
    }

    @Test
    void testTwoElementsSorted() {
        int[] arr = {1, 2};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{1, 2}, arr);
    }

    @Test
    void testTwoElementsUnsorted() {
        int[] arr = {2, 1};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{1, 2}, arr);
    }

    @Test
    void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReverseSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testWithDuplicates() {
        int[] arr = {5, 3, 5, 3, 5};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{3, 3, 5, 5, 5}, arr);
    }

    @Test
    void testNegativeNumbers() {
        int[] arr = {-1, -3, 2, 0, -2};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{-3, -2, -1, 0, 2}, arr);
    }

    @Test
    void testAllEqual() {
        int[] arr = {9, 9, 9, 9};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{9, 9, 9, 9}, arr);
    }

    @Test
    void testLargeArray() {
        int[] arr = new int[500];
        for (int i = 0; i < arr.length; i++) arr[i] = arr.length - i;
        QuickSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(i + 1, arr[i]);
        }
    }
}