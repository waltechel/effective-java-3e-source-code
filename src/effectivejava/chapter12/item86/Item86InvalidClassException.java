package effectivejava.chapter12.item86;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * https://tomining.tistory.com/80 참고
 * @author leedongjun
 *
 */
public class Item86InvalidClassException {

	public static void main(String[] args) throws Exception {
		Child c1 = new Child("child");

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("sample.dat"));
		out.writeObject(c1);
		out.close();

		ObjectInputStream in = new ObjectInputStream(new FileInputStream("sample.dat"));
		Parent p = (Child) in.readObject();
		System.out.println(p == null);
		System.out.println("p.parameterName is " + p.parameterName);
		in.close();
	}

	static class Parent {
		String parameterName;

		public Parent(String parameterName) {
			super();
			this.parameterName = parameterName;
		}

		// Exception in thread "main" java.io.InvalidClassException: 
		// effectivejava.chapter12.item86.Item86InvalidClassException$Child; no valid constructor
		// 상속용 클래스인데 직렬화를 지원하지 않으면 그 하위 클래스에서 직렬화를 지원하려 할 때 부담이 늘어난다.
		public Parent() {}
		
	}

	static class Child extends Parent implements Serializable {
		public Child(String name) {
			super(name);
		}
	}
}
