package effectivejava.chapter9.item61;

// 코드 61-4 끔찍하게 느린 코드
public class item61_04SlowSlow {

	public static void main(String[] args) {
		Long sum = 0L;
		for (long i = 0; i <= Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}
