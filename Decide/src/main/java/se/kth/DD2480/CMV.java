package se.kth.DD2480;


public class CMV {
    public CMV() {
    }

    boolean lic0(double length, Point[] points) {
        if(points == null || points.length < 2 ){
            return false;
        }
        int l = points.length;
        for (int i = 0; i < l - 1; ++i) {
            if (points[i].distance(points[i + 1]) > length) return true;
        }
        return false;
    }

    boolean lic5(Point[] points){
        if (points == null || points.length < 2) {
            return false;
        }
        int l = points.length;
        for (int i = 0; i < l - 1; ++i) {
            if (points[i+1].x - (points[i].x) < 0) return true;
        }
        return false;
    }

    boolean lic10(Point[] points, int E_PTS, int F_PTS, double AREA1){
        if (points == null || points.length < 5 || !(E_PTS >= 1) || !(F_PTS >= 1)
        || !(E_PTS + F_PTS <= points.length - 3)) {
            return false;
        }
        for(int i = 0; i < points.length - (E_PTS + F_PTS + 2 ); ++i){
            Point p1 = points[i];
            Point p2 = points[i+E_PTS+1];
            Point p3 = points[i+E_PTS+1+F_PTS+1];

            double area = Point.triangleArea(p1, p2, p3);
            if(area > AREA1) return true;
        }
        return false;
    }
}
