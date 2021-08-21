package effectivejava.chapter4.item20;

public interface ExampleInterface {

	default int mulitply(int a, int b) {
		return a * b;
	}
	
	int calulate(int a, int b);
}
