package effectivejava.chapter9.item66;

/**
 * 만들지도 못하겠다 jni 파일;;;
 * 경로는 당연히 틀리다.
 * jni 파일은 c, h(header), class, dll(윈도우) 가 필요하다.
 * 
 * @author leedongjun
 */
public class Item66Example {

	static {
		System.loadLibrary("Native");
	}

	private native void print();

	public static void main(String[] args) {

		Item66Example jni = new Item66Example();

		jni.print();

	}
}
