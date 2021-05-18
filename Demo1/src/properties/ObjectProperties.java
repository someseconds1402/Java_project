package properties;

import Oxyz.shape.Rectangular;

public class ObjectProperties {
	private float xA1;
	private float yA1;
	private float zA1;
	private float xB1;
	private float yB1;
	private float zB1;
	private float xC1;
	private float yC1;
	private float zC1;
	private float height;
	
	public ObjectProperties(Rectangular r) {
		xA1 = r.getA1().getX();
		yA1 = r.getA1().getY();
		zA1 = r.getA1().getZ();
		xB1 = r.getB1().getX();
		yB1 = r.getB1().getY();
		zB1 = r.getB1().getZ();
		xC1 = r.getC1().getX();
		yC1 = r.getC1().getY();
		zC1 = r.getC1().getZ();
		height = r.getH();
	}

	public float getXA1() {
		return xA1;
	}

	public void setXA1(float xA1) {
		this.xA1 = xA1;
	}

	public float getYA1() {
		return yA1;
	}

	public void setYA1(float yA1) {
		this.yA1 = yA1;
	}

	public float getZA1() {
		return zA1;
	}

	public void setZA1(float zA1) {
		this.zA1 = zA1;
	}

	public float getXB1() {
		return xB1;
	}

	public void setXB1(float xB1) {
		this.xB1 = xB1;
	}

	public float getYB1() {
		return yB1;
	}

	public void setYB1(float yB1) {
		this.yB1 = yB1;
	}

	public float getZB1() {
		return zB1;
	}

	public void setZB1(float zB1) {
		this.zB1 = zB1;
	}

	public float getXC1() {
		return xC1;
	}

	public void setXC1(float xC1) {
		this.xC1 = xC1;
	}

	public float getYC1() {
		return yC1;
	}

	public void setYC1(float yC1) {
		this.yC1 = yC1;
	}

	public float getZC1() {
		return zC1;
	}

	public void setZC1(float zC1) {
		this.zC1 = zC1;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

}
