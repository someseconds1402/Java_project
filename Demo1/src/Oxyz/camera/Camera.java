package Oxyz.camera;

import Oxyz.plane_line_vector.Plane;
import Oxyz.plane_line_vector.Point;
import Oxyz.plane_line_vector.Vector;
import Oxyz.room.Room;

public class Camera {
	private Point position; // vi tri dat camera
	private Vector axis; // truc cua camera
	
	private Plane []vision = new Plane[4]; // tam nhin cua camera (bao quanh boi 4 hinh tam giac)
	private Plane top;  // mat phang vuong goc voi truc cua camera tai dinh. 
						//Dung de kiem tra 1 vat co nam ngoai tam xa cua camera hay ko
	private float angle1, angle2;
	
	// Getter & Setter
	
	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
	}
	public Vector getAxis() {
		return axis;
	}
	public boolean setAxis(Room room) {
		if(position.getZ() == room.getHeightRoom()) {
			axis = new Vector(0, 0, 1);
			return true;
		} else if(position.getY() == room.getLengthRoom() || position.getY() == 0) {
			axis = new Vector(0, 1, 0);
			return true;
		} else if(position.getX() == room.getWidthRoom() || position.getX() == 0) {
			axis = new Vector(1, 0, 0);
			return true;
		} else {
			return false;
		}
	}
	public Plane[] getVision() {
		return vision;
	}
	public void setVision(Plane[] vision) {
		this.vision = vision;
	}
	public Plane getTop() {
		return top;
	}
	public void setTop() {
		top = new Plane(position, axis);
	}
	public float getAngle1() {
		return angle1;
	}
	public void setAngle1(float angle1) {
		this.angle1 = angle1;
	}
	public float getAngle2() {
		return angle2;
	}
	public void setAngle2(float angle2) {
		this.angle2 = angle2;
	}
	
	// Constructor
	
	public Camera(Room room, Point position, float angle1, float angle2) {
		this.position = position;
		this.angle1 = angle1;
		this.angle2 = angle2;
		float sinAngel1 = (float)Math.sin(Math.toRadians(angle1 / 2));
		float cosAngel1 = (float)Math.cos(Math.toRadians(angle1 / 2));
		float sinAngel2 = (float)Math.sin(Math.toRadians(angle2 / 2));
		float cosAngel2 = (float)Math.cos(Math.toRadians(angle2 / 2));
		
		if(setAxis(room)) {
			setTop();
			
			if(axis.getX() == 1) { // camera dat tren tuong (x = 0)
				vision[0] = new Plane(position, new Vector(-cosAngel1 * cosAngel1 +1, sinAngel1 * cosAngel1, 0));
				vision[1] = new Plane(position, new Vector(cosAngel1 * cosAngel1 -1, sinAngel1 * cosAngel1, 0));
				vision[2] = new Plane(position, new Vector(-cosAngel2 * cosAngel2 +1, 0, sinAngel2 * cosAngel2));
				vision[3] = new Plane(position, new Vector(cosAngel2 * cosAngel2 -1, 0, sinAngel2 * cosAngel2));

			} else if(axis.getY() == 1) { // camera dat tren tuong (y = 0)
				vision[0] = new Plane(position, new Vector(0, -cosAngel1 * cosAngel1 +1, sinAngel1 * cosAngel1));
				vision[1] = new Plane(position, new Vector(0, cosAngel1 * cosAngel1 -1, sinAngel1 * cosAngel1));
				vision[2] = new Plane(position, new Vector(sinAngel2 * cosAngel2, -cosAngel2 * cosAngel2 +1, 0));
				vision[3] = new Plane(position, new Vector(sinAngel2 * cosAngel2, cosAngel2 * cosAngel2 -1, 0));

			} else if(axis.getZ() == 1) { // camera dat tren tran (z = 0)
				vision[0] = new Plane(position, new Vector(sinAngel1 * cosAngel1, 0, -cosAngel1 * cosAngel1 +1));
				vision[1] = new Plane(position, new Vector(sinAngel1 * cosAngel1, 0, cosAngel1 * cosAngel1 -1));
				vision[2] = new Plane(position, new Vector(0, sinAngel2 * cosAngel2, -cosAngel2 * cosAngel2 +1));
				vision[3] = new Plane(position, new Vector(0, sinAngel2 * cosAngel2, cosAngel2 * cosAngel2 -1));

			}
		}
	}
	
	// Other Method
	
	public boolean isInVision(Point p) { // Kiem tra 1 vat co nam trong tam nhin cua camera hay ko
		if(top.distance(p) > 100) 
			return false;
		if(!Plane.isBetween2Planes(vision[0], vision[1], p))
			return false;
		if(!Plane.isBetween2Planes(vision[2], vision[3], p))
			return false;
		return true;
	}
	
}
