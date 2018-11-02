package Concurrency;

import java.util.concurrent.Semaphore;

/*ATM room has only 2 ATM machines and 5 people are waiting to access the machines.
Since only one person can access an ATM machine at a given time, others wait for thier turn*/

class Person extends Thread {
	private Semaphore machines;

	public Person(Semaphore machines, String name) {
		this.machines = machines;
		this.setName(name);
		this.start();
	}

	public void run() {
		try {
			System.out.println(getName() + " is waiting for accessing the ATM Machines!");
			machines.acquire();
			System.out.println(getName() + " is accessing the machines");
			Thread.sleep(1000);
			System.out.println(getName() + " is done with his work accessing the ATM Machine!");
			machines.release();

		} catch (Exception ae) {
			System.out.println(ae.getMessage());
		}
	}
}

public class ATMRoom {
	public static void main(String... s) {

		Semaphore semaphore = new Semaphore(2);
		new Person(semaphore, "Sumit");
		new Person(semaphore, "Ankit");
		new Person(semaphore, "Shifali");
		new Person(semaphore, "Happy");
		new Person(semaphore, "Rashid");

	}

}
