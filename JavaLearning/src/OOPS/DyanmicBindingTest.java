package OOPS;

class Superclass {
	public void method() {
		System.out.println("method of superclass calling!");
	}
}

class Subclass extends Superclass {
	public void method() {
		System.out.println("method of subclass calling");
	}
}

public class DyanmicBindingTest {
	public static void main(String... s) {
		Superclass sc = new Superclass();
		Superclass scl = new Subclass();
		scl.method();
		sc.method();
	}

}
