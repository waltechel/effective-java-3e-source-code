package effectivejava.chapter2.item6;

import java.util.regex.Pattern;

// 값비싼 객체를 재사용해 성능을 개선한다. (32쪽)
public class RomanNumerals {
	// 코드 6-1 생성 비용이 아주 비싼 정규식 기법이다.
	// 성능이 중요한 애플리케이션에서 반복적으로 사용할 수는 없다.
	// 정규식 같은 유틸성 인스턴스는 캐싱해두고 메서드가 호출될 때마다 사용하는 것이 좋다.
	static boolean isRomanNumeralSlow(String s) {
		return s.matches("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
	}

	// 코드 6-2 값비싼 객체를 재사용해 성능을 개선한다.
	// 여기서 RomanNumerals가 한번도 사용되지 않는다고 초기화하지 않는 Lazy initailization 방식은 매우 나쁜 방식이다.
	// 지연 초기화는 코드는 복잡하지만, 성능은 크게 개선되지 않는 경우가 대부분이기 때문이다.
	private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

	static boolean isRomanNumeralFast(String s) {
		return ROMAN.matcher(s).matches();
	}

	public static void main(String[] args) {
		int numSets = Integer.parseInt(args[0]);
		int numReps = Integer.parseInt(args[1]);
		boolean b = false;

		for (int i = 0; i < numSets; i++) {
			long start = System.nanoTime();
			for (int j = 0; j < numReps; j++) {
				// 성능 차이를 확인하려면 xxxSlow 메서드를 xxxFast 메서드로 바꿔 실행해보자.
				b ^= isRomanNumeralSlow("MCMLXXVI");
			}
			long end = System.nanoTime();
			System.out.println(((end - start) / (1_000. * numReps)) + " μs.");
		}

		// VM이 최적화하지 못하게 막는 코드
		if (!b)
			System.out.println();
	}
}
