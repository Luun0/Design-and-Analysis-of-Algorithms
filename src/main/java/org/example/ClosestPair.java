package org.example;

public class ClosestPair {
    public static class Point {
        double x, y;
        public Point(double x, double y) { this.x = x; this.y = y; }
    }

    public static double closestPair(Point[] points) {
        return closestPair(points, new Metrics());
    }

    public static double closestPair(Point[] points, Metrics m) {
        sortByX(points, 0, points.length - 1, m);
        return closest(points, 0, points.length - 1, m);
    }

    private static double closest(Point[] pts, int lo, int hi, Metrics m) {
        if (hi - lo <= 3) return bruteForce(pts, lo, hi, m);
        m.enter();
        int mid = (lo + hi) >>> 1;
        double d1 = closest(pts, lo, mid, m);
        double d2 = closest(pts, mid + 1, hi, m);
        double d = Math.min(d1, d2);

        Point[] strip = new Point[hi - lo + 1];
        m.allocate();
        int k = 0;
        double midX = pts[mid].x;
        for (int i = lo; i <= hi; i++) {
            if (Math.abs(pts[i].x - midX) < d) {
                strip[k++] = pts[i];
                m.allocate();
            }
        }
        sortByY(strip, 0, k - 1, m);

        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k && (strip[j].y - strip[i].y) < d; j++) {
                m.compare();
                d = Math.min(d, dist(strip[i], strip[j], m));
            }
        }
        m.exit();
        return d;
    }

    private static double bruteForce(Point[] pts, int lo, int hi, Metrics m) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = lo; i <= hi; i++) {
            for (int j = i + 1; j <= hi; j++) {
                m.compare();
                min = Math.min(min, dist(pts[i], pts[j], m));
            }
        }
        return min;
    }

    private static double dist(Point a, Point b, Metrics m) {
        m.compare();
        double dx = a.x - b.x, dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    private static void sortByX(Point[] pts, int lo, int hi, Metrics m) {
        if (lo >= hi) return;
        int mid = (lo + hi) >>> 1;
        sortByX(pts, lo, mid, m);
        sortByX(pts, mid + 1, hi, m);
        mergeByX(pts, lo, mid, hi, m);
    }

    private static void mergeByX(Point[] pts, int lo, int mid, int hi, Metrics m) {
        Point[] temp = new Point[hi - lo + 1];
        m.allocate();
        int i = lo, j = mid + 1, k = 0;
        while (i <= mid && j <= hi) {
            m.compare();
            if (pts[i].x <= pts[j].x) temp[k++] = pts[i++];
            else temp[k++] = pts[j++];
        }
        while (i <= mid) temp[k++] = pts[i++];
        while (j <= hi) temp[k++] = pts[j++];
        System.arraycopy(temp, 0, pts, lo, temp.length);
    }

    private static void sortByY(Point[] pts, int lo, int hi, Metrics m) {
        if (lo >= hi) return;
        int mid = (lo + hi) >>> 1;
        sortByY(pts, lo, mid, m);
        sortByY(pts, mid + 1, hi, m);
        mergeByY(pts, lo, mid, hi, m);
    }

    private static void mergeByY(Point[] pts, int lo, int mid, int hi, Metrics m) {
        Point[] temp = new Point[hi - lo + 1];
        m.allocate();
        int i = lo, j = mid + 1, k = 0;
        while (i <= mid && j <= hi) {
            m.compare();
            if (pts[i].y <= pts[j].y) temp[k++] = pts[i++];
            else temp[k++] = pts[j++];
        }
        while (i <= mid) temp[k++] = pts[i++];
        while (j <= hi) temp[k++] = pts[j++];
        System.arraycopy(temp, 0, pts, lo, temp.length);
    }
}