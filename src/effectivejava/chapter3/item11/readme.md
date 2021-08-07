
---
# 아이템 11. equals를 재정의하려거든 hashcode도 재정의하라

---
## equals와 hashcode는 동전의 앞뒷면 관계이다.

1. equals에서 호출하는 hashcode 역시 reflexivity를 만족하여야 한다.
2. equals가 true라면, hashcode는 같은 값을 return하여야 한다.
3. equals가 false라도, hashcode는 같을 수 있다.
	1. equals가 false일 경우 hashcode는 다른 게 성능에 좋다.


---
## hashcode를 작성하는 요령
1. int result를 작성한 후 첫번째 중요 필드로 hash하여 초기화
2. 나머지 f 필드에 대해 다음 작업을 수행한다.
	1. 다른 필드를 해시한다.
	2. 해시함수로 result 를 갱신한다
3. 성능을 따지기 위해 핵심 필드를 생략하면 절대 안된다.
	1. 특정 필드는 해시코드를 전체적으로 퍼트리는 역할을 할 수도 있다.
4. hashCode가 반환하는 값의 생성 규칙을 API 사용자에게 자세히 공표하면 안된다.

```java
@Override
public int hashCode() {
	int result = Short.hashCode(areaCode);
	result = 31 * result + Short.hashCode(prefix);
	result = 31 * result + Short.hashCode(lineNum);
	return result;
}

// 한 줄짜리 해시코드
// 성능이 느린 해시코드
@Override
public int hashCode() {
	return Objects.hash(lineNum, prefix, areaCode);
}

// 캐싱을 쓰는 해시코드
// lazy-loading : 지연 초기화
```java
private int hashCode; // 자동으로 0으로 초기화된다.

@Override public int hashCode() {
	if (hashCode != 0){
		return hashCode;
	}
	int result = Short.hashCode(areaCode);
	// 31은 소수 이므로
	result = 31 * result + Short.hashCode(prefix);
	result = 31 * result + Short.hashCode(lineNum);
	return hashCode = result;
}
```

---
## 핵심 정리
* equals를 정의할 때는 hashCode도 반드시 정의하여야 한다.