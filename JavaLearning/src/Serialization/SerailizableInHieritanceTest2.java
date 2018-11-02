package Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*If a superclass is not serializable then subclass can still be serialized */

class AA {
	int i;

	public AA(int i) {
		this.i = i;
	}

	/*
	 * At the time of de-serialization, if any non-serializable superclass is
	 * present, then JVM will execute instance control flow in the superclass.
	 * To execute instance control flow in a class, JVM will always invoke
	 * default(no-arg) constructor of that class. So every non-serializable
	 * superclass must necessarily contain default constructor, otherwise we
	 * will get runtime-exception.
	 */
	public AA() {
		int i = 100;
		System.out.println("Default constructor of parents runs!");
	}
}

class BB extends AA implements Serializable {
	int j;

	public BB(int i, int j) {
		super(i);
		this.j = j;
	}
}

public class SerailizableInHieritanceTest2 {
	public static void main(String... a) throws IOException, ClassNotFoundException {
		BB b1 = new BB(10, 20);
		System.out.println("Value of a:" + b1.i + " Value of b:" + b1.j);

		// serialise the B object writing into a file
		FileOutputStream fs = new FileOutputStream("abc.txt");
		ObjectOutputStream os = new ObjectOutputStream(fs);
		os.writeObject(b1);
		os.close();
		fs.close();
		System.out.println("Object has been serialized!");
		// de-searialise B subclass object
		FileInputStream fis = new FileInputStream("abc.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		BB b2 = (BB) ois.readObject();
		ois.close();
		fis.close();
		System.out.println("Object has been de-serialized!");
		System.out.println("Value of a:" + b2.i + " Value of b:" + b2.j);
	}
}
