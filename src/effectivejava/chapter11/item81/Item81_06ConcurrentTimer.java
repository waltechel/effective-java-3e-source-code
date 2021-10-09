package effectivejava.chapter11.item81;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

// 코드 81-3 동시 실행 시간을 재는 간단한 프레임워크 (433-434쪽)
public class Item81_06ConcurrentTimer {

	private Item81_06ConcurrentTimer() {
	} // 인스턴스 생성 불가

	/**
	 * 이 예제의 코드는 작업에 충분한 시간이 걸리지 않으면(1초 이상) 정확한 시간을 측정할 수 없도록 되어 있다.
	 * @param executor
	 *            concurrency 매개변수로 지정한 동시성 수준만큼의 스레드를 생성할 수 있어야
	 *            한다. 그게 안되면 스레드 교착상태가 벌어진다.(기아)
	 * @param concurrency
	 *            몇 개의 동시성을 만들 것인가
	 * @param action
	 *            Runnable 인터페이스를 넘긴다.
	 * @return 시간
	 * @throws InterruptedException
	 */
	public static long time(Executor executor, int concurrency, Runnable action) throws InterruptedException {
		CountDownLatch ready = new CountDownLatch(concurrency);
		CountDownLatch start = new CountDownLatch(1);
		CountDownLatch done = new CountDownLatch(concurrency);

		for (int i = 0; i < concurrency; i++) {
			executor.execute(() -> {
				ready.countDown(); // 타이머에게 준비를 마쳤음을 알린다.
				try {
					start.await(); // 모든 작업자 스레드가 준비될 때까지 기다린다.
					action.run();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				} finally {
					done.countDown();  // 타이머에게 작업을 마쳤음을 알린다.
				}
			});
		}

		ready.await();     // 모든 작업자가 준비될 때까지 기다린다.
		long startNanos = System.nanoTime();
		start.countDown(); // 작업자들을 깨운다.
		done.await();      // 모든 작업자가 일을 끝마치기를 기다린다.
		return System.nanoTime() - startNanos;
	}
}
