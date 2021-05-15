package Oxyz.test;

import Oxyz.plane_line_vector.Point;
import Oxyz.shape.Rectangular;

public class Test {

	public static void main(String[] args) {
		Point a1 = new Point(5, 0, 0);
		Point b1 = new Point(0, 0, 0);
		Point c1 = new Point(0, 7, 0);
		
		Point p = new Point(2, 3, 8);
		
		Rectangular r = new Rectangular(a1, b1, c1, 8);
		
//		System.out.println(r.isPerpendicular());
//		System.out.println(r.getB2().getX());;
//		System.out.println(r.isIn(p));

	}

}
