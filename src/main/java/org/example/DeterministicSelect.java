package org.example;

public class DeterministicSelect {

    public static int select(int[] arr, int k) {
        return select(arr, k, new Metrics());
    }

    public static int select(int[] arr, int k, Metrics m) {
        return select(arr, 0, arr.length - 1, k, m);
    }

    private static int select(int[] arr, int lo, int hi, int k, Metrics m) {
        while (true) {
            if (lo == hi) return arr[lo];
            m.enter();
            int pivot = medianOfMedians(arr, lo, hi, m);
            int pos = partition(arr, lo, hi, pivot, m);
            if (k == pos) {
                m.exit();
                return arr[k];
            } else if (k < pos) {
                hi = pos - 1;
            } else {
                lo = pos + 1;
            }
            m.exit();
        }
    }

    private static int medianOfMedians(int[] arr, int lo, int hi, Metrics m) {
        int n = hi - lo + 1;
        if (n < 5) {
            insertionSort(arr, lo, hi, m);
            return arr[lo + n / 2];
        }
        int groups = (n + 4) / 5;
        int[] medians = new int[groups];
        m.allocate();
        for (int i = 0; i < groups; i++) {
            int subLo = lo + i * 5;
            int subHi = Math.min(subLo + 4, hi);
            insertionSort(arr, subLo, subHi, m);
            medians[i] = arr[subLo + (subHi - subLo) / 2];
        }
        return select(medians, 0, groups - 1, groups / 2, m);
    }

    private static int partition(int[] arr, int lo, int hi, int pivot, Metrics m) {
        int i = lo, j = hi;
        while (i <= j) {
            while (i <= hi && arr[i] < pivot) {
                m.compare();
                i++;
            }
            while (j >= lo && arr[j] > pivot) {
                m.compare();
                j--;
            }
            if (i <= j) swap(arr, i++, j--);
        }
        return i - 1;
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

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}