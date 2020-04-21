package datastructure0421.part02.section03;


//�� ���� ǥ������ ���� ǥ�������� | ����
//https://cloudstudying.kr/challenges/149

//������ ���� ���� ǥ������ �ִ�. ���� ǥ������ ���п��� ����ϴ� ǥ�����̴�.
//
////���� ǥ���� ��
//A * B - C / D
//A * ( B - C ) / D
//
//���� ǥ������ ���� ǥ�������� ��ȯ�ϸ� �Ʒ��� ����. ���� ǥ������ ��ǻ�Ϳ��� ����ϴ� ǥ�����̴�.
//
//A * B - C / D => A B * C D / -
//A * ( B - C ) / D => A B C - * D /

//������ ����Ͽ� �������� ���������� ��ȯ�ϴ� �˰����� �ۼ��Ͻÿ�.


/*
1. '('�� ������ ���ÿ� push�Ѵ�.

2. ')'�� ������ ���ÿ��� '('�� ���� ������ pop�Ͽ� ����ϰ� '('�� pop�Ͽ� ������.

3. �����ڸ� ������ ���ÿ��� �� �����ں��� ���� �켱������ �����ڸ� ���� ������ ���Ͽ� ����� �ڿ� �ڽ��� push�Ѵ�.

4. �ǿ����ڴ� �׳� ����Ѵ�.

5. ��� �Է��� ������ ���ÿ� �ִ� �����ڵ��� ��� pop�Ͽ� ����Ѵ�.

��ó: https://steadyandslow.tistory.com/110 [��������... ������...]
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
    /* �ش� �޼ҵ带 �����Ͻÿ�. */
	  
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
  
  //�������� �켱������ ��ȯ�ϴ� �޼ҵ�
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

//���
//A*B-C/D -> AB*CD/-
//A*(B-C)/D -> ABC-*D/