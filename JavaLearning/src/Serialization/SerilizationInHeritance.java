package Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Animal {
	int age;
	String name;

	public Animal() {
		age = 20;
		name="Tiger";
	}
}

class Dog extends Animal implements Serializable {
	public Dog(String name, int age) {
		this.name=name;
		this.age = age;
	}
}

public class SerilizationInHeritance {
	public static void main(String... s) {
		Dog dog = new Dog("Shero", 12);
		System.out.println("Before Serilization:");
		try {
			FileOutputStream fs = new FileOutputStream("testSer.txt");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(dog);
			os.close();
		} catch (Exception ae) {
			System.out.println(" " + ae.getStackTrace());
		}
		System.out.println("Name: " + dog.name + " Age: " + dog.age);
		try {
			FileInputStream fs = new FileInputStream("testSer.txt");
			ObjectInputStream is = new ObjectInputStream(fs);
			dog = (Dog) is.readObject();
			is.close();
			System.out.println("After deserialiszation");
			System.out.println("Name: " + dog.name + " Age: " + dog.age);
		} catch (Exception ae) {
			System.out.println(" " + ae.getStackTrace());
		}
	}
}
