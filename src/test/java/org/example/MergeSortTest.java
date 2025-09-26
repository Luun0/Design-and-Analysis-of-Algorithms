package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void testEmptyArray() {
        int[] arr = {};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    void testTwoElementsSorted() {
        int[] arr = {1, 2};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{1, 2}, arr);
    }

    @Test
    void testTwoElementsUnsorted() {
        int[] arr = {2, 1};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{1, 2}, arr);
    }

    @Test
    void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReverseSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testWithDuplicates() {
        int[] arr = {3, 1, 2, 3, 1};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, arr);
    }

    @Test
    void testLargeValues() {
        int[] arr = {1000, -1000, 500, -500, 0};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{-1000, -500, 0, 500, 1000}, arr);
    }

    @Test
    void testAllEqual() {
        int[] arr = {7, 7, 7, 7};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{7, 7, 7, 7}, arr);
    }

    @Test
    void testRandomLargeArray() {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) arr[i] = arr.length - i;
        MergeSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(i + 1, arr[i]);
        }
    }
}