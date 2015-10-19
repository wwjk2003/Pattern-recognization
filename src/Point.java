/*************************************************************************
 * Name:
 * Email:
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Arrays;
import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>() {
    	public int compare(Point p, Point q) 
    	{
    		return (int)(slopeTo(p) - slopeTo(q));
    	
    	
    	}
			
		
	};       // YOUR DEFINITION HERE

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
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
       if (that.x == this.x && that.y > this.y) return Double.POSITIVE_INFINITY;
       if (that.x == this.x && that.y < this.y) return Double.NEGATIVE_INFINITY;
       if (that.y == this.y && that.x < this.x) return -0;
       if (that.y == this.y && that.x >= this.x) return +0;
       double a = (double)(that.y - this.y)/(that.x - this.x);
       if (a >0) return a;
       else	return a*(-1); 
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
    	if (that.y == this.y && this.x >that.x ) return 1;
    	if (that.y == this.y && this.x <that.x ) return -1;
    	if (that.y > this.y) return -1;
    	if (that.y < this.y ) return 1;
        return 0;
			
        }
    

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        Point a = new Point(70, 30);
        Point b = new Point(0, 100);
        Point c = new Point(30, 70);
        Point[] pp =new Point[3];
        pp[0]=a;
        pp[1]=b;
        pp[2]=c;
        Arrays.sort(pp,2,3);
        for (Point p :pp)
        	System.out.println(p.toString());
        StdDraw.setXscale(-20,100 );
        StdDraw.setYscale(-20, 100);
        StdDraw.show(0);
        StdDraw.setPenRadius(0.01);  // make the points a bit larger
               double s = a.slopeTo(a);
        a.draw();
        b.draw();
        a.drawTo(b);
        StdDraw.show(0);
System.out.println(c.compareTo(b)+" "+s);
       
    }
}