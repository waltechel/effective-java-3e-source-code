package effectivejava.chapter2.item2.hierarchicalbuilder;

import static effectivejava.chapter2.item2.hierarchicalbuilder.NyPizza.Size.SMALL;
import static effectivejava.chapter2.item2.hierarchicalbuilder.Pizza.Topping.HAM;
import static effectivejava.chapter2.item2.hierarchicalbuilder.Pizza.Topping.ONION;
import static effectivejava.chapter2.item2.hierarchicalbuilder.Pizza.Topping.SAUSAGE;

// 계층적 빌더 사용 (21쪽)
public class PizzaTest {
	public static void main(String[] args) {
		NyPizza pizza = new NyPizza.Builder(SMALL).addTopping(SAUSAGE).addTopping(ONION).build();
		Calzone calzone = new Calzone.Builder().addTopping(HAM).sauceInside().build();

		System.out.println(pizza);
		System.out.println(calzone);
	}
}
