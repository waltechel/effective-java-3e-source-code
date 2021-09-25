package effectivejava.chapter5.item28;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// 코드 28-6 리스트 기반 Chooser - 타입 안전성 확보! (168쪽)
public class ChooserArrayver<T> {
	private final Object[] choiceArray2;
	private final T[] choiceArray;

//	@SuppressWarnings("unchecked")
	public ChooserArrayver(Collection<T> choices) {
		// Type safety: Unchecked cast from Object[] to T[]
		// 동작은 되는 소스
		// 그러나 warning을 없애는 것이 가장 좋겠다.
		choiceArray = (T[]) choices.toArray();
		choiceArray2 = choices.toArray();
	}
	
	public T choose3() {
		return (T) choiceArray2[0];
	}
	
	public T choose2() {
		Random rnd = ThreadLocalRandom.current();
		return (T) choiceArray2[rnd.nextInt(choiceArray.length)];
	}

	public T choose() {
		Random rnd = ThreadLocalRandom.current();
		return choiceArray[rnd.nextInt(choiceArray.length)];
	}

	public static void main(String[] args) {
		List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);

		ChooserArrayver<Integer> chooser = new ChooserArrayver<>(intList);

		for (int i = 0; i < 10; i++) {
			// 추상 클래스 Number는 클래스 BigDecimal, BigInteger, Byte, Double,
			// Float, Integer, Long 및 Short 슈퍼 클래스입니다.
			Number choice = chooser.choose();
			System.out.println(choice);
		}
		System.out.println();
		for (int i = 0; i < 10; i++) {
			// 추상 클래스 Number는 클래스 BigDecimal, BigInteger, Byte, Double,
			// Float, Integer, Long 및 Short 슈퍼 클래스입니다.
			Number choice = chooser.choose2();
			System.out.println(choice);
		}
	}
}
