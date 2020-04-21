package dswithjava.part02.section03;

//★ 괄호 쌍 검사 | 스택
//https://cloudstudying.kr/challenges/148

//괄호는 열고 닫힘을 한 쌍으로 한다. 스택을 사용하여 괄호의 쌍이 올바른지 검사하시오.


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
    /* 메소드를 구현하시오. */
    
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

//출력 예
//"" -> true
//"()" -> true
//"((())" - > false
//"(()(()(())))" -> true
//"()())()" -> false
