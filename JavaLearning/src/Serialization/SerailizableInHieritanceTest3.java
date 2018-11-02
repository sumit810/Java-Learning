package Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*If the superclass is serializable but we don’t want the subclass to be serialized:
	There is no direct way to prevent subclass from serialization in java.
	One possible way by which a programmer can achieve this is by implementing the writeObject()and readObject()methods 
	in the subclass and needs to throw NotSerializableException from these methods.
	These methods are executed during serialization and de-serialization respectively.
	By overriding these methods,we are just implementing our own custom serialization.*/

class C implements Serializable {
	int i;

	public C(int i) {
		this.i = i;
	}
}

class D extends C {
	int j;

	public D(int i, int j) {
		super(i);
		this.j = j;
	}

	private void writeObject(ObjectOutputStream oos) throws Exception {
		throw new NotSerializableException();
	}

	private void readObject(ObjectInputStream ois) throws IOException {
		throw new NotSerializableException();
	}
}

public class SerailizableInHieritanceTest3 {
	public static void main(String... a) throws IOException, ClassNotFoundException {
		D d = new D(100, 200);
		System.out.println("Value of a:" + d.i + " Value of b:" + d.j);

		FileOutputStream fos = new FileOutputStream("abc.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(d);
		oos.close();
		fos.close();
		System.out.println("Object has been serialized!");

		FileInputStream fis = new FileInputStream("abc.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		D d1 = (D) ois.readObject();
		System.out.println("Object has been deserialized!");
		System.out.println("Value of a:" + d.i + " Value of b:" + d.j);
	}
}
