package dswithjava.part02.section02;

//원형 큐(circular queue) 구현
//https://cloudstudying.kr/challenges/270


public class MyQueueTest {
  public static void main(String[] args) {
    MyQueue queue = new MyQueue();
    int data = 1;
    while (!queue.isFull()) {
      queue.enqueue(data++);
    }
    queue.dequeue();
    queue.dequeue();
    queue.enqueue(data++);
    System.out.println(queue);
  }
}
class MyQueue {
  private int[] elements;
  private int capacity;
  private int front; // 꺼내올 요소의 인덱스
  private int rear; // 마지막 추가 요소의 인덱스
  private int size; // 요소 개수
  
  public MyQueue() {
    this.elements = new int[5];
    this.capacity = 5;
    this.front = 0;
    this.rear = 0;
    this.size = 0;
  }
  public int dequeue() {
    /* 해당 메소드를 구현하시오. */
	int removed = elements[front];
	size--;
	
	if(!isEmpty()) {
		front = (front+1) % capacity;
	}
	return removed;
	
  }
  public void enqueue(int data) {
    /* 해당 메소드를 구현하시오. */
	  
//	  if(!isFull()) {
//		  if( rear+1 >= capacity ) {
//			  rear = -1;
//		  }
//		  elements[++rear] = data;
//	  }
	  
	if (isEmpty()) { // size == 0
		elements[rear] = data;
	}else {
		rear = (rear+1) % capacity;
		elements[rear] = data;
	}
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
      if (!isEmpty() && (front <= rear && i >= front && i <= rear) || (front > rear && (i >= front || i <= rear)))
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