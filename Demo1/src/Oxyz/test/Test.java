package Oxyz.test;

import Oxyz.plane_line_vector.Line;
import Oxyz.plane_line_vector.Point;
import Oxyz.plane_line_vector.Vector;
import Oxyz.shape.Rectangular;

public class Test {

	public static void main(String[] args) {
		Point a1 = new Point(5, 0, 0);
		Point b1 = new Point(0, 0, 0);
		Point c1 = new Point(0, 7, 0);
		
		Point p = new Point(2, 5, 8);
		
		Rectangular r = new Rectangular(a1, b1, c1, 8);

		
//		Point a2 = new Point(7, 0, 0);
//		Point b2 = new Point(2, 0, 0);
//		Point c2 = new Point(2, 8, 0);
//		
//		
//		Rectangular r2 = new Rectangular(a2, b2, c2, 8);
//		System.out.println(r2.isValidPosition(r));

		
//		System.out.println(r.isInRect(p));
//		System.out.println(Vector.isPerpendicular(a1, b1, c1));
//		System.out.println(r.isPerpendicular());
//		System.out.println(r.getB2().getX());;
//		System.out.println(r.isIn(p));

		
//		Point a = new Point(-1, 0, 0);
//		Point b = new Point(0, 1, 0);
//		Point c = new Point(0, -2, 0);
//		Point d = new Point(0, 3, 0);
//		
//		Line l1 = new Line(a, b);
//		Line l2 = new Line(c, l1.getU());
//		System.out.println(Line.isBetween2Lines(l1, l2, d));
	}

}
