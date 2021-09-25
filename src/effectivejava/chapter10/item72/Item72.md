---
# 아이템 72. 표준 예외를 사용하라.

---
## 표준 예외
- 자주 쓰이는 예외의 사례
1. IllegalArgumentException
	- 허용하지 않는 값이 인수로 건네졌을 때
	- 반복횟수에 매개변수로 음수가 건네졌을 때
2. IllegalStateException
	- 객체가 제대로 초기화되지 않은 상태일 때
3. NullPointerException
4. IndexOutOfBoundsException
	- 시퀀스의 허용 범위를 넘는 경우
5. ConcurrentModificationException
	- 단일 스레드에서 사용하려고 설계한 객체에 여러 스레드가 동시에 수정하려 할 때
6. UnsupportedOperationException
	- 대상 객체가 지원하지 않을 때 던진다
7. ArithmeticException
	- 0으로 나눌 때
8. NumberFormatException
	- 숫자 형식에 오류가 있을 때

---
## 다음 예외는 절대로 바로 사용하지 않는다.
- Exception, RuntimeException, Throwable, Error는 직접 재사용하지 말자.

---
## 핵심정리
- 자주 쓰이는 예외는 적당히 잘 사용하자.