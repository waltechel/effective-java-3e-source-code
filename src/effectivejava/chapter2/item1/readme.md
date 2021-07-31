
---
# 아이템 1. 생성자 대신 정적 팩터리 메서드를 고려하라.

---
## 정적 팩토리 메서드가 생성자보다 좋은 장점 다섯 가지

1. 이름을 가질 수 있다.
	- 생성자는 클래스명으로 통일되는데 이름을 따로 지정할 수 있다.
2. 호출될 때마다 인스턴스를 새로 생성하지는 않아도 된다.
3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
5. 정적 팩토리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.

---

## 정적 팩토리 메서드의 단점
1. 상속을 하려면 public 이나 protected 생성자가 필요하니
정적 팩토리 메서드만 제공하면 하위 클래스를 만들 수 없다.
2. 정적 팩토리 메서드는 프로그래머가 사용하기 어렵다.
다음은 정적 팩토리 메서드에 주로 사용하는 네이밍 룰이다.

```java
// from
Date d = Date.from(instant);

// of
Set<Rank> cards = EnumSet.of(JACK, QUEEN, KING);

// valueOf
BigInteger intMax = BigInteger.valueOf(Integer.MAX_VALUE);

// getInstance
StackWalker walker = StackWalker.getInstance(options);

// newInstance
Object newArray = Array.newInstance(classObject, lengthOfArray);

// getType(Type : 객체의 타입)
FileStore fileStore = Files.getFileStore(path);

// newType(Type : 객체의 타입)
// new BufferedReader(new FileReader(path)); 가 통용되는데
BufferedReader br = Files.newBufferedReader(path);

// type
List<Complaint> litany = Collections.list(legacyLitany);

```
---
## 핵심 정리
* 정적 팩터리 메서드와 public 생성자는 각각의 쓰임새가 있으니 상대적인 장단점을 이해하고 사용한다.
* 막무가내로 public 생성자를 갖다 쓰는 습관이 있으면 고쳐야 한다.


