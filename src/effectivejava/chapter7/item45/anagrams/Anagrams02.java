package effectivejava.chapter7.item45.anagrams;

import static java.util.stream.Collectors.groupingBy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

// 코드 45-2 스트림을 과하게 사용했다. - 따라 하지 말 것! (270-271쪽)
public class Anagrams02 {
    public static void main(String[] args) throws IOException {
        Path dictionary = Paths.get("src/effectivejava/chapter7/item45/sample.txt");
        int minGroupSize = 33;

        // try-with-resource구문을 사용한다.
        // 스트림을 과하게 사용하면 프로그램을 읽거나 유지보수하기 어려워진다.
        try (Stream<String> words = Files.lines(dictionary)) {
            words.collect(
                    groupingBy(word -> word.chars().sorted()
                    		// 이런 소스는 도대체 뭘까
                            .collect(StringBuilder::new,
                                    (sb, c) -> sb.append((char) c),
                                    StringBuilder::append).toString()))
                    .values().stream()
                    .filter(group -> group.size() >= minGroupSize)
                    .map(group -> group.size() + ": " + group)
                    .forEach(System.out::println);
        }
    }
}
