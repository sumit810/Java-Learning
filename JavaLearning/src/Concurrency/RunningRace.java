package Concurrency;

import java.util.concurrent.CountDownLatch;

public class RunningRace {
	public static void main(String... s) throws InterruptedException {
		// Count from 5 to 0 and then race will starts
		CountDownLatch latch = new CountDownLatch(5);

		new Racer(latch, "Sumit");
		new Racer(latch, "Ankit");
		new Racer(latch, "Shifali");

		System.out.println("Starting the Countdown!");
		long count = latch.getCount();
		System.out.println("Value of count is :" + count);
		while (count > 1) {
			Thread.sleep(2000);
			if (count == 1) {
				System.out.println("Start");
			}
		}
	}

}

class Racer extends Thread {
	private CountDownLatch latch;

	public Racer(CountDownLatch latch, String name) {
		this.latch = latch;
		this.setName(name);
		System.out.println(this.getName() + " ready and wait for the count down to start!");
		this.start();
	}

	public void run() {

	}
}
