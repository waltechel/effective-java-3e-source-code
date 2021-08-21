package effectivejava.chapter5.item29;

import java.util.Arrays;

class MyStackObjectVer<E> {

	private Object[] elements;
	private int top = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public MyStackObjectVer(E[] elements, int top) {
		super();
		this.elements = elements;
		this.top = top;
	}

	// @SuppressWarnings("unchecked")
	public MyStackObjectVer() {
		super();
		// 문제 1.
		// 실체화 불가 타입으로는 배열을 만들 수 없다.
		// Cannot create a generic array of E
		// this.elements = new E[DEFAULT_INITIAL_CAPACITY];

		// 문제 2.
		// 타입 안전하지 않다.
		// Type safety: Unchecked cast from Object[] to T[]
		// 동작은 되는 소스 그러나 warning을 없애는 것이 가장 좋겠다.
		this.elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];

		// 해결 방법 1.
		// 사실 타입이 어느 정도 E라고 확정되어 있으므로 경고를 무시하게끔 한다.
		// @SuppressWarnings("unchecked")
		// @SuppressWarnings("unchecked") 의 주석을 풀어 본다.

		// 해결 방법 2.
		// elements 필드의 타입을 E[] 에서 Object[] 로 바꾸는 것이다.
		this.top = 0;
	}

	public void push(E e) {
		ensureCapacity();
		elements[top++] = e;
	}

	// 해결 방법 2.
	// elements 필드의 타입을 E[] 에서 Object[] 로 바꾸는 것이다.
	@SuppressWarnings("unchecked")
	public E pop() {
		if (top == 0) {
			throw new EmptyStackException();
		}
		E ret = (E) elements[--top];
		elements[top] = null;
		return ret;
	}

	public boolean isEmpty() {
		return top == 0;
	}

	private void ensureCapacity() {
		if (this.elements.length == top) {
			elements = Arrays.copyOf(elements, 2 * top + 1);
		}
	}
}
