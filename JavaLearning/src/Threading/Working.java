package Threading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Processing implements Runnable {

	private Random random = new Random();
	List<Integer> list1 = new ArrayList<Integer>();
	List<Integer> list2 = new ArrayList<Integer>();

	public synchronized void stageOne() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list1.add(random.nextInt(100));
		System.out.println("List1 Size: " + list1.size());

	}

	public synchronized void stageTwo() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list2.add(random.nextInt(100));
		System.out.println("List2 Size: " + list2.size());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			stageOne();
			stageTwo();

		}
	}

}

public class Working {
	public static void main(String... s) {

		Processing p1 = new Processing();
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p1);
		t1.start();
		t2.start();

	}
}
