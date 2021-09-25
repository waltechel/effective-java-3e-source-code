package effectivejava.chapter7.item46;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

// 빈도표 초기화에 스트림을 적절하지 못하게 혹은 적절하게 사용하는 예 (277-279쪽)
public class FreqGood {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/effectivejava/chapter7/item46/sample.txt");

		// 코드 46-2 스트림을 제대로 활용해 빈도표를 초기화한다. (278쪽)
		// 이 코드는 collector를 사용하는데, collector를 사용하면, 스트림의 원소를 손쉽게 컬렉션으로 모을 수 있다.
		Map<String, Long> freq;
		// tokens는 Java 9부터 지원한다.
		try (Stream<String> words = new Scanner(file).tokens()) {
			freq = words.collect(groupingBy(String::toLowerCase, counting()));
		}

		System.out.println(freq);

		// 코드 46-3 빈도표에서 가장 흔한 단어 10개를 뽑아내는 파이프라인 (279쪽)
		// 가장 흔한 단어가 위로 오도록 comparing(freq::get).reversed()로 매긴 것에 주의한다.
		List<String> topTen = freq.keySet().stream().sorted(comparing(freq::get).reversed()).limit(6).collect(toList());

		System.out.println(topTen);
	}
}
