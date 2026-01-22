package se.kth.DD2480;

public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

     double distance (Point p2){
        return Math.sqrt(Math.pow(this.x - p2.x, 2) + Math.pow(this.y - p2.y, 2));
    }
    static double triangleArea(Point a, Point b, Point c) {
        return 0.5 * Math.abs(
                a.x * (b.y - c.y)
                        + b.x * (c.y - a.y)
                        + c.x * (a.y - b.y)
        );
    }

}
