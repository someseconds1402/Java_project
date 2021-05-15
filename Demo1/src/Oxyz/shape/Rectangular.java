package Oxyz.shape;

public class Rectangular {
	private Point A1;
	private Point B1;
	private Point C1;
	private float h; // height
	
	private Point D1;
	private Point A2;
	private Point B2;
	private Point C2;
	private Point D2;
	
	// Constructor
	
	public Rectangular(Point a1, Point b1, Point c1, float h) {
		super();
		A1 = a1;
		B1 = b1;
		C1 = c1;
		this.h = h;
		
		this.setD2();
		this.setA2();
		this.setB2();
		this.setC2();
		this.setD2();
	}

	// Setter and Getter
	
	public Point getA1() {
		return A1;
	}

	public void setA1(Point a1) {
		A1 = a1;
	}
	
	public Point getB1() {
		return B1;
	}

	public void setB1(Point b1) {
		B1 = b1;
	}

	public Point getC1() {
		return C1;
	}

	public void setC1(Point c1) {
		C1 = c1;
	}

	public float getH() {
		return h;
	}

	public void setH(float h) {
		this.h = h;
	}

	public Point getD1() {
		return D1;
	}

	public void setD1(Point d1) {
		D1 = d1;
	}
	
	public void setD1() {
		D1.setX(A1.getX() + C1.getX() - B1.getX());
		D1.setY(A1.getY() + C1.getY() - B1.getY());
		D1.setZ(A1.getZ() + C1.getZ() - B1.getZ());
	}

	public Point getA2() {
		return A2;
	}

	public void setA2(Point a2) {
		A2 = a2;
	}
	
	public void setA2() {
		A2.setX(A1.getX());
		A2.setY(A1.getY());
		A2.setZ(A1.getZ() + h);
	}

	public Point getB2() {
		return B2;
	}

	public void setB2(Point b2) {
		B2 = b2;
	}
	
	public void setB2() {
		B2.setX(B1.getX());
		B2.setY(B1.getY());
		B2.setZ(B1.getZ() + h);
	}

	public Point getC2() {
		return C2;
	}

	public void setC2(Point c2) {
		C2 = c2;
	}
	
	public void setC2() {
		C2.setX(C1.getX());
		C2.setY(C1.getY());
		C2.setZ(C1.getZ() + h);
	}

	public Point getD2() {
		return D2;
	}

	public void setD2(Point d2) {
		D2 = d2;
	}
	
	public void setD2() {
		D2.setX(D1.getX());
		D2.setY(D1.getY());
		D2.setZ(D1.getZ() + h);
	}
	
	/****************************************************************************/
	
	public boolean isIn(Point p) {
		
		return false;
	}
	
}
