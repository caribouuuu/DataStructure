package datastructure0421.part01.section01;

//2의 보수와 바이트
//https://cloudstudying.kr/challenges/151

//2의 보수 표기법은 음의 정수를 이진수로 표현하기 위한 방법이다.
//임의의 정수 x와 x의 2의 보수를 더하면 항상 0이 나온다.


public class TwosComplement {
	public static void main(String[] args) {
	  String[] tests = { "00101101", "11111101" };
	  for (String t : tests) {
	    System.out.printf("   %s\n", t);
	    System.out.printf("+) %s\n", getComplementBinaryStr(t));
	    System.out.println("-----------");
	    System.out.println("   00000000");
	    if(!t.equals(tests[1])){
	      System.out.println();
	    }
	  }
	}
	
	
	private static String getComplementBinaryStr(String binaryStr) {
	  byte decimal = (byte) (int) Integer.parseInt(binaryStr, 2);
	  byte complement = (byte) -decimal;
	  String compBinaryStr = Integer.toBinaryString(complement & 0xFF);	//
	  return String.format("%32s", compBinaryStr).replace(' ', '0').substring(24);	//32자리수의 이진수로 변환 후 맨 뒤 8자리만 자르기
	}
}