package effectivejava.chapter10.item71;

import java.util.ArrayList;
import java.util.List;

public class item71Example003 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();

		if (!isEmpty(list)) {
			int minNum = getMinimum(list);
		}else {
			// 비검사 예외 처리
			System.err.println("비검사 예외");
		}

	}

	private static boolean isEmpty(List<Integer> list) {
		return list == null || list.isEmpty();
	}

	private static int getMinimum(List<Integer> list) {
		int ret = Integer.MAX_VALUE;
		for (Integer e : list) {
			ret = Math.min(ret, e);
		}
		return ret;
	}

}
