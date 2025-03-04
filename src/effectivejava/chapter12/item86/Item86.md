---
# 아이템 86. Serializable을 구현할지는 신중히 결정하라.

---
## Serializable을 구현하여 생기는 문제
1. Serializable을 구현하면 릴리스한 뒤에는 수정하기 어렵다.
2. 버그와 보안 구멍이 생길 위험이 높아진다.
	- 역직렬화는 어찌보면 생성자를 우회하여 만들 수 있는 개구멍이 된다.
3. 신버전을 릴리스할 때 테스트할 것이 늘어나게 된다.

---
## Serailizable의 구현
- 역사적으로 BigInteger, Instant 같은 값 클래스와 컬렉션 클래스들은 Serializable을 구현하고,
- 스레드풀처럼 동작하는 클래스들은 Serializable을 사용하지 않았다.

---
## 직렬화와 상속
- 상속용으로 설계된 클래스(부모 클래스)는 대부분 Serializable을 구현하면 안된다
- Serializable을 구현하지 않기로 할 때는 그 하위 클래스에서 직렬화를 할 때 부담이 생긴다
- 상위 클래스가 매개변수 없는 생성자(기초 생성자)를 제공하여야 한다.
- 상위 클래스가 매개변수 없는 생성자를 제공하지 않으면 직렬화 프록시 패턴을 활용하여야 한다.
- 내부 클래스는 직렬화를 구현하지 않도록 한다.

---
## 핵심정리
- Serializable을 구현할지는 신중히 결정하라.