---
# 아이템 3. private 생성자나 열거 타입으로 싱글턴임을 보증하라.

---
## SingleTon
- 인스턴스를 오직 하나만 생성할 수 있는 클래스


## SingleTon 클래스를 만드는 방법
- private으로 감춰두고, 유일한 인스턴스에 접근할 수 있는 수단으로 public static 멤버 만들기
- 해당 클래스가 싱글톤임이 API에 명백하게 드러난다.
- 간결하다.
```java
public class Elvis{
	public static final Elvis INSTANCE = new Elvis();
}
```

- 흔히 보는 방식으로, 정적 팩토리 메서드를 public static 멤버로 제공한다
- 메서드를 바꾸면 싱글턴이 아니게 변경할 수도 있다.
```java
public class Elvis{
	private static final Elvis INSTANCE = new Elvis();
	public static Elvis getInstance(){
		return INSTANCE;
	}
}
```

- 원소가 하나인 열거 타입을 선언하는 방법도 있다.
- 열거 타입은 이미 캐싱 기법을 활용하고 있다는 점에 기댄 전략
- 대부분의 상황에서는 원소가 하나 뿐인 열거 타입이 싱글턴을 만드는 가장 좋은 방법이 될 수 있다
- 단 만들려는 싱글턴이 클래스를 상속해야 한다면 이 방법은 사용할 수 없다.
public enum Elvis{
	INSTANCE;
}

---
## 핵심 정리
-


