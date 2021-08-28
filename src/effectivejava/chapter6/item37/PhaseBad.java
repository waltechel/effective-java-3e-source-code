package effectivejava.chapter6.item37;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

// 코드 37-6 중첩 EnumMap으로 데이터와 열거 타입 쌍을 연결했다. (229-231쪽)
public enum PhaseBad {
	SOLID, LIQUID, GAS;

	public enum Transition {
		MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

		// 행은 from의 ordinal을, 열은 to의 ordinal을 인덱스로 사용하는 행렬? 처럼 구현한다.
		// 이 표의 크기는 상태의 가짓수가 늘어날수록 기하급수적으로 증가한다.
		private static final Transition[][] TRANSITIONS = { 
				{ null, MELT, SUBLIME }, 
				{ FREEZE, null, BOIL },
				{ DEPOSIT, CONDENSE, null } };

		public static Transition transfer(PhaseBad from, PhaseBad to) {
			return TRANSITIONS[from.ordinal()][to.ordinal()];
		}

	}

	// 간단한 데모 프로그램 - 깔끔하지 못한 표를 출력한다.
	public static void main(String[] args) {
		for (PhaseBad src : PhaseBad.values()) {
			for (PhaseBad dst : PhaseBad.values()) {
				Transition transition = Transition.transfer(src, dst);
				if (transition != null)
					System.out.printf("%s에서 %s로 : %s %n", src, dst, transition);
			}
		}
	}
}
