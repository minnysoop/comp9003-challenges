import java.util.Objects;

public class Line {
	
	public static Point2D findPoint(Point2D a, Point2D b, double d) {
		//d can only be between 0 and 1, return null if it not.
		if (d > 1 || d < 0) return null;
		//Find the point that 
		double x = a.getX() + (b.getX() - a.getX()) * d;
		double y = a.getY() + (b.getY() - a.getY()) * d;

		Point2D r = new Point2D(x,y);
		return r;
	}

	public static void main(String[] args) {
		
	}
	
}
