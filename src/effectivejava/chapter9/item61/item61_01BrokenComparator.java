package effectivejava.chapter9.item61;

import java.util.Comparator;

// 코드 61-1 잘못 구현된 비교자 - 문제를 찾아보자! (359쪽)
public class item61_01BrokenComparator {
	public static void main(String[] args) {

		// == 이 참조 비교를 하므로 1이 나온다.(두 객체는 다르기 때문)
		Comparator<Integer> naturalOrder = (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

		int result = naturalOrder.compare(new Integer(42), new Integer(42));
		System.out.println(result);
	}
}
