package datastructure0421.part02.section02;


//큐: 삭제(dequeue) 구현
//https://cloudstudying.kr/challenges/269

public class MyQueueTest02 {
  public static void main(String[] args) {
    MyQueue02 queue = new MyQueue02();
    int data = 1;
    while (!queue.isFull()) {
      queue.enqueue(data++);
    }
    System.out.println(queue);
    while (!queue.isEmpty()) {
      System.out.println(queue.dequeue());
    }
    System.out.println(queue);
  }
}

class MyQueue02 {
  private int[] elements;
  private int capacity;
  private int front; // 꺼내올 요소의 인덱스
  private int rear; // 마지막 추가 요소의 인덱스
  private int size; // 요소 개수
  
  public MyQueue02() {
    this.elements = new int[5];
    this.capacity = 5;
    this.front = 0;
    this.rear = 0;
    this.size = 0;
  }
  
  public int dequeue() {
    /* 해당 메소드를 구현하시오. */
	size--;
	return elements[front++];

  }
  public void enqueue(int data) {
    if (isEmpty()) // size == 0
      elements[rear] = data;
    else
      elements[++rear] = data;
    size++;
  }
  public boolean isEmpty() {
    return size == 0;
  }
  public boolean isFull() {
    return size == capacity;
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
    sbuf.append(String.format("front: [%d], rear: [%d], isEmpty?: %s, isFull?: %s", front, rear, isEmpty(), isFull()));
    return sbuf.toString();
  }
}