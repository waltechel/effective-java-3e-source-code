package effectivejava.chapter9.item65;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 리플렉션으로 활용한 인스턴스화 데모
public class ReflectiveInstantiation {

	// 코드 65-1 리플렉션으로 생성하고 인터페이스로 참조해 활용한다. (372-373쪽)

	/**
	 * args에 들어간 클래스명과 파라미터를 출력한다.
	 * 이 소스는 다음과 같은 문제가 있다.
	 * 1. 런타임에 여섯 가지나 되는 에러를 던질 수 있다
	 * 2. 클래스 이름만으로 인스턴스를 생성하기 위해 몇 십 줄 이나 썼다.
	 * 3. 비검사 형변환 코드도 뜬다.
	 * ㅁ 어노테이션은 리플렉션과 다르다.
	 * - 어노테이션을 처리하는 방법에서 리플렉션을 사용하지 않는다.
	 * - 어노테이션 프로세서?
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 클래스 이름을 Class 객체로 변환
		
		Set<Integer> set = new HashSet<>(); 

		Class<? extends Set<String>> cl = null;
		try {
			// 심지어 여기서는 exit 소스도 있다.
			// 심지어 java.util.ArrayList로 선언해도 여기가 통과된다.
			// 비검사 형변환!
			cl = (Class<? extends Set<String>>) Class.forName(args[0]);
		} catch (ClassNotFoundException e) {
			fatalError("클래스를 찾을 수 없습니다.");
		}
		
		// 생성자를 직접 찾을 수가 있다.
		Constructor<? extends Set<String>> cons = null;
		try {
			cons = cl.getDeclaredConstructor();
		} catch (NoSuchMethodException e) {
			fatalError("매개변수 없는 생성자를 찾을 수 없습니다.");
		}

		// 찾은 생성자를 바탕으로 집합의 인스턴스를 만든다.
		Set<String> s = null;
		try {
			s = cons.newInstance();
		} catch (IllegalAccessException e) {
			fatalError("생성자에 접근할 수 없습니다.");
		} catch (InstantiationException e) {
			fatalError("클래스를 인스턴스화할 수 없습니다.");
		} catch (InvocationTargetException e) {
			fatalError("생성자가 예외를 던졌습니다: " + e.getCause());
		} catch (ClassCastException e) {
			fatalError("Set을 구현하지 않은 클래스입니다.");
		}

		// 비즈니스 로직은 한 줄밖에 되지 않는데, 이걸 구현하는 데 너무 많은 작업이 들어간다.
		s.addAll(Arrays.asList(args).subList(1, args.length));
		System.out.println(s);
	}

	private static void fatalError(String msg) {
		System.err.println(msg);
		System.exit(1);
	}
}
