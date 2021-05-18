package Oxyz.test;

import Oxyz.camera.Camera;
import Oxyz.plane_line_vector.Line;
import Oxyz.plane_line_vector.Point;
import Oxyz.plane_line_vector.Vector;
import Oxyz.room.Room;
import Oxyz.shape.Rectangular;

public class Test {

	public static void main(String[] args) {
		Room room = new Room(10, 10, 10);
		
		Point p1 = new Point(1, 0, 0);
		Point p2 = new Point(0, 0, 0);
		Point p3 = new Point(0, 1, 0);
		Point p0 = new Point(1, 1, 1);
		
		Rectangular r1 = new Rectangular(p1, p2, p3, 10);
		
		Line l1 = new Line(p1, p2);
		Line l2 = new Line(p0, p3);
		
		System.out.println(Line.isBetween2Lines2(l1, l2, p0));
		System.out.println(Line.isBetween2Lines2(l1, l2, p3));
		System.out.println(Line.isBetween2Lines2(l1, l2, new Point(0.5f, 0.5f, 0)));
		System.out.println(Line.isBetween2Lines2(l1, l2, new Point(-2, 0, 0)));
				
		
				
//		if(room.addObject(p1, p2, p3, 1)) {
//			System.out.println(1);
//		}else {
//			System.out.println(2);
//		}
//		
//		Point p4 = new Point(2, 1, 0);
//		Point p5 = new Point(1, 1, 0);
//		Point p6 = new Point(1, 2, 0);
		
//		Rectangular r2 = new Rectangular(p4, p5, p6, 10);
		
//		System.out.println(r2.isInRect2(r1.getD1())); // D1 (r1) : (1, 1, 0)
//		System.out.println(r1.isInRect2(r2.getB1())); // B1 (r2) : (1, 1, 0)
		
//		System.out.println(r2.isValidPosition(r1));
//		System.out.println(r1.isValidPosition(r2));
		
//		if(room.addObject(p4, p5, p6, 1)) {
//			System.out.println(1);
//		}else {
//			System.out.println(2);
//		}
		
//		System.out.println(room.getRectList().size());
//		room.addCameara(p6, 10, 10);
//		room.addCameara(new Point(10, 1, 1), 10, 10);
//		
//		for(Camera camera : room.getCameraList()) {
//			System.out.println(1);
//		}
	}

}
