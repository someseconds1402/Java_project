package Oxyz.test;

import Oxyz.plane_line_vector.Point;
import Oxyz.room.Room;
import Oxyz.shape.Rectangular;

public class Test {

	public static void main(String[] args) {
		Room room = new Room(10, 6, 5);
		
		Point p1 = new Point(2, 0, 0);
		Point p2 = new Point(0, 0, 0);
		Point p3 = new Point(0, 3, 0);
				
		if(room.addObject(p1, p2, p3, 1)) {
			System.out.println(1);
		}else {
			System.out.println(2);
		}
		
		Point p4 = new Point(1, 0, 0);
		Point p5 = new Point(0, 0, 0);
		Point p6 = new Point(0, 2, 0);
		
		if(room.addObject(p4, p5, p6, 1)) {
			System.out.println(1);
		}else {
			System.out.println(2);
		}
	}

}
