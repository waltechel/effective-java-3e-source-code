package effectivejava.chapter11.item81;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// ConcurrentMap으로 구현한 동시성 정규화 맵
public class Item81_02Intern02 {
	private static final ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

	// 코드 81-2 ConcurrentMap으로 구현한 동시성 정규화 맵 - 더 빠르다! (432쪽)
	public static String intern(String string) {
		String result = map.get(string);
		if (result == null) {
			result = map.putIfAbsent(string, string);
			if (result == null) {
				result = string;
			}
		}
		return result;
	}
}
