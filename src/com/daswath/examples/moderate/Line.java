package com.daswath.examples.moderate;

/**
 * Created by DAswath on 10/12/2016.
 */
public class Line {
    public double slope, yIntercept;

    public Line(Point start, Point end) {
        double deltaX = end.x - start.x;
        double deltaY = end.y - start.y;

        slope = deltaY / deltaX;
        yIntercept = end.y - slope * end.x;
    }

}
