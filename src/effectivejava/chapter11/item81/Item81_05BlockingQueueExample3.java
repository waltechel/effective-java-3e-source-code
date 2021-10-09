package effectivejava.chapter11.item81;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Item81_05BlockingQueueExample3 {

	private static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) {

		Consumer c1 = new Consumer("Consumer1", queue);
		c1.start();
		Consumer c2 = new Consumer("Consumer2", queue);
		c2.start();
		Consumer c3 = new Consumer("Consumer3", queue);
		c3.start();

		Producer p1 = new Producer(queue);
		p1.start();

	}

	// 생산자. - 무언가를 열심히 만들어 낸다.
	private static class Producer extends Thread {
		// INDEX
		private static int i = 1;

		private Queue<Integer> queue;

		public Producer(Queue<Integer> queue) {
			this.queue = queue;
		}

		public void run() {
			// 임의의 시간마다 데이터를 넣어 준다.
			while (true) {
				try {
					Thread.sleep(new Random().nextInt(1000));
					queue.add(i++);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}

	// 소비자.. 생산해 낸 것을 열심히 사용하자.
	private static class Consumer extends Thread {
		private Queue<Integer> queue;
		private String name;

		public Consumer(String name, Queue<Integer> queue) {
			this.name = name;
			this.queue = queue;
		}

		public void run() {
			while (true) {
				// 막 갖다가 뽑는다.
				try {
					Thread.sleep(new Random().nextInt(100));
					Integer num = queue.poll();
					System.out.println(this.name + " 이 먼저 뽑으려고 싸우고 있음");
					if (num != null) {
						int n = num;
						System.err.println("Consumer name is : " + name + "\tIndex is : " + n);
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
