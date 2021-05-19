package Oxyz.test;

import Oxyz.camera.Camera;
import Oxyz.plane_line_vector.Line;
import Oxyz.plane_line_vector.Plane;
import Oxyz.plane_line_vector.Point;
import Oxyz.plane_line_vector.Vector;
import Oxyz.room.Room;
import Oxyz.shape.Rectangular;

public class Test {

	public static void main(String[] args) {
		Room room = new Room(100, 100, 100);
		
		Point p0 = new Point(4, 0, 0);
		Point p1 = new Point(3, 0, 0);
		Point p2 = new Point(3, 20, 0);
		
		Point p3 = new Point(5, 5, 5);
		Point p4 = new Point(0, 5, 5);
		
		Plane pl1 = new Plane(p1, p2, new Point(3, 0, 1));
		Plane pl2 = new Plane(p1, p2, p0);
//		pl2.print();
		
		Rectangular rect = new Rectangular(p0, p1, p2, 20);
		
//		Camera camera = new Camera(room, new Point(0, 5, 5), 90, 90);
		
		room.addObject(rect);
		room.addCameara(p4, 90, 90);
		
		Point p5 = rect.intersection(new Line(p3, p4));
		
		Point p6 = (new Line(p3, p4)).intersection(pl2);
		
		if(p6 == null) {
			System.out.println(1);
		}
		System.out.println(p5.getProperties());
		
		System.out.println();
		
	}

}
