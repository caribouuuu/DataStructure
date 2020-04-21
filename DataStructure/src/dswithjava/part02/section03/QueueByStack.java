package dswithjava.part02.section03;


//스택으로 큐 만들기
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
    /* 1. 데이터 삽입 메소드를 구현해보세요. */
	  
	  while(!out.isEmpty()) {
		  in.push(out.pop());
	  }
	  in.push(n);
	  
  }

  public Integer dequeue() {
    /* 2. 데이터 삭제 메소드를 구현해보세요. */
	  while(!in.isEmpty()) {
		  out.push(in.pop());
	  }
	  //아래의 코드는 맨 아레 return 한문장으로 변경 가능
	  if(!out.isEmpty()) {
		  return out.pop();
	  }
    return null;
    
    //return out.isEmpty() ? null : out.pop();
  }
}
