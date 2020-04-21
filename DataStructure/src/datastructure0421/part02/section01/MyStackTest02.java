package datastructure0421.part02.section01;

public class MyStackTest02 {
  public static void main(String[] args) {
    MyStack02 stack = new MyStack02();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    System.out.println(stack);
    
    int removed = stack.pop();
    
    System.out.printf("pop: %d\n", removed);
    System.out.println(stack);
    
    int topData = stack.peek();
    
    System.out.printf("peek: %d\n", topData);
    System.out.println(stack);
  }
}

class MyStack02 {
  private int[] array;
  private int capacity;
  private int top;
  public MyStack02() {
    this.array = new int[5];
    this.capacity = 5;
    this.top = -1;
  }
  public int pop() {
    /* 해당 메소드를 구현하시오. */
	  int removedData = -1;
	  if(top != -1) {	//stack이 비어있지 않은 경우
		  removedData = array[top];
		  array[top] = 0;
		  top--;
	  }
	  
    return removedData;
    
    //return array[top--];
  }
  public int peek() {
    /* 해당 메소드를 구현하시오. */
	  
	  if(top != -1) {	//stack이 비어있지 않은 경우
		  return array[top];
	  }
	  
    return -1;
    
    //return array[top];
  }
  public void push(int data) {
    array[++top] = data;
  }
  @Override
  public String toString() {
    StringBuffer sbuf = new StringBuffer("\n");
    for (int i = capacity - 1; i >= 0; i--) {
      Integer data = (i <= top) ? array[i] : null;
      sbuf.append(String.format("| %4s |%s\n", data, (i == top) ? " <- top " : ""));
    }
    return sbuf.append("--------\n").toString();
  }
}