package AnonymousClass;

import edu.princeton.cs.algs4.*;

import java.util.Arrays;
import java.util.Comparator;

/*************************************************************************
 * Compilation: javac Original.Point.java Execution: Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 * @author Magnus M. Halldorsson, email: mmh@ru.is
 *************************************************************************/
public class Point implements Comparable<Point> {

    public final int x, y;

    /**
     * This comparator compares points according to their distance to another point.
     *
     * For example, let:
     * Point A = new Point(5,5);
     * Point B = new Point(1,1);
     * Point C = new Point(7,8);
     * Point D = new Point(4,5);
     * Point[] points = {B,C,D};
     *
     * Then sorting the array 'points' according to the comparator A.DISTANCE_ORDER:
     * Arrays.sort(points,A.DISTANCE_ORDER);
     *
     * The resulting order in 'points' is: D, C, B
     *
     * Here, we use what is called an 'anonymous class': we don't create a proper class for
     * the comparator, we just say we create a 'Comparator<Point>' object and give the code
     * for its function 'compare()'
     *
     * The comparator has access to the inner variables x and y of the point it is constructed from.
     */
    public final Comparator<Point> DISTANCE_ORDER = new Comparator<Point>(){
        public int compare(Point pointA, Point pointB) {
            // x and y would have to be replaced by Point.this.x and Point.this.y if we defined variables called x and y in here.
            int dxA = pointA.x - x, dyA = pointA.y - y;
            int dxB = pointB.x - x, dyB = pointB.y - y;

            double distanceA = Math.sqrt( dxA*dxA + dyA*dyA );
            double distanceB = Math.sqrt( dxB*dxB + dyB*dyB );

            return Double.compare(distanceA,distanceB);
        }
    };

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = null;

    private static int searchInArrayByDistanceToPoint(Point[] array, Point target, Point point){
        return Arrays.binarySearch(array, target, point.DISTANCE_ORDER);
    }

    // create the point (x, y)
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
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
        return 0;
    }

    /**
     * Is this point lexicographically smaller than that one? comparing
     * y-coordinates and breaking ties by x-coordinates
     */
    public int compareTo(Point that) {
        // TODO: Implement this
        return 0;
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
        In in = new In();
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
