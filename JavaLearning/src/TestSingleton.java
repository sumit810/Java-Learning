import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


enum Singleton {
	INSTANCE;
}

class Testing {
	static void UseSingletonOne() {
		Singleton singleton = Singleton.INSTANCE;
		print("singleton", singleton);
	}

	private static void print(String name, Singleton object) {
		// TODO Auto-generated method stub
		System.out.println(String.format("Object: %s, Hashcode: %d", name, object.hashCode()));

	}
}

public class TestSingleton {
	public static void main(String... s) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(Testing::UseSingletonOne);
		service.submit(Testing::UseSingletonOne);
	}
}
