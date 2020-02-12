
/**
 * extends Shape, allows class Circle to inherit Shape's instance methods and
 * instance varaibles
 */
public class Circle extends Shape {

	/** Instance variable for the circle class */
	private double radius;

	public Circle(double rad, double x, double y) {
		super(x, y);
		radius = rad;
	}

	public Circle() {
		super();
		radius = 0.0;
	}

	public void setRad(double x) {
		radius = x;
	}

	/**
	 * Returns Radius
	 * 
	 * @return
	 */
	public double getRad() {
		return radius;
	}

	/**
	 * Calculates and returns area of circle shape
	 */
	public double area() {
		area = Math.PI * (radius * radius);
		return area;
	}

	/**
	 * Calculates and returns circumference of circle
	 */
	public double circumference() {
		circumference = Math.PI * 2 * radius;
		return circumference;
	}

	public String toString() {
		return String.format(
				"\nOrigin: (%.2f,%.2f)\nArea: %.2f square units\nCircumference: %.2f units\nRadius: %.2f units",
				getOrigin().getX(), getOrigin().getY(), area, circumference, radius);
	}

}
