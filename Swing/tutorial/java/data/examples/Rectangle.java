public class Rectangle {
    /** The width of this rectangle. */
    public int width;

    /** The height of this rectangle. */
    public int height;

    /** The origin (lower-left corner) of this rectangle. */
    public Point origin;

    /**
     * Creates a rectangle with the specified size.
     * The origin is (0, 0).
     * @param w width of the rectangle
     * @param h height of the rectangle
     */
    public Rectangle(int w, int h) {
	this(new Point(0, 0), w, h);
    }

    /**
     * Creates a rectangle with the specified origin and
     * size.
     * @param p origin of the rectangle
     * @param w width of the rectangle
     * @param h height of the rectangle
     */
    public Rectangle(Point p, int w, int h) {
	origin = p;
	width = w;
	height = h;
    }

    /**
     * Moves the rectangle to the specified origin.
     */
    public void move(int x, int y) {
	origin.x = x;
	origin.y = y;
    }

    /**
     * Returns the computed area of the rectangle.
     */
    public int area() {
	return width * height;
    }
}
