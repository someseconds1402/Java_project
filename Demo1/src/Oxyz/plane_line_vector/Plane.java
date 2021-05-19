package Oxyz.plane_line_vector;

public class Plane {
	// Phuong trinh mat phang: aX + bY + cZ + d = 0
	private float a;
	private float b;
	private float c;
	private float d;
	
	private Vector v; // vector chi phuong
	
	// Constructor
	
	public Plane(Point p1, Point p2, Point p3) {
		Vector p1p2 = new Vector(p1, p2);
		Vector p2p3 = new Vector(p2, p3);
		
		v = new Vector(p1p2, p2p3);
		
		/*
		 * v = (a, b, c) & A(x0, y0, z0)
		 * => aX + bY + cZ + d = 0 <=> a(X-x0) + b(Y-y0) + c(Z-z0) = 0
		 * => d = -(a*x0 + b*y0 + c*z0)
		 */
		a = v.getX();
		b = v.getY();
		c = v.getZ();
		d = - (a*p1.getX() + b*p1.getY() + c*p1.getZ());
	}
	
	public Plane(Point p1, Vector n) {
		v = n;
		a = v.getX();
		b = v.getY();
		c = v.getZ();
		d = - (a*p1.getX() + b*p1.getY() + c*p1.getZ());
	}
	
	// Getter & Setter

	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

	public float getB() {
		return b;
	}

	public void setB(float b) {
		this.b = b;
	}

	public float getC() {
		return c;
	}

	public void setC(float c) {
		this.c = c;
	}

	public float getD() {
		return d;
	}

	public void setD(float d) {
		this.d = d;
	}

	public Vector getV() {
		return v;
	}

	public void setV(Vector v) {
		this.v = v;
	}


	// Other Method
	
	public float doSomething(Point p) { // Thay toa do 1 diem vao phuong trinh mat phang, tra ve gia tri
		return (a*p.getX() + b*p.getY() + c*p.getZ() + d);
	}
	
	public float distance(Point p) {
		float t = a*p.getX() + b*p.getY() + c*p.getZ();
		if(t == 0.0f) {
			return 0f;
		}
		else {
			return Math.abs((t / (float)Math.sqrt(a*a + b*b + c*c)));
		}
	}
	
	public void print() {
		System.out.println(a + "X + " + b + "Y + " + c + "Z + " + d + " = 0");
	}
	
	public static boolean isBetween2Planes(Plane pl1, Plane pl2, Point p) { // Kiem tra 1 diem co nam giua 2 mat phang hay khong
		return (pl1.doSomething(p) * pl2.doSomething(p)) <= 0;
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
	
	public Point intersection(Line l) {
		Vector u = l.getU();
		
		float denominator = (a*l.getX() + b*l.getY() + c*l.getZ());
		
		if(denominator == 0)
			return null;
		
		float t = -(a*u.getX() + b*u.getY() + c*u.getZ() + d) / denominator;
		
		if(!Float.isNaN(t) || !Float.isInfinite(t)) {
			return new Point(l.getX() + u.getX() * t, l.getY() + u.getY() * t, l.getZ() + u.getZ() * t);
		}
		
		return null;
	}
}
