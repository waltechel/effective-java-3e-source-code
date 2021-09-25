
---
# 아이템 31. 한정적 와일드카드를 이용해서 API 유연성을 높여라

### 유연성을 극대화하려면 원소의 생산자나 소비자용 입력 매개변수에 와일드카드 타입을 사용하라.

---
### (Iterable<? extends E> e)
- producer - extend , consumer - super 이라고 외운다.
- 리턴을 할 때는 super 타입으로 리턴한다.

---
### 핵심 정리
- Comparable, Comparator는 언제나 소비자이므로 super를 사용하는 게 좋다.

