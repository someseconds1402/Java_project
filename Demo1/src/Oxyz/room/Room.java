package Oxyz.room;

import java.util.ArrayList;

import Oxyz.camera.Camera;
import Oxyz.plane_line_vector.Point;
import Oxyz.plane_line_vector.Vector;
import Oxyz.shape.Rectangular;

public class Room {
	private ArrayList<Rectangular> rectList = new ArrayList<>();
	private ArrayList<Camera> cameraList = new ArrayList<>();
//	private Rectangular room;
	
	private float widthRoom;
	private float lengthRoom;
	private float heightRoom;
	
	
	// Constructor
	
	public Room(float widthRoom, float lengthRoom, float heightRoom) {
		this.widthRoom = widthRoom;
		this.lengthRoom = lengthRoom;
		this.heightRoom = heightRoom;
	}
	
	public Room(Point pWidth, Point pLength, Point pHeight) {
		widthRoom = pWidth.getX();
		lengthRoom = pLength.getY();
		heightRoom = pHeight.getZ();
	}
	
	// Getter & Setter
	
	public ArrayList<Rectangular> getRectList() {
		return rectList;
	}
	public void setRectList(ArrayList<Rectangular> rectList) {
		this.rectList = rectList;
	}
	public ArrayList<Camera> getCameraList() {
		return cameraList;
	}
	public void setCameraList(ArrayList<Camera> cameraList) {
		this.cameraList = cameraList;
	}
	public float getWidthRoom() {
		return widthRoom;
	}
	public void setWidthRoom(float widthRoom) {
		this.widthRoom = widthRoom;
	}
	public float getLengthRoom() {
		return lengthRoom;
	}
	public void setLengthRoom(float lengthRoom) {
		this.lengthRoom = lengthRoom;
	}
	public float getHeightRoom() {
		return heightRoom;
	}
	public void setHeightRoom(float heightRoom) {
		this.heightRoom = heightRoom;
	}
	
	// Other Method
	
	/**********************************************************************/
	
	/** 
	 * Them vat vao trong phong, kiem tra vi tri dat vat co hop le hay ko. 
	 * xet truong hop vat nam tren san va nam tren vat khac
	 *  */
	public boolean addObject(Point A1, Point B1, Point C1, float height) {
//		boolean check = Vector.isPerpendicular(A1, B1, C1);
//		if(!check) {
//			return false;
//		} else {
			Rectangular r = new Rectangular(A1, B1, C1, height);
			return addObject(r);
//		}
	}
	
	/** 
	 * Them vat vao trong phong, kiem tra vi tri dat vat co hop le hay ko. 
	 * xet truong hop vat nam tren san va nam tren vat khac
	 *  */
	public boolean addObject(Rectangular r) { 
		if(inRoom(r)) { // vi tri dat vat hop le (nam trong phong)
			float bottom = r.getA1().getZ();
			if(bottom > 0) { // Neu vat khong nam tren san
				
				float Gx = (r.getA1().getX() + r.getC1().getX()) / 2;
				float Gy = (r.getA1().getY() + r.getC1().getY()) / 2;
				float Gz = (r.getA1().getZ() + r.getC1().getZ()) / 2;
				
				Point G = new Point(Gx, Gy, Gz); // G la trong tam mat duoi cua vat the r
				
				for(Rectangular rect : rectList) {
					if(bottom < rect.getH()) {
						if(rect.isValidPosition(r) || r.isValidPosition(rect))
							return false;
					} else if(bottom == rect.getH()) {
						if(rect.isInRect(G)) {
							rectList.add(r);
							return true;
						}
					}
				}
				
				return false;
			} else {
				for(Rectangular rect : rectList) {
					if(rect.isValidPosition(r))
						return false;
					if(r.isValidPosition(rect))
						return false;
				}
				rectList.add(r);
				return true;
			}
		} else { // Vi tri dat vat nam ngoai phong
			return false;
		}
	}
	
	/** Xac dinh 1 vat co nam trong phong hay ko  */
	public boolean inRoom(Rectangular r) {
		if(!inRoom(r.getA1())) {
			return false;
		}
		if(!inRoom(r.getB1())) {
			return false;
		}
		if(!inRoom(r.getC1())) {
			return false;
		}
		if(!inRoom(r.getD1())) {
			return false;
		}
		if(r.getA2().getZ() > heightRoom) {
			return false;
		}
		return true;
	}
	
	/** Xac dinh 1 diem co nam trong phong hay ko */
	public boolean inRoom(Point p) {
		return !(p.getX() > widthRoom || p.getX() < 0 || p.getY() > lengthRoom || p.getY() < 0);
	}
	
	/**********************************************************************/

	/**  Xac dinh diem dat camera co hop le hay khong */
	public boolean isValidPosition(Point p) { 
		if(p.getZ() == heightRoom) {
			return true;
		} else if(p.getY() == lengthRoom || p.getY() == 0) {
			return true;
		} else if(p.getX() == widthRoom || p.getX() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/** Them camera vao phong, xac dinh vi tri dat co hop le hay ko */
	public boolean addCameara(Point position, float angle1, float angle2) {
		if(isValidPosition(position)) {
			cameraList.add(new Camera(this, position, angle1, angle2));
			return true;
		} else {
			return false;
		}	
	}
	
	/**********************************************************************/
	
	
}
