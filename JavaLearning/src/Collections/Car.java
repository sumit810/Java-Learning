package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Car implements Comparable<Car> {
	private String name;
	private Colors color;

	public Car(String name, Colors color) {
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Colors getColor() {
		return color;
	}

	public void setColor(Colors color) {
		this.color = color;
	}

	private enum Colors {
		BLUE, SILVER, MAGENTA, RED, GREEN
	}

	public static class ColorComparator implements Comparator<Car> {

		@Override
		public int compare(Car car1, Car car2) {
			return car1.getColor().compareTo(car2.getColor());
		}

	}

	@Override
	public int compareTo(Car car) {
		return getName().compareTo(car.getName());
	}

	@Override
	public String toString() {
		return "[ Name=" + name + ", Color=" + color + "]";
	}

	public static void main(String[] s) {
		List<Car> carList = new ArrayList<Car>();
		carList.add(new Car("Indica", Colors.BLUE));
		carList.add(new Car("Lancer", Colors.GREEN));
		carList.add(new Car("Indigo", Colors.RED));
		carList.add(new Car("S*4", Colors.MAGENTA));
		carList.add(new Car("BMW", Colors.SILVER));

		System.out.println("Before Sorting:");
		for (Car cars : carList) {
			System.out.println(cars);
		}
		ColorComparator c = new ColorComparator();
		Collections.sort(carList, c);

		System.out.println("After Sorting:");
		for (Car cars : carList) {
			System.out.println(cars);
		}

	}

}