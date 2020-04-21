package dswithjava.part02.section04;


//https://cloudstudying.kr/lectures/138

// �迭 ����Ʈ(array-list) :: �迭�� ����� ����Ʈ
// ����Ʈ�� ������ ���� �ڷᱸ���μ�, �����Ͱ� ������ ����. 

// ���� 
// �迭����Ʈ�� �б� �ӵ��� O(1)�� ������. ��? ������ ������ �޸� ������ �����ϱ� ����.

// ����
// 1) ������ ����(�Ǵ� ����) ��, �ӵ��� O(n)���� ������. ��? ���� �׸��� ����Ʈ �ؾ��ϱ� ����. 
// 2) �迭�� ũ�Ⱑ ū ���, �޸� �Ҵ��� ����� �� �ִ�.
// 3) ũ�Ⱑ �����Ǿ� �ִ�. �迭�� �� ���� ũ�⸦ ���Ӱ� �ø��� ��������� �Ѵ�.

//	�ܼ� �б�(read) �� ����(write) �۾��� ���� �����Ϳ� ����. 
//	����(insert) �� ����(remove) ������ ���� ���, ���Ḯ��Ʈ(linked-list)�� ��õ�Ѵ�.


//ArrayList ����ϱ�
//https://cloudstudying.kr/challenges/227

//�־��� �����ڵ带 �����ϰ� ��� ��� �м��� �ּ����� �ۼ��Ͻÿ�.

import java.util.ArrayList;
public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    System.out.printf("list = %s\n", list.toString());
    list.add(4);
    list.add(8);
    list.add(12);
    System.out.printf("list = %s\n", list.toString());
    list.add(1, 10);
    list.add(1, 100);
    System.out.printf("list = %s\n", list.toString());
    list.remove(2);
    list.remove(3);
    System.out.printf("list = %s\n", list.toString());
    System.out.printf("size: %d\n", list.size());
  }
}
