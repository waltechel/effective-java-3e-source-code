package effectivejava.chapter9.item60;

public class item60_03IntChange {
	// 코드 60-3 정수 타입을 사용한 해법 (357쪽)
	public static void main(String[] args) {
		int itemsBought = 0;
		int funds = 100;
		for (int price = 10; funds >= price; price += 10) {
			funds -= price;
			itemsBought++;
		}
		// 모든 계산을 달러 대신 센트로 수행하면 이 문제가 해결된다.
		System.out.println(itemsBought + "개 구입");
		System.out.println("잔돈(센트): " + funds);
	}
}
