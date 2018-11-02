package cloning;

class A {
	int x, y;

	public A() {
		x = 10;
		y = 20;
	}
}

public class Test {
	public static void main(String[] a) {

		A aa = new A();
		System.out.println("Value of x: " + aa.x + " \n Value of y: " + aa.y);
		A bb = aa;
		bb.x = 100;
		System.out.println("Value of x: " + aa.x + " \n Value of y: " + aa.y);
		System.out.println("Value of x: " + bb.x + " \n Value of y: " + bb.y);
	}
}
