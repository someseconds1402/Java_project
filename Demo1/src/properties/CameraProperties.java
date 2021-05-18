package properties;

import Oxyz.camera.Camera;

public class CameraProperties {
	private double x;
	private double y;
	private double z;
	private double angle1;
	private double angle2;
	
	public CameraProperties(Camera camera) {
		x = camera.getPosition().getX();
		y = camera.getPosition().getY();
		z = camera.getPosition().getZ();
		angle1 = camera.getAngle1();
		angle2 = camera.getAngle2();
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public double getAngle1() {
		return angle1;
	}

	public void setAngle1(double angle1) {
		this.angle1 = angle1;
	}

	public double getAngle2() {
		return angle2;
	}

	public void setAngle2(double angle2) {
		this.angle2 = angle2;
	}
}
