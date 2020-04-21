package datastructure0421.part02.section02;

// ť (Queue) :: FIFO(First In First Out) �� Ư¡�� ���� �ڷᱸ��
//https://cloudstudying.kr/lectures/142

//ť�� �Է� �����͵��� ������ ���ϴµ� ����ȭ �Ǿ��ִ�. 
//���� �⺻������ FIFO�� ����������, Ư�� ���¿� ���� �켱������ �����ϱ⵵ �Ѵ�. (= �켱���� ť) 

//�����͸� �߰�(enqueue) �ϴ� ���� ����(rear), ����(dequeue) �ϴ� ���� ����Ʈ(front)�� �Ѵ�.
//�Է� �������� ��¼����� ���� �� ���ȴ�. ��ǥ�� ���δ� ��ǻ�� �ü��(OS)�� �����췯�� �ִ�. 

//5.1 ����
//1) �����͸� �߰�(enqueue)�ϰ� ����(dequeue)�� �� �ִ�.
//2) ���� ���� �߰��� �����Ͱ� ���� ���� �����ȴ�.
//3) front �����͸� Ȯ�� �� �� �ִ�.
//4) rear �����͸� Ȯ�� �� �� �ִ�.
//5) ť�� ����ִ� ��� null���� ��ȯ�Ѵ�.



//ť: ����(enqueue) ����
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
  private int front; // ������ ����� �ε���
  private int rear; // ������ �߰� ����� �ε���
  private int size; // ��� ����

  public MyQueue01() {
    this.elements = new int[5];
    this.capacity = 5;
    this.front = 0;
    this.rear = 0;
    this.size = 0;
  }

  public void enqueue(int data) {
    /* �ش� �޼ҵ带 �����Ͻÿ�. */ 
	  if(isEmpty()) {	//size==0
		  elements[rear] = data;
	  }else {
		  elements[++rear] = data;
	  }
	  size++;
	  
	  //�� Ǯ��
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
        sbuf.append(String.format("%2s ", "��"));
    }
    sbuf.append("\n---------------\n");
    sbuf.append("[0][1][2][3][4]\n\n");
    sbuf.append(String.format("front: [%d], rear: [%d], isEmpty?: %s", front, rear, isEmpty()));
    return sbuf.toString();
  }
}
