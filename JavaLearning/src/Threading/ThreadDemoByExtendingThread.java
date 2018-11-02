package Threading;

class Threading extends Thread {

	public void run() {
		try {
			System.out.println("Thread " + Thread.currentThread().getName() + " is running");
		} catch (Exception ae) {
			System.out.println("Exception caught!");
		}
	}
}

public class ThreadDemoByExtendingThread {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			Threading t1 = new Threading();
			t1.start();
		}
	}

}
