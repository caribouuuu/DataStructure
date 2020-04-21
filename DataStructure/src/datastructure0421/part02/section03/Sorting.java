package datastructure0421.part02.section03;


//���� �����ϱ�
//https://cloudstudying.kr/challenges/332

//������ ������ �ӽ� ������ ����Ͽ� �����Ͻÿ�. 
//Sort stack using a temprory stack.

import java.util.Stack;

public class Sorting {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();
    int[] numbers = { 4, 2, 0, 5, 6, 1, 3 };
    for (int n : numbers) {
      stack.push(n);
    }
    stack = sort(stack);
    prettyPrint(stack);
  }

  /* ���ĵ� ������ ��ȯ */
  private static Stack<Integer> sort(Stack<Integer> origin) {
    Stack<Integer> temp = new Stack<Integer>();
    /* �ش� �˰����� �����Ͻÿ�. */
    
	while(!origin.isEmpty()) {
		int originTop = origin.pop();
		
		while(!temp.isEmpty()) {
			///////////////////////////////
//			if( originTop > temp.peek() ) {
//				origin.push(temp.pop());
// 			}
 			///////////////////////////////
			//���� ��� ���� �ڵ�� �����ϸ� Killed��
			
			///////////////////////////////
			if (originTop <= temp.peek()) {
		        break;
		    }
		    origin.push(temp.pop());
		    ///////////////////////////=> �����ڵ� 
		}
		
		temp.push(originTop);
	}
    
    return temp;
  }

  private static void prettyPrint(Stack<Integer> stack) {
    System.out.println("|   |");
    while (!stack.isEmpty()) {
      System.out.printf("| %d |\n", stack.pop());
    }
    System.out.println("-----");
  }
}