---
# 아이템 82. 스레드 안전성 수준을 문서화하자.

---
## 스레드 안전성 수준 5단계
1. 불변(immutable) : 이 클래스의 인스턴스는 상수라서 외부 동기화가 전혀 필요 없다.
	- String, Long, BigInteger
2. 무조건부 스레드 안전(unconditionally thread-safe) : 내부에서 충실히 동기화하여 외부 동기화 필요 없다.
	- ConcurrentHashMap, ArrayBlockingQueue
	- 이것들은 병렬적으로 수행이 가능하다.
3. 조건부 스레드 안전(conditionally thread-safe) : 일부 메서드는 외부에서 동기화할 필요가 있다.
	- Collections.synchronizedList(), Collections.synchronizedMap() 래퍼 메서드가 반환한 컬렉션
	- 이것들은 스레드 안전하지만 일부 병렬적으로 처리하려면 synchronized을 걸고 사용한다.
```java
List<String> list = Collections.synchronizedList(new ArrayList<>());
Map<String, Object> map = Collections.synchronizedMap(new HashMap<>());
Set<String> keySet = m.keySet()
// Collections.synchronizedMap 는 반복하려면 synchronized 블록 안에서만 사용 가능하다.
synchronized(map){
	for(String key : keySet){
		sysout(key);
	}
}
```
4. 스레드 위험(not-thread safe) : 이 메서드들은 동시에 사용하려면 클라이언트에서 작업을 처리하여야 한다.
	- ArrayList, HashMap
5. 스레드 적대적(thread-hostile) : 클라이언트에서 작업을 처리하더라도 스레드 위험하다.

---
- 클래스의 스레드 안전성은 보통 클래스의 문서화 주석에 기재하지만, 독특한 특성의 클래스라면 해당 메서드의 주석에 기재하도록 한다.

---
## 핵심정리
- 모든 클래스가 자신의 스레드 안전성 정보를 정확히 문서화하여야 한다.