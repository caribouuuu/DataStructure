package dswithjava.part02.section03;

//�� ��ȣ �� �˻� | ����
//https://cloudstudying.kr/challenges/148

//��ȣ�� ���� ������ �� ������ �Ѵ�. ������ ����Ͽ� ��ȣ�� ���� �ùٸ��� �˻��Ͻÿ�.


import java.util.Stack;
/**
 * Parenthesis
 */
public class Parenthesis {
  public static void main(String[] args) {
    String[] tests = { "", "()", "((())", "(()(()(())))", "()())()" };
    for (String t : tests) {
      System.out.printf("\"%s\" -> %s\n", t, isBalanced(t));
    }
  }
  private static boolean isBalanced(String str) {
    Stack<Character> stack = new Stack<Character>();
    /* �޼ҵ带 �����Ͻÿ�. */
    
    for(int i=0; i<str.length(); i++) {
    	if(str.charAt(i) == '(') {
    		stack.push(str.charAt(i));
    	}else if(str.charAt(i) == ')'){
    		if(!stack.isEmpty()) {
    			stack.pop();
    		}else {
    			return false;
    		}
    	}
    }
    if(stack.isEmpty()) {
    	return true;
    }
    
    return false;
  }
}

//��� ��
//"" -> true
//"()" -> true
//"((())" - > false
//"(()(()(())))" -> true
//"()())()" -> false
