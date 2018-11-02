package Threading;

class VolatileData {
	private volatile int counter = 0;

	public int getCounter() {
		return counter;
	}

	public void increaseCounter() {
		counter++;
	}
}

class VolatileThread extends Thread {
	private final VolatileData data;

	public VolatileThread(VolatileData data) {
		this.data = data;
	}

	public void run() {
		int oldValue = data.getCounter();
		System.out.println("Thread:" + Thread.currentThread().getId() + " Old Value:  " + oldValue);
		data.increaseCounter();
		int newValue = data.getCounter();
		System.out.println("Thread: " + Thread.currentThread().getId() + " New Value: " + newValue);
	}
}

public class VolatileDemo {
	public static void main(String... x) {
		VolatileData volatileData = new VolatileData();
		VolatileThread p1 = new VolatileThread(volatileData);
		p1.start();
		VolatileThread p2 = new VolatileThread(volatileData);
		p2.start();
	}
}
