package datastructure0421.part02.section03;


//스택 정렬하기
//https://cloudstudying.kr/challenges/332

//비정렬 스택을 임시 스택을 사용하여 정렬하시오. 
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

  /* 정렬된 스택을 반환 */
  private static Stack<Integer> sort(Stack<Integer> origin) {
    Stack<Integer> temp = new Stack<Integer>();
    /* 해당 알고리즘을 구현하시오. */
    
	while(!origin.isEmpty()) {
		int originTop = origin.pop();
		
		while(!temp.isEmpty()) {
			///////////////////////////////
//			if( originTop > temp.peek() ) {
//				origin.push(temp.pop());
// 			}
 			///////////////////////////////
			//내가 썼던 위의 코드로 실행하면 Killed됨
			
			///////////////////////////////
			if (originTop <= temp.peek()) {
		        break;
		    }
		    origin.push(temp.pop());
		    ///////////////////////////=> 정답코드 
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