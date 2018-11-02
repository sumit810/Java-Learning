package HeadFirstJava;

public class PhraseOMatic {
	public static void main(String... s) {
		String[] wordListOne = { "24/7", "multi-tier", "30,000 foot", "B-to-B", "win-win", "front-end", "web-based",
				"smart", "six-sigma" };
		String[] wordListTwo = { "empowered", "sticky", "value-added", "oriented", "branded", "focused" };
		String[] wordListThree = { "process", "solution", "tricky", "architecture", "core", "portal", "space",
				"pardigm", "mission" };

		int firstWordLength = wordListOne.length;
		int secondWordLength = wordListTwo.length;
		int thirdWordLength = wordListThree.length;

		// generate random words from these 3 String arrays
		int random1 = (int) (Math.random() * firstWordLength);
		int random2 = (int) (Math.random() * secondWordLength);
		int random3 = (int) (Math.random() * thirdWordLength);

		// build a new phrase
		String phrase = wordListOne[random1] + " " + wordListTwo[random2] + " " + wordListThree[random3];
		// print out the phrase
		System.out.println("What we need is " + phrase);
	}

}
