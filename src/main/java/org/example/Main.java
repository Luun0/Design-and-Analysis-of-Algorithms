package org.example;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {5, 2, 9, 1, 5, 6};
        Metrics m1 = new Metrics();
        MergeSort.sort(arr1, m1);
        System.out.print("MergeSort result: ");
        for (int x : arr1) System.out.print(x + " ");
        System.out.println();
        System.out.println("MergeSort metrics: comparisons=" + m1.comparisons.get() +
                ", allocations=" + m1.allocations.get() +
                ", maxDepth=" + m1.getMaxDepth());
        System.out.println();

        int[] arr2 = {3, 7, 2, 5, 1, 4};
        Metrics m2 = new Metrics();
        QuickSort.sort(arr2, m2);
        System.out.print("QuickSort result: ");
        for (int x : arr2) System.out.print(x + " ");
        System.out.println();
        System.out.println("QuickSort metrics: comparisons=" + m2.comparisons.get() +
                ", allocations=" + m2.allocations.get() +
                ", maxDepth=" + m2.getMaxDepth());
        System.out.println();

        int[] arr3 = {12, 3, 5, 7, 4, 19, 26};
        int k = 3;
        Metrics m3 = new Metrics();
        int kth = DeterministicSelect.select(arr3, k, m3);
        System.out.println("DeterministicSelect (k=3): " + kth);
        System.out.println("Select metrics: comparisons=" + m3.comparisons.get() +
                ", allocations=" + m3.allocations.get() +
                ", maxDepth=" + m3.getMaxDepth());
        System.out.println();

        ClosestPair.Point[] pts = {
                new ClosestPair.Point(2, 3),
                new ClosestPair.Point(12, 30),
                new ClosestPair.Point(40, 50),
                new ClosestPair.Point(5, 1),
                new ClosestPair.Point(12, 10),
                new ClosestPair.Point(3, 4)
        };
        Metrics m4 = new Metrics();
        double d = ClosestPair.closestPair(pts, m4);
        System.out.println("Closest Pair distance: " + d);
        System.out.println("ClosestPair metrics: comparisons=" + m4.comparisons.get() +
                ", allocations=" + m4.allocations.get() +
                ", maxDepth=" + m4.getMaxDepth());
    }
}