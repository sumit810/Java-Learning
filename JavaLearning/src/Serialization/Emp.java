package Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Emp implements Serializable {
	String empName;
	static String companyName;
	int salary;
	transient int empNo;

	public Emp(String empName, String companyName, int salary, int empNo) {
		this.empName = empName;
		this.companyName = companyName;
		this.salary = salary;
		this.empNo = empNo;
	}

	public static void main(String... s) {
		Emp emp = new Emp("sumit", "GL", 10000, 315335);
		// serialize the state of a Java Object
		try {
			FileOutputStream fs = new FileOutputStream("testSer.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(emp);
			os.close();
		} catch (Exception ae) {
			System.out.println(" " + ae.getStackTrace());
		}

		System.out.println("Employee Object has been serialized!");
		System.out.println("Data before De-Serilaization");
		printObject(emp);

		// value of static member company Name changes
		emp.companyName = "WIPRO";

		emp = null;
		// de-serialization
		try {
			FileInputStream fs = new FileInputStream("testSer.ser");
			ObjectInputStream os = new ObjectInputStream(fs);
			emp = (Emp) os.readObject();
			os.close();
			System.out.println("Object has been de-serialized!");
			System.out.println("Data After De-Serilization");
			printObject(emp);
		} catch (Exception ae) {
			System.out.println(" " + ae.getStackTrace());
		}
	}

	private static void printObject(Emp emp) {
		// TODO Auto-generated method stub
		System.out.println("Emplployee Name:" + emp.empName);
		System.out.println("Company Name: " + emp.companyName);
		System.out.println("Salary " + emp.salary);
		System.out.println("Emp No: " + emp.empNo);
	}
}
