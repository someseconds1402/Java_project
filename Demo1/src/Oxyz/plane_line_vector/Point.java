package Oxyz.plane_line_vector;

public class Point {
	private float x;
	private float y;
	private float z;
	
	//Constructor
	
	public Point() {
		x = 0;
		y = 0; 
		z = 0;
	}
	
	public Point(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	// Setter & Getter

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
	
	// Other Method
	
	public boolean isDifference(Point p) {
		return !(x == p.x && y == p.y && z == p.z);
	}
	
	public String getProperties() {
		return ("(" + x + ", " + y + ", " + z + ")");
	}
}
