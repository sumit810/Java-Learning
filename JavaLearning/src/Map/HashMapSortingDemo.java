package Map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Sort the Custom object using HashMap with respect to Employee Age.

class Employee {
	private String name;
	private int age;

	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}
}

class AgeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		// TODO Auto-generated method stub
		return emp2.getAge() - emp1.getAge();
	}

}

public class HashMapSortingDemo {
	public static void main(String... s) {
		Map<String, Employee> map = new HashMap<>();
		map.put("emp1", new Employee("Sumit", 29));
		map.put("emp2", new Employee("Shifali", 25));
		map.put("emp3", new Employee("Ankit", 21));
		map.put("emp4", new Employee("Priya", 26));
		map.put("emp5", new Employee("Rashid", 28));
		map.put("emp6", new Employee("Ashutosh", 31));
		Collection<Employee> employees = map.values();
		List<Employee> list = new ArrayList<>(employees);

		Collections.sort(list, new AgeComparator());
		System.out.println("Sorting with rest to Age");
		for (Employee emps : list) {
			System.out.println(emps);
		}

	}

}
