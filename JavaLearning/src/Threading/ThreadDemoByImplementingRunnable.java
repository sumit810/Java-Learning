package Threading;

class Thread1 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println("Thread " + Thread.currentThread().getId() + " is running!");
			}

		} catch (Exception ae) {
			System.out.println(ae.getLocalizedMessage());
		}

	}

}

public class ThreadDemoByImplementingRunnable {
	public static void main(String... d) {
		Thread object = new Thread(new Thread1());
		object.start();

	}

}
