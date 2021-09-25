---
# 아이템 10. equals는 일반 규약을 지켜 재정의하라

---
## 다음의 상황이라면 equals를 재정의하지 말아야 한다.

1. 본질적으로 고유한 인스턴스일 때
2. 논리적 동치성을 검증해야 하는 일이 사실 없을 때
3. 상위 클래스에서 재정의한 equals를 그냥 써도 될 때
4. equals를 호출할 일이 없을 때

---
## 다음의 상황이라면 equals를 재정의하여야 한다
1. 논리적 동치성을 검증해야 할 때
2. 상위 클래스에서 정의한 equals는 검증하지 않을 때

---
## equals는 다음 조건을 반드시 따라야 한다.
1. reflexivity : x.equals(x) is true
2. symmetry : x.equals(y) is true, y.equals(x) is true
3. transitivity : x.equals(y) is true and y.equals(z) is true, x.equals(z) is true
4. consistency(일관성) : 한번 x.equals(y) 가 true이면 반복해서 하더라도 true
5. not null : x.equals(null) is false

---
## 대칭성symmetry을 위배한 코드
```java
// 일반 Point를 ColorPoint와 비교했을 때의 결과가 다를 수 있다.
// Point.equals(ColorPoint) is true
// ColorPoint.equals(Point) is true?
@Override public boolean equals(Object o) {
		if (!(o instanceof Point))
				return false;
		Point p = (Point)o;
		return p.x == x && p.y == y;
}
```
___
## 추이성transitivity을 위배한 코드

* 구체 클래스를 확장해서 새로운 값을 추가하면서 equals 규약을 만족시킬 방법은 사실 존재하지 않는다.

```java
@Override public boolean equals(Object o) {
  if (!(o instanceof Point))
    return false;

	// o가 일반 Point면 색상을 무시하고 비교한다.
  if (!(o instanceof ColorPoint))
    return o.equals(this);

	// o가 ColorPoint면 색상까지 비교한다.
  return super.equals(o) && ((ColorPoint) o).color == color;
}

```
## equals 메서드 구현 방법
1. == 연산자를 활용해 입력이 자기 자신의 참조인지 확인한다.
	1. Integer.compare, Double.compare 적극 활용한다.
2. instanceof 연산자로 입력이 올바른 타입인지 확인한다.
3. 입력을 올바른 타입으로 형변환한다
4. 입력 객체와 자기 자신의 대응되는 핵심 필드들이 모두 일치하는지 하나씩 검사한다.
5. null 체크는 따로 한다.
6. 다를 가능성이 더 큰 필드를 비교하거나, 비용이 싼 필드를 먼저 비교한다.
7. equals를 재정의할 때는 hashcode도 반드시 재정의한다.
8. 복잡하게 짜지 말라
9. Object 외의 타입을 매개변수로 받는 equals 메서드는 절대 선언하지 말자

```java
@Override
public boolean equals(Object o) {
	if (o == this){
		return true;
	}
	if (o == null){
		return false;
	}
	if (!(o instanceof PhoneNumber)){
		return false;
	}
	PhoneNumber pn = (PhoneNumber) o;
	return pn.lineNum == lineNum && pn.prefix == prefix	&& pn.areaCode == areaCode;
}

```
---
## 핵심 정리
- 반드시 필요한 경우가 아니면 equals를 재정의하면 안된다.
- 많은 경우에 Object의 equals가 우리가 원하는 비교를 정확히 수행해준다.
- 재정의해야 할 때는 클래스의 핵심 필드 모두를 빠짐없이 수행해야 한다.

