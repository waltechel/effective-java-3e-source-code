package effectivejava.chapter6.item37;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

// 코드 37-6 중첩 EnumMap으로 데이터와 열거 타입 쌍을 연결했다. (229-231쪽)
public enum PhaseGood {
//	SOLID, LIQUID, GAS;

	// 추가하려면 다음의 소스를 실행한다.
	// EnumMap 버전에서는 상태 목록에 PLASMA를 추가하고, 전이 목록에 IONIZE(GAS, PLASMA)와 DEIONIZE(PLASMA, GAS)만 추가하면 끝
	 SOLID, LIQUID, GAS, PLASMA;
	public enum Transition {
		MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID), BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID), SUBLIME(SOLID, GAS),
		DEPOSIT(GAS, SOLID), IONIZE(GAS, PLASMA), DEIONIZE(PLASMA, GAS);

		// 추가하려면 다음의 소스를 실행한다.
		 

		private final PhaseGood from;
		private final PhaseGood to;

		Transition(PhaseGood from, PhaseGood to) {
			this.from = from;
			this.to = to;
		}

		// 상전이 맵을 초기화한다.
		private static final Map<PhaseGood, Map<PhaseGood, Transition>> m = Stream.of(values())
				// 이전 상태를 기준으로 묶는다.
				.collect(groupingBy(t -> t.from, () -> new EnumMap<>(PhaseGood.class),
				// 이후 상태를 전이에 대응한다.		
//						toMap(t -> t.to, t -> t, (x, y) -> y, () -> new EnumMap<>(PhaseGood.class))));
		toMap(t -> t.to, t -> t, (x, y) -> y, () -> new EnumMap<>(PhaseGood.class))));

		public static Transition transfer(PhaseGood from, PhaseGood to) {
			return m.get(from).get(to);
		}
	}

	// 간단한 데모 프로그램 - 깔끔하지 못한 표를 출력한다.
	public static void main(String[] args) {
		for (PhaseGood src : PhaseGood.values()) {
			for (PhaseGood dst : PhaseGood.values()) {
				Transition transition = Transition.transfer(src, dst);
				if (transition != null)
					System.out.printf("%s에서 %s로 : %s %n", src, dst, transition);
			}
		}
	}
}
