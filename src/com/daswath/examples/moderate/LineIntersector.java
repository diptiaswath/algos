package com.daswath.examples.moderate;

/**
 * Created by DAswath on 10/12/2016.
 */
public class LineIntersector {


    public Point intersection(Point start1, Point end1, Point start2, Point end2) {

        // step 1 rearrange so starts is before ends
        if (start1.x > end1.x) {
            swapPoints(start1, end1);
        }
        if (start2.x > end2.x) {
            swapPoints(start2, end2);
        }

        // rearrange so point1 is before point2 (ie., x values and y values of point1 is before that of point2)
        if (start1.x > start2.x) {
            swapPoints(start1, start2);
            swapPoints(end1, end2);
        }

        // step 2 Make 2 lines from the points
        Line line1 = new Line(start1, end1);
        Line line2 = new Line(start2, end2);

        // if 2 lines have the same slope, then they must be the same line i.e., should have the same y intercept
        if (line1.slope == line2.slope) {
            if (line1.yIntercept == line2.yIntercept && isBetweenPoints(start1, start2, end2)) {
                return start1;
            }
            return null;
        }

        // if 2 lines do not have the same slope, get the intersection point
        double x = (line2.yIntercept - line1.yIntercept) / (line2.slope - line1.slope);
        double y = line1.slope * x + line1.yIntercept;

        Point intersection = new Point(x, y);

        if (isBetweenPoints(start1, intersection, end1) && isBetweenPoints(start2, intersection, end2)) {
            return intersection;
        }

        return null;
    }

    private boolean isBetween(double start, double middle, double end) {
        if (start < end) {
            return middle >= start && middle <= end;
        }
        return middle <= start && middle >= end;
    }

    private boolean isBetweenPoints(Point start, Point middle, Point end) {
        return isBetween(start.x, middle.x, end.y) && isBetween(start.y, middle.y, end.y);
    }

    public void swapPoints(Point p1, Point p2) {
        double x = p1.x;
        double y = p1.y;

        p1.setLocation(p2.x, p2.y);
        p2.setLocation(x, y);
    }
}
