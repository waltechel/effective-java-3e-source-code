package effectivejava.chapter10.item71;

import java.util.ArrayList;
import java.util.List;

public class item71Example001 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		int minNum = getMinimum(list);

	}

	private static int getMinimum(List<Integer> list) {
		int ret = Integer.MAX_VALUE;
		for (Integer e : list) {
			ret = Math.min(ret, e);
		}
		return ret;
	}

}
