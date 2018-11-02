package Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Cat implements Serializable {
	private String name;
	private String sound;
	private String eat;

	public Cat() {
		name = null;
		sound = null;
		eat = null;
	}

	public Cat(String name, String sound, String eat) {
		this.name = name;
		this.sound = sound;
		this.eat = eat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public String getEat() {
		return eat;
	}

	public void setEat(String eat) {
		this.eat = eat;
	}
}

public class SerilizationTester {
	public static void main(String... s) {
		Cat cat = new Cat("priya", "meow", "flesh");

		System.out.println("CAT VALUES BEFORE SERIALIZATION");
		System.out.println("Cat Name: " + cat.getName() + "Sound : " + cat.getSound() + "Food: " + cat.getEat());
		try {
			FileOutputStream fs = new FileOutputStream("testSer.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(cat);
			os.close();
			System.out.println("Object has been serilized!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(" " + e.getStackTrace());
		}
		Cat cat1 = null;
		try {
			FileInputStream fs = new FileInputStream("testSer.ser");
			ObjectInputStream os = new ObjectInputStream(fs);
			cat = (Cat) os.readObject();
		} catch (Exception ae) {
			System.out.println(" " + ae.getStackTrace());
		}

		System.out.println("Object has been dese");
		System.out.println("Cat Name: " + cat.getName() + "Sound : " + cat.getSound() + "Food: " + cat.getEat());
	}
}