package effectivejava.chapter10.item71;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class item71Example004 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();

		Optional<Integer> minNum = getMinimum(list);
		System.out.println(minNum.isEmpty());

	}

	private static <E extends Comparable<E>> Optional<E> getMinimum(Collection<E> c) {
		if (c.isEmpty()) {
			return Optional.empty();
		}
		E result = null;
		for (E e : c) {
			if (result == null || e.compareTo(result) < 0) {
				result = Objects.requireNonNull(e);
			}
		}
		return Optional.of(result);
	}

}
