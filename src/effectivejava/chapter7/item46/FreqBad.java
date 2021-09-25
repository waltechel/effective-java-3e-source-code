package effectivejava.chapter7.item46;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

// 빈도표 초기화에 스트림을 적절하지 못하게 혹은 적절하게 사용하는 예 (277-279쪽)
public class FreqBad {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/effectivejava/chapter7/item46/sample.txt");

		// // 코드 46-1 스트림 패러다임을 이해하지 못한 채 API만 사용했다 - 따라 하지 말 것!
		// (277쪽)
		// 텍스트 파일에서 단어별 수를 세어 빈도표로 나타내는 일을 한다.
		// 이 코드는 스트림을 가잠한 반복문 코드다.
		Map<String, Long> freq = new HashMap<>();
		try (Stream<String> words = new Scanner(file).tokens()) {
			// 모든 작업이 forEach에서 일어난다.
			// foreach는 스트림이 수행한 연산 결과를 보여주는 것만 하여야 하는데, 그 이상의 것을 하므로 문제가 된다.
			words.forEach(word -> {
				freq.merge(word.toLowerCase(), 1L, Long::sum);
			});
		}

		System.out.println(freq);

		// 코드 46-3 빈도표에서 가장 흔한 단어 10개를 뽑아내는 파이프라인 (279쪽)
		List<String> topTen = freq.keySet().stream().sorted(comparing(freq::get).reversed()).limit(10).collect(toList());

		System.out.println(topTen);
	}
}
