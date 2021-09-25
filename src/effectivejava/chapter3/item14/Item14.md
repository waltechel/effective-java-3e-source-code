---
# 아이템 14. Comparable을 구현할지 고려하라.

---
## CompareTo 메서드의 일반 규약은 equals의 규약과 비슷하다.


---
## 핵심 정리
- 순서를 고려해야 하는 값 클래스를 작성한다면 꼭 Comparable 인터페이스를 구현하라.
- CompareTo 메서드에서 필드의 값을 비교할 때 <> 연산자는 쓰지 않도록 한다.
- lambda Expression을 적극적으로 사용하라.