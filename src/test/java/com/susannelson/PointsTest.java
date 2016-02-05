package com.susannelson;

import com.susannelson.domain.Point;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;

public class PointsTest {

    @Test
    public void testMiddlePoint() throws Exception {

    }

    @Test
    public void testGetNearestThreePoints() throws Exception {

        Set<Point> points = new HashSet<>(4);
        points.add(new Point(30,30));
        points.add(new Point(10,30));
        points.add(new Point(10,12));
        points.add(new Point(0 ,0));

        Set<Point> result = Points.getNearestThreePoints(points, new Point(11, 12));

        assertTrue(result != null && result.size() == 3);
    }
}