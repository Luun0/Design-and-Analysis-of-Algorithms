package org.example;

public class MergeSort {
    private static final int CUTOFF = 16;

    public static void sort(int[] arr) {
        sort(arr, new Metrics());
    }

    public static void sort(int[] arr, Metrics m) {
        int[] buffer = new int[arr.length];
        mergeSort(arr, buffer, 0, arr.length - 1, m);
    }

    private static void mergeSort(int[] arr, int[] buffer, int lo, int hi, Metrics m) {
        if (hi - lo <= CUTOFF) {
            insertionSort(arr, lo, hi, m);
            return;
        }
        m.enter();
        int mid = (lo + hi) >>> 1;
        mergeSort(arr, buffer, lo, mid, m);
        mergeSort(arr, buffer, mid + 1, hi, m);
        merge(arr, buffer, lo, mid, hi, m);
        m.exit();
    }

    private static void merge(int[] arr, int[] buffer, int lo, int mid, int hi, Metrics m) {
        for (int i = lo; i <= hi; i++) {
            buffer[i] = arr[i];
            m.allocate();
        }
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid && j <= hi) {
            m.compare();
            arr[k++] = (buffer[i] <= buffer[j]) ? buffer[i++] : buffer[j++];
        }
        while (i <= mid) arr[k++] = buffer[i++];
        while (j <= hi) arr[k++] = buffer[j++];
    }

    private static void insertionSort(int[] arr, int lo, int hi, Metrics m) {
        for (int i = lo + 1; i <= hi; i++) {
            int key = arr[i], j = i - 1;
            while (j >= lo && arr[j] > key) {
                m.compare();
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}