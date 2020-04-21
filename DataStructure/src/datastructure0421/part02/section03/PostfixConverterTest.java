package datastructure0421.part02.section03;


//★ 중위 표현식을 후위 표현식으로 | 스택
//https://cloudstudying.kr/challenges/149

//다음과 같은 중위 표현식이 있다. 중위 표현식은 수학에서 사용하는 표현식이다.
//
////중위 표현식 예
//A * B - C / D
//A * ( B - C ) / D
//
//중위 표현식을 후위 표현식으로 변환하면 아래와 같다. 후위 표현식은 컴퓨터에서 사용하는 표현식이다.
//
//A * B - C / D => A B * C D / -
//A * ( B - C ) / D => A B C - * D /

//스택을 사용하여 중위식을 후위식으로 변환하는 알고리즘을 작성하시오.


/*
1. '('를 만나면 스택에 push한다.

2. ')'를 만나면 스택에서 '('가 나올 때까지 pop하여 출력하고 '('는 pop하여 버린다.

3. 연산자를 만나면 스택에서 그 연산자보다 낮은 우선순위의 연산자를 만날 때까지 팝하여 출력한 뒤에 자신을 push한다.

4. 피연산자는 그냥 출력한다.

5. 모든 입력이 끝나면 스택에 있는 연산자들을 모두 pop하여 출력한다.

출처: https://steadyandslow.tistory.com/110 [더디지만... 꾸준히...]
*/

import java.util.Stack;
/**
 * PostfixConverter
 */
public class PostfixConverterTest {
  public static void main(String[] args) {
    String[] tests = { "A*B-C/D", "A*(B-C)/D" };
    PostfixConverter converter = new PostfixConverter();
    for (String t : tests) {
      System.out.printf("%s -> %s\n", t, converter.toPostfix(t));
    }
  }
}
class PostfixConverter {
  private Stack<Character> stack = new Stack<Character>();
  public String toPostfix(String infix) {
    /* 해당 메소드를 구현하시오. */
	  
	  char[] returnCharSeq = new char[infix.length()];
	  int charIndex = 0;
	  
	  for(int i=0; i<infix.length(); i++) {
		  char tempChar = infix.charAt(i);
		  
		  if( tempChar == '(' ) {
			  stack.push(tempChar);
			  
		  }else if( tempChar == ')' ){
			  while(true) {
				  char popedChar = stack.pop();
				  if(popedChar == '(') {
					  break;
				  }
				  returnCharSeq[charIndex++] = popedChar;
			  }
			  
		  }else if( tempChar == '+' || tempChar == '-' || tempChar == '*' || tempChar == '/' ) {
			  while(!stack.isEmpty()) {
				  if( getOpPrec(stack.peek()) >= getOpPrec(tempChar) ) {
					  returnCharSeq[charIndex++] = stack.pop();
				  }else {
					  //System.out.println("do nothings");
					  break;
				  }
			  }
			  stack.push(tempChar);
			  
		  }else if(tempChar >='A' && tempChar <= 'Z') {
			  returnCharSeq[charIndex++] = tempChar;
			  
		  }
	  }
	  while(!stack.isEmpty()) {
		  returnCharSeq[charIndex++] = stack.pop();
	  }
	  
	  
	  return new String(returnCharSeq).replace(" ", "");
  }
  
  //연산자의 우선순위를 반환하는 메소드
  public int getOpPrec(char op) {
      switch (op) {
      case '*':
      case '/':
          return 5;

      case '+':
      case '-':
          return 3;

      case '(':
          return 1;
      }
      return -1;
  }
}

//출력
//A*B-C/D -> AB*CD/-
//A*(B-C)/D -> ABC-*D/