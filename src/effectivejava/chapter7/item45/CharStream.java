package effectivejava.chapter7.item45;

// char 데이터를 처리할 때는 스트림 사용을 자제하자. (272쪽)
public class CharStream {
	
	// 자바가 기본 타입인 char용 스트림을 지원하지 않는다.
	public static void main(String[] args) {
		// 예상한 결과와 다르다.
		"Hello world!".chars().forEach(System.out::print);
		System.out.println();

		// 문제를 고치려면 형변환을 명시적으로 해줘야 한다.
		"Hello world!".chars().forEach(x -> System.out.print((char) x));
		System.out.println();
	}
}
