public class Point2D {
    private double x;
    private double y;

    Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double[] getCoords() {
        double[] coord = {this.x, this.y};
        return coord;
    }
}
