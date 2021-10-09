package effectivejava.chapter11.item81;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Item81_03BlockingQueueExample {

	public static void main(String[] args) {

		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
		try {
			// queue.take 가 잡고 있으므로 여기 소스가 나오지 않는다.
			System.out.println(queue.take());
			System.out.println("여기 소스가 나오지 않는다.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
