package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker implements Runnable {
	String name;
	Lock machines = new ReentrantLock();

	public Worker(ReentrantLock machines, String name) {
		this.machines = machines;
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "is waiting to access the ATM machine!");
		machines.lock();
		System.out.println(Thread.currentThread().getName() + " is accessing an ATM Machine");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			machines.unlock();
			System.out.println(Thread.currentThread().getName() + " is done using with ATM Machine!");
		}

	}
}

public class ReentrantLockDemo {
	static final int NO_OF_THREADS = 5;

	public static void main(String... s) {
		ReentrantLock locks = new ReentrantLock();
		ExecutorService service = Executors.newFixedThreadPool(NO_OF_THREADS);
		Runnable worker1 = new Worker(locks, "Thread-1");
		Runnable worker2 = new Worker(locks, "Thread-2");
		Runnable worker3 = new Worker(locks, "Thread-3");
		Runnable worker4 = new Worker(locks, "Thread-4");
		Runnable worker5 = new Worker(locks, "Thread-5");
		service.execute(worker1);
		service.execute(worker2);
		service.execute(worker3);
		service.execute(worker4);
		service.execute(worker5);
		service.shutdown();
	}

}
