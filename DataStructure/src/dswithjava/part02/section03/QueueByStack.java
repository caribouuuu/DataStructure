package dswithjava.part02.section03;


//�������� ť �����
//https://cloudstudying.kr/challenges/333

import java.util.Stack;

public class QueueByStack {
  public static void main(String[] args) {
    MyQueue q = new MyQueue();
    System.out.printf("%d ", q.dequeue());
    q.enqueue(11);
    System.out.printf("%d ", q.dequeue());
    q.enqueue(22);
    q.enqueue(33);
    System.out.printf("%d ", q.dequeue());
    q.enqueue(44);
    q.enqueue(55);
    System.out.printf("%d ", q.dequeue());
    System.out.printf("%d ", q.dequeue());
    System.out.printf("%d ", q.dequeue());
  }
}

class MyQueue {
  private Stack<Integer> in = new Stack<Integer>();
  private Stack<Integer> out = new Stack<Integer>();

  public void enqueue(int n) {
    /* 1. ������ ���� �޼ҵ带 �����غ�����. */
	  
	  while(!out.isEmpty()) {
		  in.push(out.pop());
	  }
	  in.push(n);
	  
  }

  public Integer dequeue() {
    /* 2. ������ ���� �޼ҵ带 �����غ�����. */
	  while(!in.isEmpty()) {
		  out.push(in.pop());
	  }
	  //�Ʒ��� �ڵ�� �� �Ʒ� return �ѹ������� ���� ����
	  if(!out.isEmpty()) {
		  return out.pop();
	  }
    return null;
    
    //return out.isEmpty() ? null : out.pop();
  }
}
