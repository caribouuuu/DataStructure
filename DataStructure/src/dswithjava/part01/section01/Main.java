package dswithjava.part01.section01;

//�������� ��������
//https://cloudstudying.kr/challenges/150

//������(binary number)�� ���� �������� �ڷᱸ���̴�. ��ǻ�ʹ� ������ 0�� 1���� �˰��ֱ� �����̴�.
//�������� ����� �б⿡ ����� �� ����� ������ 16����(hexadecimal)�� ��ȯ�Ͽ� ����Ѵ�.
//����(binary) ���ڿ��� ������(decimal), ��������(hex)�� ��ȯ�Ͻÿ�.

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
    /* �޼ҵ带 �����Ͻÿ� */
    System.out.println("binary: "+binaryStr);
    System.out.println("decimal: "+Integer.parseInt(binaryStr, 2));	 //�������ڿ��� �޾� �ؼ��Ͽ� ������ ���
    System.out.println("hex: "+Integer.toString(Integer.parseInt(binaryStr, 2), 16));	//�Է� ���� n�� radix(16����)���� ���� ���� ���ڿ��� ��ȯ �մϴ�.
  }
}