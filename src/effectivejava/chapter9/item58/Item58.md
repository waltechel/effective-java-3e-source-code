---
# 아이템 58. 전통적인 for 문보다는 for-each문을 사용하라.

---
## 전통적인 C언어 스타일의 for 문과 향상된 for 문

```java
// bad
for(Iterator<Element> it = list.iterator(); it.hasNext();){
	Element e = it.next();
}
// bad2
for(int i = 0 ; i < list.size(); i++){
	Element e = list.get(i);
}
// good
for(Element e : list){

}
```

## 핵심정리
- 전통적인 C 스타일의 for 문과 비교했을 때 for-each문은 명료하고, 유연하고, 버그를 예방해준다.
- 성능 저하도 없으니, 가능한 모든 곳에서 C 스타일의 for 보다는 for-each를 쓰자.

