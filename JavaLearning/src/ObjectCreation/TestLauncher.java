package ObjectCreation;

// 5 different ways to create objects

import java.io.Serializable;

class Employee implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	public Employee() {
		System.out.println("Default constructor of Employee class is running...");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}

public class TestLauncher {
	public static void main(String... a) throws CloneNotSupportedException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		// 1st method to create object using "new" operator
		Employee emp1 = new Employee();
		emp1.setName("Sumit Gupta");
		System.out.println(emp1 + ", hashcode : " + emp1.hashCode());

		// 2nd method to create object using "clone" method
		Employee emp2 = (Employee) emp1.clone();
		emp1.setName("Ankit Gupta");
		System.out.println(emp2 + ", hashcode : " + emp2.hashCode());
		
		// 3rd method to create object using Class class's new instance ie reflection
		Employee emp3= (Employee) Class.forName("ObjectCreation.Employee").newInstance();
		emp3.setName("Shifali Gupta");
		System.out.println(emp2 + ", hashcode : " + emp2.hashCode());
	}

}
