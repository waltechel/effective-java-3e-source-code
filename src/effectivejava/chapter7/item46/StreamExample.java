package effectivejava.chapter7.item46;

import java.util.ArrayList;

public class StreamExample {

	// 스트림의 병렬 처리
	// 병렬 처리에 영향을 미치는 3가지 요인(이것이 자바다, 840~841p)
	// 1. 스트림 소스의 종류 : ArrayList, 배열이 Set, Map보다 스트림 처리 시에도
	// 퍼포먼스가 더 나온다.
	// 2. 코어의 수(core)
	// 3. 요소의 수가 적으면 선형 순차 처리가 병렬 처리보다 빠를 수 있다.
	// 결론 
	// 4코어 짜리 데스크톱일 경우 거의 모든 경우에서 병렬 처리가 더 빠르다. 
	
	// 이펙티브 자바의 이야기
	// 환경이 아무리 좋더라도 데이터 소스가 Stream.iterate거나 중간 연산자로 limit을 쓰면 파이프라인 병렬화로는 성능 개선을 기대할 수 없다.
	// 대체로 스트림의 소스가 ArrayList, HashMap, HashSet, ConcurrentHashMap, 의 인스턴스거나 배열, int 범위, long 범위일 때 병렬화의 효과가 가장 좋다.
	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			list.add(i);
		}

		long streamTime = testParallel(list);
		long sequentialTime = testSequential(list);
		System.out.println("1000");
		System.out.println("streamTime is     : " + streamTime);
		System.out.println("sequentialTime is : " + sequentialTime);

		list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		streamTime = testParallel(list);
		sequentialTime = testSequential(list);
		System.out.println("100");
		System.out.println("streamTime is     : " + streamTime);
		System.out.println("sequentialTime is : " + sequentialTime);
		
		
		list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		streamTime = testParallel(list);
		sequentialTime = testSequential(list);
		System.out.println("10");
		System.out.println("streamTime is     : " + streamTime);
		System.out.println("sequentialTime is : " + sequentialTime);
		
		list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			list.add(i);
		}
		streamTime = testParallel(list);
		sequentialTime = testSequential(list);
		System.out.println("5");
		System.out.println("streamTime is     : " + streamTime);
		System.out.println("sequentialTime is : " + sequentialTime);
		
		list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			list.add(i);
		}
		streamTime = testParallel(list);
		sequentialTime = testSequential(list);
		System.out.println("3");
		System.out.println("streamTime is     : " + streamTime);
		System.out.println("sequentialTime is : " + sequentialTime);
		
		list = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			list.add(i);
		}
		streamTime = testParallel(list);
		sequentialTime = testSequential(list);
		System.out.println("2");
		System.out.println("streamTime is     : " + streamTime);
		System.out.println("sequentialTime is : " + sequentialTime);

		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		streamTime = testMinParallel(list);
		sequentialTime = testMinSequential(list);
		System.out.println("100");
		System.out.println("streamTime is     : " + streamTime);
		System.out.println("sequentialTime is : " + sequentialTime);
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		streamTime = testMinParallel(list);
		sequentialTime = testMinSequential(list);
		System.out.println("10");
		System.out.println("streamTime is     : " + streamTime);
		System.out.println("sequentialTime is : " + sequentialTime);
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			list.add(i);
		}
		streamTime = testMinParallel(list);
		sequentialTime = testMinSequential(list);
		System.out.println("5");
		System.out.println("streamTime is     : " + streamTime);
		System.out.println("sequentialTime is : " + sequentialTime);

	}

	private static long testMinSequential(ArrayList<Integer> list) {
		long start = System.nanoTime();
		
		list.stream().filter( (a)-> a % 2 ==0 ).min((a, b) -> Integer.compare(a, b));
		
		long end = System.nanoTime();
		return end - start;
	}

	private static long testMinParallel(ArrayList<Integer> list) {
		long start = System.nanoTime();
		
		list.stream().parallel().filter((a) -> a % 2 == 0).min((a, b) -> Integer.compare(a, b));
		
		long end = System.nanoTime();
		return end - start;
	}

	private static long testSequential(ArrayList<Integer> list) {
		long start = System.nanoTime();
		
		list.stream().forEach( (a)->work(a) );
		
		long end = System.nanoTime();
		return end - start;
	}

	private static void work(int a) {
		try {
			Thread.sleep(1);
		} catch (Exception e) {

		}
	}

	private static long testParallel(ArrayList<Integer> list) {
		long start = System.nanoTime();

		list.stream().parallel().forEach( (a)->work(a) );
		
		long end = System.nanoTime();
		return end - start;
	}

}
