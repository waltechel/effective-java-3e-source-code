package effectivejava.chapter4.item18;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

// 코드 18-1 잘못된 예 - 상속을 잘못 사용했다! (114쪽)
public class InstrumentedHashSet<E> extends HashSet<E> {
	// 추가된 원소의 수
	private int addCount = 0;

	public InstrumentedHashSet() {
	}

	public InstrumentedHashSet(int initCap, float loadFactor) {
		super(initCap, loadFactor);
	}

	@Override
	public boolean add(E e) {
		addCount++;
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		return super.addAll(c);
	}

	public int getAddCount() {
		return addCount;
	}

	public static void main(String[] args) {
		InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
		s.addAll(List.of("틱", "탁탁", "펑"));
		// 3이 나와야 하는데 6이 나온다.
		// 6이 나오는 이유는 addAll Method가 내부적으로 자기 자신을 참조하기 때문이다.
		System.out.println(s.getAddCount());
	}
}
