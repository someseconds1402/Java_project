package Oxyz.plane_line_vector;

public class Line {
	/* 
	 * M(x0, y0, z0) & u = (a, b, c)
	 * Phuong trinh tham so cua duong thang
	 * x = x0 + a*t
	 * y = y0 + b*t
	 * z = z0 + c*t
	 */
	private float x;
	private float y;
	private float z;
	
	private Vector u; // Vector chi phuong


	// Constructor
	
	public Line(Point p1, Point p2) {
		u = new Vector(p1, p2);
		x = p1.getX();
		y = p1.getY();
		z = p1.getZ();
	}
	
	public Line(Point p, Vector v) {
		u = v;
		x = p.getX();
		y = p.getY();
		z = p.getZ();
	}
	
	// Getter & Setter
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public Vector getU() {
		return u;
	}

	public void setU(Vector u) {
		this.u = u;
	}
	
	// Other Method
	
	public static boolean isBetween2Lines(Line l1, Line l2, Point p) { 
		/*
		 * Xac dinh 1 diem co nam giua 2 duong thang hay khong
		 * Bo qua truc Oz, tinh toan nhu tren mat phang
		 * M(x0, y0, z0) & u = (a, b, c)
		 * Thay toa do diem M vao phuong trinh tham so duong thang l
		 * result = (x-x0)/a - (y-y0)/b
		 */
		float exp1 = (p.getX() - l1.getX()) / l1.getU().getX() - (p.getY() - l1.getY()) / l1.getU().getY();
		float exp2 = (p.getX() - l2.getX()) / l2.getU().getX() - (p.getY() - l2.getY()) / l2.getU().getY();
		
		if(exp1 * exp2 > 0) {
			return false;
		}
		return true;
	}
	
	public static boolean isBetween2Lines2(Line l1, Line l2, Point p) { 
		/*
		 * Xac dinh 1 diem co nam giua 2 duong thang hay khong, truong hop diem nam tren 1 duong thang, tra ve false
		 * Bo qua truc Oz, tinh toan nhu tren mat phang
		 * M(x0, y0, z0) & u = (a, b, c)
		 * Thay toa do diem M vao phuong trinh tham so duong thang l
		 * result = (x-x0)/a - (y-y0)/b = c * ( b*(x-x0) - a*(y-y0) ) (Neu c < 0 => result = -result)
		 */
		float exp1 = (p.getX() - l1.getX()) * l1.getU().getY() - (p.getY() - l1.getY()) * l1.getU().getX();
		if(l1.getU().getX() * l1.getU().getY() < 0)
			exp1 = -exp1;
		
		float exp2 = (p.getX() - l2.getX()) * l2.getU().getY() - (p.getY() - l2.getY()) * l2.getU().getX();
		if(l2.getU().getX() * l2.getU().getY() < 0)
			exp2 = -exp2;

		if(exp1 * exp2 >= 0) {
			return false;
		}
		return true;
	}
	
	/*
	 * Ham tim giao diem giua duong thang va mat phang
	 * d :
	 * x = x0 + at
	 * y = y0 + bt
	 * z = z0 + ct
	 * 
	 * S :
	 * a'x + b'y + c'z + d = 0
	 * 
	 * d = S
	 * =>a'(x0 + at) + b'(y0 + bt) + c'(Z0 + ct) + d = 0
	 * => t(a'a + b'b + c'c) = -(a'x0 + b'y0 + c'z0 + d)
	 * => t = -(a'x0 + b'y0 + c'z0 + d) / (a'a + b'b + c'c)
	 */
	
	public Point intersection(Plane pl) {

		float denominator = (pl.getA()*u.getX() + pl.getB()*u.getY() + pl.getC()*u.getZ());
		
		if(denominator == 0)
			return null;
		
		float t = -(pl.getA()*x + pl.getB()*y + pl.getC()*z + pl.getD()) / denominator;
		
		if(!Float.isNaN(t) || !Float.isInfinite(t)) {
			return new Point(x + u.getX()*t, y + u.getY()*t, z + u.getZ()*t);
		}
		
		return null;
	}
}
