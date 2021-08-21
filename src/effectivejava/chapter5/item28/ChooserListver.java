package effectivejava.chapter5.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// 코드 28-6 리스트 기반 Chooser - 타입 안전성 확보! (168쪽)
public class ChooserListver<T> {
	private final List<T> choiceList;

	public ChooserListver(Collection<T> choices) {
		choiceList = new ArrayList<>(choices);
	}

	public T choose() {
		Random rnd = ThreadLocalRandom.current();
		return choiceList.get(rnd.nextInt(choiceList.size()));
	}

	public static void main(String[] args) {
		List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);

		ChooserListver<Integer> chooser = new ChooserListver<>(intList);

		for (int i = 0; i < 10; i++) {
			// 추상 클래스 Number는 클래스 BigDecimal, BigInteger, Byte, Double, Float, Integer, Long 및 Short 슈퍼 클래스입니다.
			Number choice = chooser.choose();
			System.out.println(choice);
		}
	}
}
