
---
# 아이템 21. 인터페이스는 구현하는 쪽을 생각해 설계하라.

---
## 모든 상황을 만족하는 디폴트 메서드를 작성하는 것은 어렵다.

- 디폴트 메서드 : 인터페이스에서 구현체에 구현을 요구하지 않는 메서드
- 구현 클래스에 대해 아무것도 모른 채 무작정 만들어지는 경향이 강하다.

---
## 사례탐구
- 다음은 java 8 Collection Interface에 추가된 디폴트 메서드(추측)이다.

```java
default boolean removeIf(Predicate<? super E> filter){
	Objects.requireNonNull(filter);
	boolean result = false;
	Iterator<E> it = iterator();
	while(it.hasNext()){
		if(filter.test(it.next())){
			it.remove();
			result = true;
		}
	}
	return result;
}
```
- 상기된 메서드는 org.apache.commons.collections4.collection.SynchronizedCollection과 잘 호환되지 않을 수 있다.
- 이름에서 나타나듯 동기화가 중요한 컬렉션인데, 상기 메서드는 동기화에 대해 고려가 되어 있지 않다.
- 디폴트 메서드는 기존 구현체에 런타임 오류를 일으킬 수 있다.

---
## 핵심 정리
* 인터페이스를 설계할 때는 여전히 세심한 주의를 기울이자.
