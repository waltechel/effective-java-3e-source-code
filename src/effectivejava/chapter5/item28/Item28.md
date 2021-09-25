
---
# 아이템 28. 배열보다는 리스트를 사용하라.

---
## 배열과 리스트의 차이점
- 배열은 공변 타입이다.
	- SubClass가 SuperClass의 하위 타입이라면
	- SubClass[] 는 SuperClass[] 의 하위 타입이 된다.
- 리스트는 불변 타입이다.
	- List<SubClass> 타입은 List<SuperClass> 의 하위 타입이 되지 않는다.
```java
	// 런타임에서 실패한다.
	Object[] A = new Long[1];
	A[0] = "타입이 달라 넣을 수 없다.";

	// 다음 소스는 컴파일 시 에러가 난다.
	List<Object> B = new ArrayList<Long>();
	B.add("타입이 달라 넣을 수 없다.");
```

## 배열과 리스트의 차이점 2
- 배열은 실체화 된다.
	- 런타임시에도 자신이 담기로한 원소의 타입을 인지하고 확인한다.
- 제네릭을 활용한 리스트는 타입 정보가 런타임에는 소거된다.
	- 제네릭이 지원되기 전의 레거시 코드와 제네릭 타입을 병존하게 해주는 메커니즘이다.

---

## 제네릭 리스트 배열을 만들지 못하는 이유
- 제네릭 리스트 배열 생성이 가능하게끔 해주면, 배열의 공변성 때문에 리스트에 문제가 생길 수 있다.
```java
		// 코드 28 - 3
		// 제네릭 배열 생성을 허용하지 않는 이유 - 컴파일되지 않는다.
		List<String>[] stringLists = new ArrayList<String>[10]; // 에러가 나는 부분은 여기
		List<Integer> intList = new ArrayList<Integer>();
		Object[] objectList = stringLists;
		objectList[0] = intList;
		String s = stringLists[0].get(0);
```

---
## 핵심 정리
- 제네릭은 불변이고, 타입 정보가 소거된다.
- 배열은 런타임에는 타입 안전하지만, 컴파일 타입에는 안전하지 않다.
- 제네릭과 배열을 섞어 쓴다면, 가장 먼저 배열을 리스트로 대체하는 방법을 적용해보도록 한다.

