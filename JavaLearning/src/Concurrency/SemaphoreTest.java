package Concurrency;

import java.util.concurrent.Semaphore;

class FirstIncrement implements Runnable {
	Semaphore semaphore;

	public FirstIncrement(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + " is waiting for the permit!");
		try {
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName() + " has got the permit!");

			for (int i = 0; i < 5; i++) {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + "-> " + SemaphoreTest.sharedResource++);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " has released permit");
		semaphore.release();

	}

}

class SecondDecrement implements Runnable {
	Semaphore semaphore;

	public SecondDecrement(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + " is  waiting for the permit! ");
		try {
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName() + " has got a permit!");

			for (int i = 0; i < 5; i++) {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " =>  " + SemaphoreTest.sharedResource--);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + " has released permit");
		semaphore.release();

	}

}

public class SemaphoreTest {
	static int sharedResource = 0;

	public static void main(String... s) {
		Semaphore semaphore = new Semaphore(1);
		System.out.println("Semaphore with 1 permit has been created!");
		FirstIncrement fi = new FirstIncrement(semaphore);
		new Thread(fi, "Thread- 1").start();

		SecondDecrement sd = new SecondDecrement(semaphore);
		new Thread(sd, "Thread-2").start();
	}

}
