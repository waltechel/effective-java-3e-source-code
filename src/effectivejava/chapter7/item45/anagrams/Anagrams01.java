package effectivejava.chapter7.item45.anagrams;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// 코드 45-1 사전 하나를 훑어 원소 수가 많은 아나그램 그룹들을 출력한다. (269-270쪽)
public class Anagrams01 {

	public static void main(String[] args) throws IOException {
		File dictionary = new File("src/effectivejava/chapter7/item45/sample.txt");
		int minGroupSize = Integer.parseInt(args[1]);

		// 스트림을 쓰지 않고 반복문으로만 구현하였다.
		Map<String, Set<String>> groups = new HashMap<>();
		try (Scanner s = new Scanner(dictionary)) {
			// 위와 아래 소스는 동일하다.
			// String key = s.next();
			// if(!groups.containsKey(key)) {
			// 	groups.put(key, new TreeSet<>());
			// }
			while (s.hasNext()) {
				String word = s.next();
				// 키 값에 해당하는지 존재하고, 없으면 새로 만들어서 넣어주는 형태의 코드다.
				groups.computeIfAbsent(alphabetize(word), (unused) -> new TreeSet<>()).add(word);
			}
		}

		for (Set<String> group : groups.values()) {
			if (group.size() >= minGroupSize) {
				System.out.println(group.size() + ": " + group);
			}
		}
	}

	private static String alphabetize(String s) {
		char[] a = s.toCharArray(); // banana
		Arrays.sort(a);             // aaabnn
		return new String(a);
	}
}
