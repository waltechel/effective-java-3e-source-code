package effectivejava.chapter10.item71;

import java.util.ArrayList;
import java.util.List;

public class item71Example002 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		try {
			int minNum = getMinimum(list);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static int getMinimum(List<Integer> list) throws NoArgumentException {
		if (list.isEmpty()) {
			throw new NoArgumentException();
		}
		int ret = Integer.MAX_VALUE;
		for (Integer e : list) {
			ret = Math.min(ret, e);
		}
		return ret;
	}

}
