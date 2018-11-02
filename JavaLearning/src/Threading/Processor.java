package Threading;

import java.util.Scanner;

class Runner extends Thread {
	private volatile boolean running = true;

	@Override
	public void run() {
		while (running) {
			System.out.println("Hello!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void shutDown() {
		running = false;
	}

}

public class Processor {
	public static void main(String... s) {

		Runner t1 = new Runner();
		t1.start();
		System.out.println("Press return to stop!");

		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		t1.shutDown();
	}

}
