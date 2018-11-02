package Polymorphism;

class Demo {
	public void check(String str) {
		System.out.println("String check!");
	}
	
	public void check(Integer i){
		System.out.println("Integer check!");
	}

	public void check(Object obj) {
		System.out.println("Object check");
	}
}

public class MethodOverloadingDemo {
	public static void main(String... s) {

		Demo demo = new Demo();
		demo.check("sumit");
	}

}
