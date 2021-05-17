package Oxyz.shape;

import Oxyz.plane_line_vector.Line;
import Oxyz.plane_line_vector.Plane;
import Oxyz.plane_line_vector.Point;
import Oxyz.plane_line_vector.Vector;

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
		A1 = a1;
		B1 = b1;
		C1 = c1;
		this.h = h;
		
		D1 = new Point();
		A2 = new Point();
		B2 = new Point();
		C2 = new Point();
		D2 = new Point();
		
		this.setD1();
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
	
	/** Kiem tra 1 diem co nam trong vat the hay khong */
	public boolean isIn(Point p) {
		float n1, n2, n3, n4, n5, n6;
		Plane pl1, pl2, pl3, pl4, pl5, pl6;
		pl1 = new Plane(A1, B1, C1); 	 // Mat phang A1.B1.C1.D1 (1)
		pl2 = new Plane(A1, B1, A2); 	 // Mat phang A1.B1.B2.A2 (2)
		pl3 = new Plane(A1, D1, A2); 	 // Mat phang A1.D1.D2.A2 (3)
		pl4 = new Plane(A2, pl1.getV()); // Mat phang A2.B2.C2.D2 (1)
		pl5 = new Plane(C1, pl2.getV()); // Mat phang C1.D1.D2.C2 (2)
		pl6 = new Plane(B1, pl3.getV()); // Mat phang B1.C1.C2.B2 (3)
		
		n1 = pl1.doSomething(p);
		n4 = pl4.doSomething(p);

		if(n1*n4 > 0) {
			return false;
		}
		
		n2 = pl2.doSomething(p);
		n5 = pl5.doSomething(p);
		if(n2*n5 > 0f) {
			return false;
		}
		
		n3 = pl3.doSomething(p);
		n6 = pl6.doSomething(p);
		if(n3*n6 > 0f) {
			return false;
		}
		
		return true;
	}
	
	
	/** Xac dinh 3 diem dau vao co tao thanh 1 goc vuong hay ko */
	public boolean isPerpendicular() {
		Vector u1 = new Vector(A1, B1);
		Vector u2 = new Vector(B1, C1);
		return (u1.getX()*u2.getX() + u1.getY()*u2.getY() + u1.getZ()*u2.getZ()) == 0;
	}
	
	
	public boolean isInRect(Line l1, Line l2, Line l3, Line l4, Point p) { // Xac dinh 1 diem co nam trong day cua vat the hay khong
		if(Line.isBetween2Lines(l1, l2, p) && Line.isBetween2Lines(l3, l4, p)) {
			return true;
		}
		
		return false;
	}
	
	public boolean isValidPosition(Rectangular r) { // dinh cua 1 vat the co nam trong vat the khac hay khong
		Line AB = new Line(A1, B1);
		Line CD = new Line(C1, AB.getU());
		Line AD = new Line(A1, D1);
		Line BC = new Line(B1, AD.getU());
		
		if(isInRect(AB, CD, AD, BC, r.getA1()))
			return true;
		if(isInRect(AB, CD, AD, BC, r.getB1()))
			return true;
		if(isInRect(AB, CD, AD, BC, r.getC1()))
			return true;
		if(isInRect(AB, CD, AD, BC, r.getD1()))
			return true;
		
		return false;
	}
	
	public boolean isInRect(Point p) { // Xac dinh 1 diem co nam trong day cua vat the hay khong
		Line AB = new Line(A1, B1);
		Line CD = new Line(C1, AB.getU());
		Line AD = new Line(A1, D1);
		Line BC = new Line(B1, AD.getU());
		
		if(Line.isBetween2Lines(AB, CD, p) && Line.isBetween2Lines(AD, BC, p)) {
			return true;
		}
		
		return false;
	}
}
