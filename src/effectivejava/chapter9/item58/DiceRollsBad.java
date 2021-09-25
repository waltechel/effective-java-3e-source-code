package effectivejava.chapter9.item58;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;

// 코드 58-5 같은 버그, 다른 증상! (349쪽)
public class DiceRollsBad {
	enum Face {
		ONE, TWO, THREE, FOUR, FIVE, SIX
	}

	public static void main(String[] args) {
		// 같은 버그, 다른 증상!
		// enum은 클래스에서 바로 접근이 가능하다.
		// enum, nested enum의 default는 static final이다.
		Collection<Face> faces = EnumSet.allOf(Face.class);

		// j에 종속되었기 때문에 문제가 발생할 수 있다.
		for (Iterator<Face> i = faces.iterator(); i.hasNext();) {
			for (Iterator<Face> j = faces.iterator(); j.hasNext();) {
				System.out.println(i.next() + " " + j.next());
			}
		}

	}
}
