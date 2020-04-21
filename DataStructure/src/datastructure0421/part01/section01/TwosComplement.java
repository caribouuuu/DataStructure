package datastructure0421.part01.section01;

//2�� ������ ����Ʈ
//https://cloudstudying.kr/challenges/151

//2�� ���� ǥ����� ���� ������ �������� ǥ���ϱ� ���� ����̴�.
//������ ���� x�� x�� 2�� ������ ���ϸ� �׻� 0�� ���´�.


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
	  return String.format("%32s", compBinaryStr).replace(' ', '0').substring(24);	//32�ڸ����� �������� ��ȯ �� �� �� 8�ڸ��� �ڸ���
	}
}