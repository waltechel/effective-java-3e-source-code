package effectivejava.chapter2.item2.javabeans;

// 코드 2-2 자바빈즈 패턴 - 일관성이 깨지고, 불변으로 만들 수 없다. (16쪽)
public class NutritionFacts {
	// 매개변수들은 (기본값이 있다면) 기본값으로 초기화된다.
	private int servingSize = -1; // 필수; 기본값 없음
	private int servings = -1; // 필수; 기본값 없음
	private int calories = 0;
	private int fat = 0;
	private int sodium = 0;
	private int carbohydrate = 0;

	public NutritionFacts() {
	}

	// Setters
	public void setServingSize(int val) {
		servingSize = val;
	}

	public void setServings(int val) {
		servings = val;
	}

	public void setCalories(int val) {
		calories = val;
	}

	public void setFat(int val) {
		fat = val;
	}

	public void setSodium(int val) {
		sodium = val;
	}

	public void setCarbohydrate(int val) {
		carbohydrate = val;
	}

	public static void main(String[] args) {
		// javaBean pattern
		// parameterless constructor to create the object and call
		// setter methods
		// 객체 하나를 만들려면 메서드를 여러 개 호출하여야 한다.
		// 객체가 완전히 생성되기 전까지는 일관성이 없는 상태
		NutritionFacts cocaCola = new NutritionFacts();
		cocaCola.setServingSize(240);
		cocaCola.setServings(8);
		cocaCola.setCalories(100);
		cocaCola.setSodium(35);
		cocaCola.setCarbohydrate(27);
	}
}
