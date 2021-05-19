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
	
	public boolean compare(Point p) {
		if(x != p.x)
			return false;
		if(y != p.y)
			return false;
		if(z != p.z)
			return false;
		return true;
	}
	
	public boolean isBetween2Points(Point p1, Point p2) { 
		// Xac dinh diem p co nam giua 2 diem p1 va p2 hay ko
		// Chi ap dung cho 3 diem thang hang
		// Neu (p1 -p)(p2 - p) < 0 -> diem p nam giua p1 va p2
		
		if(compare(p1) || compare(p2))
			return false;
		
		if((p1.x - this.x)*(p2.x - this.x) > 0)
			return false;
		if((p1.y - this.y)*(p2.y - this.y) > 0)
			return false;
		if((p1.z - this.z)*(p2.z - this.z) > 0)
			return false;
		
		return true;
	}
}
