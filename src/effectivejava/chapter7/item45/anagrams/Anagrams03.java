package effectivejava.chapter7.item45.anagrams;

import static java.util.stream.Collectors.groupingBy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

// 코드 45-3 스트림을 적절히 활용하면 깔끔하고 명료해진다. (271쪽)
public class Anagrams03 {
	public static void main(String[] args) throws IOException {
		Path dictionary = Paths.get("src/effectivejava/chapter7/item45/sample.txt");
		int minGroupSize = 34;
		try (Stream<String> words = Files.lines(dictionary)) {
			words.collect(groupingBy(word -> alphabetize(word)))
					// 여기는 alphabetize는 그냥 생짜로 구현했다.
					.values().stream()
					// 필터링한다.
					.filter(group -> group.size() >= minGroupSize)
					// 살아남은 리스트를 출력한다.
					.forEach(g -> System.out.println(g.size() + ": " + g));
		}
	}

	private static String alphabetize(String s) {
		char[] a = s.toCharArray();
		Arrays.sort(a);
		return new String(a);
	}
}
