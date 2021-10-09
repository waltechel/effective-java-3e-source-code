package effectivejava.chapter11.item81;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// ConcurrentMap으로 구현한 동시성 정규화 맵
public class Item81_01Intern01 {
	// 코드 81-1 ConcurrentMap으로 구현한 동시성 정규화 맵 - 최적은 아니다. (432쪽)
	private static final ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

	public static String intern(String string) {
		// If the specified key is not already associatedwith a value, associates it with the given value
		// Map의 putIfAbsent(key, value) 메서드는 주어진 키에 매핑된 값이 없을 때만 새 값을 집어넣는다.
		String previousValue = map.putIfAbsent(string, string);
		return previousValue == null ? string : previousValue;
	 }

}
