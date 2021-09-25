package effectivejava.chapter10.item71;

public class NoArgumentException extends Exception {

	int INSTALLED;
	int UNFINISHED;
	int NEXTOPER;
	int ERROR_CODE;
	
	public NoArgumentException() {
		super("사용자 정의 예외 : 요소가 비어 있습니다.");
		this.ERROR_CODE = 3;
	}
	
	public int getErrorCode() {
		return this.ERROR_CODE;
	}
	

}
