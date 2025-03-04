package effectivejava.chapter4.item17;

// 코드 17-1 불변 복소수 클래스 (106-107쪽)
// final 클래스로 선언한다.
public final class Complex {
	
	// 필드를 private final로 구성한다.
	private final double re;
	private final double im;

	// 불변 클래스에서 자주 사용되는 인스턴스를 상수화한다.
	// 자주 사용되는 인스턴스는 캐싱해서 중복 생성하지 않도록 한다.
	// 메모리 사용량과 가비지 컬렉션 비용이 줄어든다.
	public static final Complex ZERO = new Complex(0, 0);
	public static final Complex ONE = new Complex(1, 0);
	public static final Complex I = new Complex(0, 1);

	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	public double realPart() {
		return re;
	}

	public double imaginaryPart() {
		return im;
	}

	// add가 아니라 plus 전치사를 사용하는 것은 해당 메서드가 객체의 값을 변경하는 게 아니라는 사실을 강조한다.
	public Complex plus(Complex c) {
		return new Complex(re + c.re, im + c.im);
	}

	// 코드 17-2 정적 팩터리(private 생성자와 함께 사용해야 한다.) (110-111쪽)
	// 새로운 객체를 그냥 만들어라.
	public static Complex valueOf(double re, double im) {
		return new Complex(re, im);
	}

	public Complex minus(Complex c) {
		return new Complex(re - c.re, im - c.im);
	}

	public Complex times(Complex c) {
		return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
	}

	public Complex dividedBy(Complex c) {
		double tmp = c.re * c.re + c.im * c.im;
		return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Complex))
			return false;
		Complex c = (Complex) o;

		// == 대신 compare를 사용하는 이유는 63쪽을 확인하라.
		return Double.compare(c.re, re) == 0 && Double.compare(c.im, im) == 0;
	}

	@Override
	public int hashCode() {
		return 31 * Double.hashCode(re) + Double.hashCode(im);
	}

	@Override
	public String toString() {
		return "(" + re + " + " + im + "i)";
	}
}
