package effectivejava.chapter6.item37;

import java.util.HashSet;
import java.util.Set;

// EnumMap을 사용해 열거 타입에 데이터를 연관시키기 (226-228쪽)

// 식물을 아주 단순하게 표현한 클래스 (226쪽)
class PlantBad {
	enum LifeCycle {
		// ANNUAL : 해살이
		// PERENNIAL : 여러해살이
		// BIENNIAL : 두해살이(예 : 접시꽃)
		ANNUAL, PERENNIAL, BIENNIAL
	}

	final String name;
	final LifeCycle lifeCycle;

	PlantBad(String name, LifeCycle lifeCycle) {
		this.name = name;
		this.lifeCycle = lifeCycle;
	}

	@Override
	public String toString() {
		return name;
	}

	public static void main(String[] args) {
		PlantBad[] garden = { 
				new PlantBad("바질", LifeCycle.ANNUAL), new PlantBad("캐러웨이", LifeCycle.BIENNIAL),
				new PlantBad("딜", LifeCycle.ANNUAL), new PlantBad("라벤더", LifeCycle.PERENNIAL),
				new PlantBad("파슬리", LifeCycle.BIENNIAL), new PlantBad("로즈마리", LifeCycle.PERENNIAL) };

		// 코드 37-1 ordinal()을 배열 인덱스로 사용 - 따라 하지 말 것! (226쪽)
		// 배열은 제네릭과 호환되지 않으므로 형변환을 하여야 한다.
		Set<PlantBad>[] plantsByLifeCycleArr = (Set<PlantBad>[]) new Set[PlantBad.LifeCycle.values().length];
		for (int i = 0; i < plantsByLifeCycleArr.length; i++) {
			plantsByLifeCycleArr[i] = new HashSet<>();
		}
		
		// 만약에 중간에 3년살이가 하나 들어가게 된다면 코딩이 엉망된다.
		for (PlantBad p : garden) {
			plantsByLifeCycleArr[p.lifeCycle.ordinal()].add(p);
		}
		// 결과 출력
		for (int i = 0; i < plantsByLifeCycleArr.length; i++) {
			System.out.printf("%s: %s%n", PlantBad.LifeCycle.values()[i], plantsByLifeCycleArr[i]);
		}

	}
}
