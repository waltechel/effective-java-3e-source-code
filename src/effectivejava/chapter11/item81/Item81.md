---
# 아이템 81. wait 와 notify 보다는 동시성 유틸리티를 애용하라.

---
## java.util.concurrent의 고수준 유틸리티 세 가지
1. 실행자 프레임워크(Executor Framework)
2. 동시성 컬렉션(concurrent collection)
3. 동기화 장치(synchronizer)

---
## 동시성 컬렉션
- 동시성 컬렉션
	- 동시성 : 한 번에 여러 작업을 수행할 수 있도록 하는 것
		- 동시성 컬렉션에서 동시성을 무력화하는 것은 불가능하다.
	- 컬렉션 인터페이스 중 일부는 작업이 성공적으로 완료될 때까지 기다리도록 확장되었다.
		- 예 : BlockingQueue.take()는 큐의 첫 원소를 꺼내며, 큐의 값이 존재하지 않는다면 원소가 추가될 때까지 기다린다.

---
## 동기화 장치
- 스레드가 다른 스레드를 기다릴 수 있게 하는 장치
- CountDownLatch, Semaphore
- CountDownLatch
	- Count 값을 받으며 몇 번 호출해야 넘겨줄지를 결정한다.
	- concurrency

---
## 구식으로 소스를 짤 수도 있다.
```java
synchronized(obj){
	while(condition is not true){
		// wait 메서드는 반복문 밖에서는 절대로 짜지 않도록 한다.
		// 조건을 만족하지 못했을 때 대기하는 것은 좋은 스타일의 코드이다.
		// 조건을 만족했다면 wait()를 타지 않도록 한다. notify() 가 호출되지 않는다면 wait()가 해제되지 않을 수 있다.
		// 일반적으로 notify() 보단 notifyAll()이 좋다
		obj.wait();
	}

}
```

---
## 핵심정리
- 요즘은 notify, notifyAll을 사용할 이유가 전혀 없다.