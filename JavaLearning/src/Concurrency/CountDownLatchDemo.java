package Concurrency;

import java.util.concurrent.CountDownLatch;

class MyRunnable implements Runnable {
	CountDownLatch countDownLatch;

	public MyRunnable(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i = 5; i >= 0; i--) {
			countDownLatch.countDown();
			System.out.println(Thread.currentThread().getName() + " has reduced latch to " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

public class CountDownLatchDemo {
	public static void main(String... s) {

		CountDownLatch cdl = new CountDownLatch(6);
		new Thread(new MyRunnable(cdl)).start();
		try {
			cdl.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("count has reaced 0 " + Thread.currentThread().getName() + " thread has ended!");
	}

}
