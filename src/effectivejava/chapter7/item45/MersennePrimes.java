package effectivejava.chapter7.item45;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

import java.math.BigInteger;
import java.util.stream.Stream;

// 스트림을 사용해 처음 20개의 메르센 소수를 생성한다. (274쪽)
// 메르센 소수 : 2^p - 1 형태의 소수(p : prime number)
public class MersennePrimes {
    static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }

    public static void main(String[] args) {
    	BigInteger bigInteger = BigInteger.ZERO.add(BigInteger.TWO).subtract(BigInteger.ONE);
    	// 2^Integer.MAX_VALUE
    	// int 배열로 구성되어 있다.
    	// Integer.MAX_VALUE : array를 구성할 수 있는 가장 큰 크기
    	// p가 소수이면, 2^p-1이 소수일 수 있다
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
        		// mersenne이 소수인지 아닌지를 본다
                .filter(mersenne -> mersenne.isProbablePrime(50))
                // 20개만 본다
                .limit(20)
                // mp.bitLength()는 지수, mp는 메르센 소수
                .forEach(mp -> System.out.println(mp.bitLength() + ": " + mp));
    }
}
