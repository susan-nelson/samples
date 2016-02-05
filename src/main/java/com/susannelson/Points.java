package com.susannelson;

import com.susannelson.domain.Point;

import java.util.*;

public class Points {

    public static Point middlePoint (Point p1, Point p2) {
        return new Point ((p1.getX() + p2.getX()) / 2, (p1.getY() + p2.getY()) / 2);
    }

    //get the three points that are closest to the target poing
    public static Set<Point> getNearestThreePoints(Set<Point> points, Point target) {

        if (points.size() < 4) {
            return points;
        }

        return buildNearestPointsList(getDistanceMap(points, target));
    }

    private static Map<Double, Set<Point>> getDistanceMap(Set<Point> points, Point target) {

        Map<Double, Set<Point>> pointDistance = new TreeMap<>();
        Set<Point> distancePoints;

        for (Point pt: points) {

            double distance = pt.distanceFrom(target);

            if (pointDistance.containsKey(distance)) {

                distancePoints = pointDistance.get(distance);
                distancePoints.add(pt);
            } else {
                distancePoints = new HashSet<>(3);
                distancePoints.add(pt);
                pointDistance.put(distance, distancePoints);
            }
        }

        return pointDistance;
    }

    private static Set<Point> buildNearestPointsList(Map<Double, Set<Point>> pointDistance) {

        Set<Double> distances = pointDistance.keySet();
        Set<Point> nearest = new HashSet<>(3);
        Set<Point> distancePoints;

        for (Double distance: distances) {

            distancePoints = pointDistance.get(distance);

            for (Point pt: distancePoints) {

                if (nearest.size() < 3) {
                    nearest.add(pt);
                } else {
                    break;
                }
            }

            if (nearest.size() >= 3) {

                break;
            }
        }

        return nearest;
    }
}
