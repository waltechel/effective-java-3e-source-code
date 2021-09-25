package effectivejava.chapter6.item36;

import java.util.EnumSet;
import java.util.Objects;

// 코드 36-2 EnumSet - 비트 필드를 대체하는 현대적 기법 (224쪽)
public class PurchaseMent {
	public enum Status {
		INVOICE, PAYMENT, CALMASTER, ERPMASTER
		// 추가해도 안전하게 돌아가는 것
//		, WAREHOUSINGMASTER
	}

	public EnumSet<Status> status;

	public PurchaseMent() {
//		status = new EnumSet()
		status = EnumSet.noneOf(Status.class);
	}

	// 어떤 Set을 넘겨도 되나, EnumSet이 가장 좋다.
	public void printStatus() {
		System.out.printf("Purchasement status is %s%n", Objects.requireNonNull(status));
	}

	public boolean isSafe() {
		if (status.equals(EnumSet.allOf(Status.class))) {
			return true;
		}
		return false;
	}

	// 사용 예
	public static void main(String[] args) {
		PurchaseMent purchasement = new PurchaseMent();
		purchasement.status.add(Status.INVOICE);
		purchasement.status.add(Status.ERPMASTER);
		purchasement.printStatus();

		if (purchasement.isSafe()) {
			System.out.println("purchasement is safe");
		} else {
			System.out.println("purchasement is not safe");
		}

	}
}
