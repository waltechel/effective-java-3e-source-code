package effectivejava.chapter9.item58;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;

// 코드 58-5 같은 버그, 다른 증상! (349쪽)
public class DiceRollsBad2 {
	enum Face {
		ONE, TWO, THREE, FOUR, FIVE, SIX
	}

	public static void main(String[] args) {
		// 같은 버그, 다른 증상!
		Collection<Face> faces = EnumSet.allOf(Face.class);

		// i와 j를 헷갈렸다!
		for (Iterator<Face> i = faces.iterator(); i.hasNext();)
			for (Iterator<Face> j = faces.iterator(); i.hasNext();)
				System.out.println(i.next() + " " + j.next());

	}
}
