package effectivejava.chapter5.item28;

import java.util.ArrayList;
import java.util.List;

public class Chapter28Test {

	public static void main(String[] args) {

		// 런타임에서 실패한다.
		Object[] A = new Long[1];
		A[0] = "타입이 달라 넣을 수 없다.";
		

		// 다음 소스는 컴파일 시 에러가 난다.
		List<Object> B = new ArrayList<Long>();
		B.add("타입이 달라 넣을 수 없다.");
		
		// 코드 28 - 3 
		// 제네릭 배열 생성을 허용하지 않는 이유 - 컴파일되지 않는다.
		List<String>[] stringLists = new ArrayList<String>[10];
		List<Integer> intList = new ArrayList<Integer>();
		Object[] objectList = stringLists;
		objectList[0] = intList;
		String s = stringLists[0].get(0);
		
	}

}
