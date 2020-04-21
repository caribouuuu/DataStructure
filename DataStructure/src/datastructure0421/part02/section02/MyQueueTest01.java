package datastructure0421.part02.section02;

// 큐 (Queue) :: FIFO(First In First Out) 의 특징을 갖는 자료구조
//https://cloudstudying.kr/lectures/142

//큐는 입력 데이터들의 순서를 정하는데 최적화 되어있다. 
//가장 기본적으로 FIFO를 지원하지만, 특정 상태에 따라 우선순위를 결정하기도 한다. (= 우선순위 큐) 

//데이터를 추가(enqueue) 하는 곳을 리어(rear), 해제(dequeue) 하는 곳은 프런트(front)라 한다.
//입력 데이터의 출력순서를 정할 때 사용된다. 대표적 예로는 컴퓨터 운영체제(OS)의 스케쥴러가 있다. 

//5.1 명세서
//1) 데이터를 추가(enqueue)하고 해제(dequeue)할 수 있다.
//2) 가장 먼저 추가한 데이터가 가장 먼저 해제된다.
//3) front 데이터를 확인 할 수 있다.
//4) rear 데이터를 확인 할 수 있다.
//5) 큐가 비어있는 경우 null값을 반환한다.



//큐: 삽입(enqueue) 구현
//https://cloudstudying.kr/challenges/267

public class MyQueueTest01 {
  public static void main(String[] args) {
    MyQueue01 queue = new MyQueue01();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    System.out.println(queue);
  }
}

class MyQueue01 {
  private int[] elements;
  private int capacity;
  private int front; // 꺼내올 요소의 인덱스
  private int rear; // 마지막 추가 요소의 인덱스
  private int size; // 요소 개수

  public MyQueue01() {
    this.elements = new int[5];
    this.capacity = 5;
    this.front = 0;
    this.rear = 0;
    this.size = 0;
  }

  public void enqueue(int data) {
    /* 해당 메소드를 구현하시오. */ 
	  if(isEmpty()) {	//size==0
		  elements[rear] = data;
	  }else {
		  elements[++rear] = data;
	  }
	  size++;
	  
	  //내 풀이
	  //elements[size++] = data;
	  //rear=size-1;
  }

  public int front() {
    return elements[front];
  }

  public int rear() {
    return elements[rear];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public String toString() {
    StringBuffer sbuf = new StringBuffer("---------------\n");
    for (int i = 0; i < capacity; i++) {
      if (i >= front && i <= rear && !isEmpty())
        sbuf.append(String.format("%2d ", elements[i]));
      else
        sbuf.append(String.format("%2s ", "ø"));
    }
    sbuf.append("\n---------------\n");
    sbuf.append("[0][1][2][3][4]\n\n");
    sbuf.append(String.format("front: [%d], rear: [%d], isEmpty?: %s", front, rear, isEmpty()));
    return sbuf.toString();
  }
}
