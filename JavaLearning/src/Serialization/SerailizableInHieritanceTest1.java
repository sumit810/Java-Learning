package Serialization;

/*Case 1: If superclass is serializable then subclass is automatically serializable : 
If superclass is Serializable, then by default every subclass is serializable. 
Hence, even though subclass doesn’t implement Serializable interface( and if it’s superclass implements Serializable), 
then we can serialize subclass object.*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class A implements Serializable {
	int i;

	public A(int i) {
		this.i = i;
	}
}

class B extends A {
	int j;

	public B(int i, int j) {
		super(i);
		this.j = j;
	}
}

public class SerailizableInHieritanceTest1 {
	public static void main(String... a) throws IOException, ClassNotFoundException {
		B b1 = new B(10, 20);
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
		B b2 = (B) ois.readObject();
		ois.close();
		fis.close();
		System.out.println("Object has been de-serialized!");
		System.out.println("Value of a:" + b2.i + " Value of b:" + b2.j);
	}
}
