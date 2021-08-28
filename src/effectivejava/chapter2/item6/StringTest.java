package effectivejava.chapter2.item6;

// StringTest
public class StringTest {
   
    public static void main(String[] args) {

    	// 실행될 때마다 String 인스턴스를 따로 만든다.
    	String s1 = new String();
    	String s2 = new String();
    	System.out.println(s1 == s2);
    	
    	// 새로운 인스턴스를 매번 만드는 대신 하나의 String 인스턴스를 사용한다.
    	String s3 = "h";
    	String s4 = "h";
    	System.out.println(s3 == s4);
    }
}
