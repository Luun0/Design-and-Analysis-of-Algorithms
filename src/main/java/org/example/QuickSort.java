package org.example;

import java.util.Random;

public class QuickSort {
    private static final Random rand = new Random();

    public static void sort(int[] arr) {
        sort(arr, new Metrics());
    }

    public static void sort(int[] arr, Metrics m) {
        quickSort(arr, 0, arr.length - 1, m);
    }

    private static void quickSort(int[] arr, int lo, int hi, Metrics m) {
        while (lo < hi) {
            m.enter();
            int pivot = partition(arr, lo, hi, m);
            if (pivot - lo < hi - pivot) {
                quickSort(arr, lo, pivot - 1, m);
                lo = pivot + 1;
            } else {
                quickSort(arr, pivot + 1, hi, m);
                hi = pivot - 1;
            }
            m.exit();
        }
    }

    private static int partition(int[] arr, int lo, int hi, Metrics m) {
        int pivotIndex = lo + rand.nextInt(hi - lo + 1);
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, hi);
        int store = lo;
        for (int i = lo; i < hi; i++) {
            m.compare();
            if (arr[i] < pivot) {
                swap(arr, i, store++);
            }
        }
        swap(arr, store, hi);
        return store;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}