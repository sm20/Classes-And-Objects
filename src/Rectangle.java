
/**
 * extends Shape, allows class Rectangle to inherit Shape's instance methods and
 * instance varaibles
 */
public class Rectangle extends Shape {

	/** Instance variables for the rect class */
	private double length;
	private double width;

	public Rectangle(double l, double w, double x, double y) {
		/** calls constructor that sets x and y values in shape */
		super(x, y);
		length = l;
		width = w;
	}

	public Rectangle() {
		/**
		 * calls constructor that initializes x and y to zero from shape. ALso
		 * sets length and width to zero
		 */
		super();
		length = 0.0;
		width = 0.0;
	}

	public void setLength(double x) {
		this.length = x;
	}

	public void setWidth(double x) {
		this.width = x;
	}

	public void setLW(double x, double y) {
		setLength(x);
		setWidth(y);
	}

	public double getL() {
		return length;
	}

	public double getW() {
		return width;
	}

	/**
	 * This does not override the method area in shape Also, in order to change
	 * the value of area, you have to call r1.area() method, where r1 is an
	 * object of this rectangle class after that if u print r1.area (the
	 * variable), it will print the changed value. s1.area(area from superclass
	 * shape) will still have the same value of 0.0, it wont be changed.
	 */
	public double area() {
		area = length * width;
		return area;
	}

	public double circumference() {
		circumference = (2 * length) + (2 * width);
		return circumference;
	}

	public String toString() {

		/**
		 * getOrigin is an object that references to the Shape class and then
		 * the Point class, similar to what the first constructor in Shape is
		 * doing. getOrigin returns origin. the 'super' on getOrigin, tells us
		 * to call the method getOrigin from the superClass super.method()
		 * invokes the method EXACTLY as it is in the superclass, refer to feb
		 * 24 screen print
		 */
		return String.format(
				"\nOrigin: (%.2f,%.2f)\nArea: %.2f square units\nCircumference: %.2f units\nLength: %.2f units,\nWidth: %.2f units",
				getOrigin().getX(), getOrigin().getY(), area, circumference, length, width);
	}

}
