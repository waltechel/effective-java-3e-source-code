package effectivejava.chapter6.item37;
import java.util.*;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

// EnumMap을 사용해 열거 타입에 데이터를 연관시키기 (226-228쪽)

// 식물을 아주 단순하게 표현한 클래스 (226쪽)
class PlantGood {
    enum LifeCycle { ANNUAL, PERENNIAL, BIENNIAL }

    final String name;
    final LifeCycle lifeCycle;
    PlantGood(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override public String toString() {
        return name;
    }

    public static void main(String[] args) {
    	PlantGood[] garden = {
            new PlantGood("바질",    LifeCycle.BIENNIAL),
            new PlantGood("캐러웨이", LifeCycle.BIENNIAL),
            new PlantGood("딜",      LifeCycle.BIENNIAL),
            new PlantGood("라벤더",   LifeCycle.PERENNIAL),
            new PlantGood("파슬리",   LifeCycle.BIENNIAL),
            new PlantGood("로즈마리", LifeCycle.PERENNIAL)
        };

        // 코드 37-2 EnumMap을 사용해 데이터와 열거 타입을 매핑한다. (227쪽)
        Map<PlantGood.LifeCycle, Set<PlantGood>> plantsByLifeCycle =
                new EnumMap<>(PlantGood.LifeCycle.class);
        for (PlantGood.LifeCycle lc : PlantGood.LifeCycle.values()) {
        	plantsByLifeCycle.put(lc, new HashSet<>());        	
        }
        for (PlantGood p : garden) {
        	plantsByLifeCycle.get(p.lifeCycle).add(p);        	
        }
        System.out.println(plantsByLifeCycle);

        // 코드 37-3 스트림을 사용한 코드 1 - EnumMap을 사용하지 않는다! (228쪽)
        // 이 소스는 스트림을 사용했으므로 맵을 두 개 만든다.
        System.out.println(Arrays.stream(garden)
                .collect(groupingBy(p -> p.lifeCycle)));

        // 코드 37-4 스트림을 사용한 코드 2 - EnumMap을 이용해 데이터와 열거 타입을 매핑했다. (228쪽)
        // 원하는 맵 구현체를 명시해 호출할 수 있다.
        // 이 소스는 스트림을 사용했으므로 맵을 두 개 만든다.
        System.out.println(Arrays.stream(garden)
                .collect(groupingBy(p -> p.lifeCycle,
                        () -> new EnumMap<>(LifeCycle.class), toSet())));
    }
}
