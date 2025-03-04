package effectivejava.chapter4.item20;

import java.util.Map;
import java.util.Objects;

// 코드 20-2 골격 구현 클래스 (134-135쪽)
// 스켈레톤 클래스 : 인터페이스를 받되, 적당히 만들어주는 클래스
public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
	
	// 골격 구현 : 이 클래스를 상속받을 개발자가 손댈 필요가 거의 없는 메서드들을 미리 정의한다.
	
	// 변경 가능한 엔트리는 이 메서드를 반드시 재정의해야 한다.
	@Override
	public V setValue(V value) {
		throw new UnsupportedOperationException();
	}

	// Map.Entry.equals의 일반 규약을 구현한다.
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Map.Entry))
			return false;
		Map.Entry<?, ?> e = (Map.Entry) o;
		return Objects.equals(e.getKey(), getKey()) && Objects.equals(e.getValue(), getValue());
	}

	// Map.Entry.hashCode의 일반 규약을 구현한다.
	@Override
	public int hashCode() {
		return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
	}

	@Override
	public String toString() {
		return getKey() + "=" + getValue();
	}
}
