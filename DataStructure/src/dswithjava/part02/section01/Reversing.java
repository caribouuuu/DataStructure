package dswithjava.part02.section01;

import java.util.Stack;

public class Reversing {
  public static void main(String[] args) {
    Stack<Character> stack = new Stack<Character>();
    String str = "?���Ǵ¸� ���ý�";
    /* �˰����� �����Ͻÿ�. */
    
    for (int i=0; i<str.length(); i++) {
    	stack.add(str.charAt(i));
	}
    
    System.out.println(stack.size());
    
    for(int i=stack.size(); i>0; i--) {
    	System.out.print(stack.pop());
    }
  }
}
