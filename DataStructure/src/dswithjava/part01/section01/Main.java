package dswithjava.part01.section01;

//이진수와 십육진수
//https://cloudstudying.kr/challenges/150

//이진수(binary number)는 가장 기초적인 자료구조이다. 컴퓨터는 실제로 0과 1만을 알고있기 때문이다.
//이진수는 사람이 읽기에 상당히 긴 관계로 때때로 16진수(hexadecimal)로 변환하여 출력한다.
//이진(binary) 문자열을 십진수(decimal), 십육진수(hex)로 변환하시오.

public class Main {
  public static void main(String[] args) {
    String[] tests = { "1111010000010010", "1011101011100010" };
    for (String t : tests) {
      new Binary(t).printInfo();
      System.out.println();
    }
  }
}

class Binary {
  private String binaryStr;
  public Binary(String binaryStr) {
    this.binaryStr = binaryStr;
  }
  public void printInfo() {
    /* 메소드를 구현하시오 */
    System.out.println("binary: "+binaryStr);
    System.out.println("decimal: "+Integer.parseInt(binaryStr, 2));	 //이진문자열을 받아 해석하여 정수로 출력
    System.out.println("hex: "+Integer.toString(Integer.parseInt(binaryStr, 2), 16));	//입력 정수 n을 radix(16진수)값에 따른 진수 문자열로 반환 합니다.
  }
}