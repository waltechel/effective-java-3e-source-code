---
# 아이템 57. 지역변수의 범위를 최소화하라

---
## 지역변수의 범위를 최소화하라
- 지역변수의 범위를 줄이는 가장 강력한 기법은 가장 처음 쓰일 때 선언하는 것이다.
- 지역변수는 선언과 동시에 초기화하여야 한다.
- for 문은 while 문 보다 낫다.

```java
// good
ArrayList<Integer> list = new ArrayList<>();
for(int i = 0 ; i < 1000 ; i++){
	list.add(i);
}

// bad
// 변수 범위가 최소화되지 않는다.
list = new ArrayList<>();
int i = 0;
while(i++ < 1000){
	list.add(i);
}
```

- 지역변수의 범위를 최소화하는 또 다른 반복문 관용구
```java
// bad
int N = A.length + maxOfArray(A);
for(int i = 0 ; i < N ; i++){
	int n = A[i];
}
// good
for(int i = 0, length = A.length + maxOfArray(A) ; i < length; i++){
	int n = A[i];
}
```
- 지역변수 범위를 최소화하는 마지막 방법은 메서드를 작게 유지하고 한 가지 기능에 집중하는 것이다.


