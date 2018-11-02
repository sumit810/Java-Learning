package OOPS;

class A {
	protected void show() {
		System.out.println("Parent class show() method invokes!");
	}
}

class B extends A {
	public void show() {
		System.out.println("Child class show() method invokes!");
	}
}

public class InheritanceDemo {
	public static void main(String... s) {
		A aa = new A();
		A bb = new B();
		aa.show();
		bb.show();

	}

}
