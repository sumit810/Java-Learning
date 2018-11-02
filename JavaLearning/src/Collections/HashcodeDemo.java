package Collections;

import java.util.HashMap;
import java.util.Map;

class Apple {
	private String color;

	public Apple(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
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
		Apple other = (Apple) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}

}

public class HashcodeDemo {
	public static void main(String... s) {
		Apple apple1 = new Apple("red");
		Apple apple2 = new Apple("green");
		Map<Apple, Integer> map = new HashMap<Apple, Integer>();
		map.put(apple1, 10);
		map.put(apple2, 20);
		System.out.println(map);
		System.out.println(map.get(new Apple("green")));

	}

}
