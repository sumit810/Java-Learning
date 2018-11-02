package Threading;

public class YieldDemo {
	public static void main(String... s) {

		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		producer.setPriority(Thread.MIN_PRIORITY); // giving the producer thread
													// least priority
		consumer.setPriority(Thread.MAX_PRIORITY); // giving the consumer thread
													// the max priority

		producer.start();
		consumer.start();
	}
}

class Producer extends Thread {

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Producer: produced Item: " + i);
			Thread.yield();
		}
	}
}

class Consumer extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Consumer : consumed item: " + i);
			Thread.yield();
		}
	}

}