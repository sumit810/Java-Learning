package Singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

class Singleton implements Serializable, Cloneable {
	// eager initialization
	// private static Singleton soleInstance = new Singleton();
	// lazy initialization
	   static Singleton soleInstance = null;

	private Singleton() {
		/*
		 * if (soleInstance != null) { throw new
		 * RuntimeException("Cannot create , please use getInstance()"); }
		 */
		// proceed with the creation

	}

	public static Singleton getInstance() {
		if (soleInstance == null) {
			soleInstance = new Singleton();
		}
		return soleInstance;
	}

	/*
	 * public static Singleton getInstance() { return Holder.INSTANCE; }
	 */

	// Singleton holder pattern called
	static class Holder {
		static final Singleton INSTANCE = new Singleton();
	}

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	// fix for deserialization
	private Object readResolve() {
		System.out.println(".. read resolve ..");
		return soleInstance;

	}
}

public class SingletonTest {

	/*
	 * static void UseSingleton() { Singleton singleton =
	 * Singleton.getInstance(); System.out.
	 * println("Violating Singleton By Multiple threads: 'singleton object'");
	 * // in this case the hashcode could be same and different too so its //
	 * tedious part // print("singleton", singleton); }
	 */

	public static void main(String... s) throws Exception {

		/*
		 * ExecutorService service = Executors.newFixedThreadPool(2);
		 * service.submit(SingletonTest::UseSingleton);
		 * service.submit(SingletonTest::UseSingleton); service.shutdown();
		 */

		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();

		print("s1", s1);
		print("s2", s2);

		// Violating Singleton principle by cloning
		System.out.println("Violating Singleton By Cloning: 's2' and 's5'");
		Singleton s5 = (Singleton) s2.clone();
		print("s5", s5);

		// Violating Singleton by Reflection
		Class clazz = Class.forName("Singleton.Singleton");
		Constructor<Singleton> ctor = clazz.getDeclaredConstructor();
		ctor.setAccessible(true);
		Singleton s3 = ctor.newInstance();
		// we are getting different hashcode so we are vioalting the Singleton
		System.out.println("Violating Singleton By Reflection: 's1' and 's3'");
		print("s3", s3);

		// Violating Singleton by Serilaization/de-serialization
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.ser"));
		oos.writeObject(s2);

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.ser"));
		Singleton s4 = (Singleton) ois.readObject();
		// violating the Singleton principle by using
		// Serilization/de-serialization
		System.out.println("Violating Singleton By Serialization/De-serilization: 's2' and 's4'");
		print("s4", s4);

	}

	private static void print(String name, Singleton object) {
		// TODO Auto-generated method stub
		System.out.println(String.format("Object : %s , Hashcode : %d", name, object.hashCode()));

	}

}
