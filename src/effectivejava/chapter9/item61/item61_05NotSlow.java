package effectivejava.chapter9.item61;

// 코드 61-5 Long 을 long 을 바꾸는 것만으로도 속도가 빠르다.
public class item61_05NotSlow {

	public static void main(String[] args) {
		long sum = 0L;
		for (long i = 0; i <= Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}
