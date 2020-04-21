package datastructure0421.part02.section02;

//큐 인터페이스 구현하기
//https://cloudstudying.kr/challenges/316

//아래의 큐 명세서와 클래스 다이어그램을 참고하여, Queue 인터페이스를 구현하고, 출력 예와 같은 결과를 얻으시오.

import java.lang.reflect.Method;

public class QueueTest {
  public static void main(String[] args) {
    // 메소드 목록 획득
    Method[] methodList = Queue.class.getMethods();

    // 메소드 정보 출력
    for (Method m : methodList) {
      System.out.printf("%s(", m.getName());
      Class<?>[] paramTypes = m.getParameterTypes();
      for (Class<?> paramType : paramTypes) {
        System.out.printf("%s", paramType.getName());
      }
      System.out.printf(") : %s\n", m.getReturnType().getSimpleName());
    }
  }
}

/* 아래의 Queue 인터페이스를 완성하시오. */
interface Queue {
  public void enqueue(int n);
  /* 1. dequeue() 메소드를 선언할 것. */
  public Integer dequeue();
  
  public Integer front();
  /* 2. rear() 메소드를 선언할 것. */
  public Integer rear();
  
  public boolean isEmpty();
  /* 3. isFull() 메소드를 선언할 것. */
  public boolean isFull();
}

// 출력 예
/*
 * dequeue() : Integer
 * front() : Integer
 * rear() : Integer
 * isFull() : boolean
 * isEmpty() : boolean
 * enqueue(int) : void
*/
