---
# 아이템 55. Optional 반환에 신중하라.

---
## Optional
- Optional을 반환하는 메서드에서는 절대 null을 반환하지 말자.
- Optional을 반환을 선택해야 하는 기준은, 사용자에게 해당 값이 null이 아닐 수 있음을 명확히 알려준다.
- Optional 메서드
	- Optional.empty()
	- Optional.of(value)
	- Optional.ofNullable(value)

---
## 컬렉션, 스트림, 배열, 옵셔널 같은 컨테이너 타입은 옵셔널로 감싸면 안된다.
- 박싱된 기본 타입을 받는 Optional을 반환하는 일은 없도록 한다.

---
## 핵심 정리
- 옵셔널 반환에는 성능 저하가 뒤따르니, 성능에 민감한 메서드라면 null을 반환하거나 예외를 던지는 편이 나을 수 있다.