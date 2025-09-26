package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClosestPairTest {

    @Test
    void testTwoPoints() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(3, 4)
        };
        assertEquals(5.0, ClosestPair.closestPair(pts), 1e-6);
    }

    @Test
    void testDuplicatePoints() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(1, 1),
                new ClosestPair.Point(1, 1)
        };
        assertEquals(0.0, ClosestPair.closestPair(pts), 1e-9);
    }

    @Test
    void testSimpleTriangle() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(1, 0),
                new ClosestPair.Point(2, 0)
        };
        assertEquals(1.0, ClosestPair.closestPair(pts), 1e-6);
    }

    @Test
    void testSquare() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(0, 1),
                new ClosestPair.Point(1, 0),
                new ClosestPair.Point(1, 1)
        };
        assertEquals(1.0, ClosestPair.closestPair(pts), 1e-6);
    }

    @Test
    void testRandomSet1() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(2, 3),
                new ClosestPair.Point(12, 30),
                new ClosestPair.Point(40, 50),
                new ClosestPair.Point(5, 1),
                new ClosestPair.Point(12, 10),
                new ClosestPair.Point(3, 4)
        };
        assertEquals(Math.sqrt(2), ClosestPair.closestPair(pts), 1e-6);
    }

    @Test
    void testHorizontalLine() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(1, 0),
                new ClosestPair.Point(2, 0),
                new ClosestPair.Point(3, 0)
        };
        assertEquals(1.0, ClosestPair.closestPair(pts), 1e-6);
    }

    @Test
    void testVerticalLine() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(0, 1),
                new ClosestPair.Point(0, 2),
                new ClosestPair.Point(0, 3)
        };
        assertEquals(1.0, ClosestPair.closestPair(pts), 1e-6);
    }

    @Test
    void testDiagonal() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(1, 1),
                new ClosestPair.Point(2, 2)
        };
        assertEquals(Math.sqrt(2), ClosestPair.closestPair(pts), 1e-6);
    }

    @Test
    void testLargeSpread() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(-1000, -1000),
                new ClosestPair.Point(1000, 1000),
                new ClosestPair.Point(-999, -999)
        };
        assertEquals(Math.sqrt(2), ClosestPair.closestPair(pts), 1e-6);
    }

    @Test
    void testClusteredPoints() {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(0.1, 0.1),
                new ClosestPair.Point(5, 5),
                new ClosestPair.Point(10, 10)
        };
        assertEquals(Math.sqrt(0.02), ClosestPair.closestPair(pts), 1e-6);
    }
}