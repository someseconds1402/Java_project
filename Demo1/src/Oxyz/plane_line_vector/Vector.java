package Oxyz.plane_line_vector;

import Oxyz.shape.Point;

public class Vector {
	private float x;
	private float y;
	private float z;
	
	public Vector(float x, float y, float z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector(Point p1, Point p2) {
		x = p1.getX() - p2.getX();
		y = p1.getY() - p2.getY();
		z = p1.getZ() - p2.getZ();
	}
	
	public Vector(Vector v1, Vector v2) {
		/* Nhan co huong 2 vector [v1(a1, b1, c1) , v2(a2, b2, c2)] = v3(a3, b3, c3)
		 * 
		 * a3 = b1*c2 - b2*c1
		 * b3 = c1*a2 - c2*a1
		 * c3 = a1*b2 - a2*b1
		 */
		x = v1.getY()*v2.getZ() - v2.getY()*v1.getZ();
		y = v1.getZ()*v2.getX() - v2.getZ()*v1.getX();
		z = v1.getX()*v2.getY() - v2.getX()*v1.getY();
	}
	
	public float getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public float getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	
	// Other Method
}
