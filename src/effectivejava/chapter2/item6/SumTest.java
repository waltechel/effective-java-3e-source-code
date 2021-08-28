package effectivejava.chapter2.item6;

// 코드 6-3 끔찍이 느리다! 객체가 만들어지는 위치를 찾았는가? (34쪽)
public class SumTest {
   
    public static void main(String[] args) {

    	// long을 Long으로만 바꾸면 어마어마하게 느려진다.
    	// 박싱된 기본 타입보다는 primitive 타입을 사용하고, 의도치 않은 오토박싱이 들어가지 않도록 주의한다.
    	long x = 0;
        long start = System.nanoTime();
        for(long i = 0 ; i < Integer.MAX_VALUE ; i++) {
        	x += i;
        }
        long end = System.nanoTime();
        System.out.println((end - start) / 1_000_000. + " ms.");

        Long x2 = 0L;
        long start2 = System.nanoTime();
        for(long i = 0 ; i < Integer.MAX_VALUE ; i++) {
        	x2 += i;
        }
        long end2 = System.nanoTime();
        System.out.println((end2 - start2) / 1_000_000. + " ms.");
        
        // VM이 최적화하지 못하게 막는 코드
        if (x == 42 || x2 == 54)
            System.out.println();
    }
}
