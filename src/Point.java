import edu.princeton.cs.algs4.*;

import java.util.Comparator;

/*************************************************************************
 * Compilation: javac Point.java Execution: Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 * @author Magnus M. Halldorsson, email: mmh@ru.is
 *************************************************************************/
public class Point implements Comparable<Point> {

    public final int x, y;

    // compare points by slope
    public Comparator<Point> SLOPE_ORDER;

    public class SLOPE_ORDER implements Comparator<Point>
    {
        public int compare(Point p1, Point p2)
        {
            double firstSlope = slopeTo(p1);
            double secondSlope = slopeTo(p2);
            //Compare : returns 0 if the firstSlope is equal to the second
            //          -1 if its lower, 1 if its higher
            return Double.compare(firstSlope, secondSlope);
        }
    }

    // create the point (x, y)
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        SLOPE_ORDER = new SLOPE_ORDER();
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        // TODO: Implement this
        double slope;

        if(this.x == that.x && this.y == that.y)
        {
            slope = Double.NEGATIVE_INFINITY;
        }
        if(this.y == that.y)
        {
            //The line is straight
            return 0.0;
        }
        if(this.x == that.x)
        {
            slope = Double.POSITIVE_INFINITY;
        }

        else
        {
            double y1,y2,x1,x2;
            y2 = that.y;
            y1 = this.y;
            x2 = that.x;
            x1 = this.x;
            //formula for finding the slope of a line m = deltaY/deltaX
            slope = (y2-y1)/(x2-x1);
        }
        return slope;
    }

    /**
     * Is this point lexicographically smaller than that one? comparing
     * y-coordinates and breaking ties by x-coordinates
     */
    public int compareTo(Point that)
    {
        if(that == null)
        {
            throw new java.lang.NullPointerException();
        }

        int point;
        point = this.y - that.y;

        if(point == 0)
        {
            point = this.x - that.x;
        }
        return Integer.compare(point, 0);

    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        /*
         * Do not modify
         */
        In in = new In("testinput/mystery10089.txt");
        Out out = new Out();
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt(), y = in.readInt();
            points[i] = new Point(x, y);
        }
        out.printf("Testing slopeTo method...\n");
        for (int i = 1; i < points.length; i++) {
            out.println(points[i].slopeTo(points[i - 1]));
        }
        out.printf("Testing compareTo method...\n");
        for (int i = 1; i < points.length; i++) {
            out.println(points[i].compareTo(points[i - 1]));
        }
        out.printf("Testing SLOPE_ORDER comparator...\n");
        for (int i = 2; i < points.length; i++) {
            out.println(points[i].SLOPE_ORDER.compare(points[i - 1],
                    points[i - 2]));
        }
    }
}
