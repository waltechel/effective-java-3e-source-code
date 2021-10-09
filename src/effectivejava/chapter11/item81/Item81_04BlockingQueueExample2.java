package effectivejava.chapter11.item81;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Item81_04BlockingQueueExample2 {

	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

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

		private BlockingQueue<Integer> queue;

		public Producer(BlockingQueue<Integer> queue) {
			this.queue = queue;
		}

		public void run() {
			// 임의의 시간마다 데이터를 넣어 준다.
			while (true) {
				try {
					Thread.sleep(new Random().nextInt(500));
					// 수정사항 - offer에서 put으로 변경
					// 데이터를 넣고 나면 알아서 notify시켜 준다.
					queue.put(i++);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}

	// 소비자.. 생산해 낸 것을 열심히 사용하자.
	private static class Consumer extends Thread {
		private BlockingQueue<Integer> queue;
		private String name;

		public Consumer(String name, BlockingQueue<Integer> queue) {
			this.name = name;
			this.queue = queue;
		}

		public void run() {
			while (true) {
				try {
					// queue에 data가 없으면 알아서 wait하고 있다.
					Integer index = queue.take();
					System.err.println(name + "이 " + index + "를 뽑음");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
