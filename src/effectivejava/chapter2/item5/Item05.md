---
# 아이템 6. 불필요한 객체 생성은 피하라

---
## 사례 탐구
```java
// 실행될 때마다 String Instance를 따로 만든다.
String s = new String("hello");
// 하나의 String Instance를 사용하며, 같은 가상 머신 안에서 똑같은 문자열 리터럴을 사용하는 모든 코드가
// 같은 객체를 재사용함이 보장된다.
String s = "hello";
```

---
## 핵심 정리
- 필요한 자원을 생성자에 넘겨주는 기법은 클래스의 유연성, 재사용성, 테스트 용이성을 개선해준다.


