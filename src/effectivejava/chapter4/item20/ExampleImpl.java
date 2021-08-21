package effectivejava.chapter4.item20;

public class ExampleImpl implements ExampleInterface{

	@Override
	public int calulate(int a, int b) {
		int ret = mulitply(a, b);
		// 비즈니스 로직
		return 0;
	}

	
}
