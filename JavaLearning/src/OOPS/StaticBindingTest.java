package OOPS;

class Parent {
	static void methodA() {
		System.out.println("Super class method invokes!");
	}
}

class Child extends Parent {
	static void methodA() {
		System.out.println("Sub class method invokes!");
	}
}

public class StaticBindingTest {
	public static void main(String... s) {
		Parent pp = new Parent();
		Parent child = new Child();
		pp.methodA();
		child.methodA();

	}

}
