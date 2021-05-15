package Oxyz.plane_line_vector;

public class Line {
	/* 
	 * M(x0, y0, z0) & u = (a, b, c)
	 * Phuong trinh tham so cua duong thang
	 * x = x0 + a*t
	 * y = y0 + b*t
	 * z = z0 + c*t
	 */
	private float x;
	private float y;
	private float z;
	
	private Vector u; // Vector chi phuong


	// Constructor
	
	public Line(Point p1, Point p2) {
		u = new Vector(p1, p2);
		x = p1.getX();
		y = p1.getY();
		z = p1.getZ();
	}
	
	
	// Getter & Setter
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public Vector getU() {
		return u;
	}

	public void setU(Vector u) {
		this.u = u;
	}
	
	
}
