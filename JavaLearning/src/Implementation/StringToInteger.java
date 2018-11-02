package Implementation;

import java.util.Scanner;

public class StringToInteger {
	public static void main(String... s) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("ENTER A GIVEN STRING");
		String number = scan.next();
		// int result = myStringToInteger(number);
		int result = myStringToIntegerApproach(number);
		System.out.println("String decoded to Integer number " + result);
	}

	private static int myStringToIntegerApproach(String number) {
		// TODO Auto-generated method stub
		char ch[] = number.toCharArray();
		int sum = 0;
		int asciivalueofzero = (int) '0';
		for (char c : ch) {
			int eachCharacterAsciiValue = (int) c;
			int diff = eachCharacterAsciiValue - asciivalueofzero;
			sum = (sum * 10) + diff;
		}
		return sum;
	}

	private static int myStringToInteger(String string) {
		// TODO Auto-generated method stub
		int answer = 0;
		int factor = 1;
		for (int i = string.length() - 1; i >= 0; i--) {
			char[] ch = string.toCharArray();
			answer = answer + (ch[i] - 48) * factor;
			factor *= 10;
		}
		return answer;
	}

}
