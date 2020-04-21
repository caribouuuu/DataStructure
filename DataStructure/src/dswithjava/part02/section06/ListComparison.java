package dswithjava.part02.section06;

//�迭 �� ���� ����Ʈ ���ٽð� ��
//https://cloudstudying.kr/challenges/301

//�䱸������ �����ϴ� �迭����Ʈ�� ���Ḯ��Ʈ�� �����ϰ�, ���� ��ҿ� ���� ���ٽð��� ���Ͽ� ��� ���� ���� ����� ����ÿ�.
//�� ����Ʈ�� Integer�� �����Ѵ�.
//�� ����Ʈ�� �ʱ� ������ ������ 10�����̴�.
//���� �ð� ������ ������(ns)�� �Ѵ�.

// ��� ��
//	���� ���� �ð�: 23244ns (ArrayList)
//	���� ���� �ð�: 4033463ns (LinkedList)



//�迭 �� ���� ����Ʈ �����ð� ��
//https://cloudstudying.kr/challenges/307

// ��� ��
//	ù ��� ���� �ð�: 933189ns (ArrayList)
//	ù ��� ���� �ð�: 25739ns (LinkedList)


//�迭 �� ���� ����Ʈ �������� ��
//https://cloudstudying.kr/challenges/308

//	���� ��� ���� �ð�: 273464ns (ArrayList)
//	���� ��� ���� �ð�: 4036401ns (ArrayList)


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class ListComparison {
	
  public static void main(String[] args) {
    // create variables
    ArrayList<Integer> a = new ArrayList<Integer>();
    LinkedList<Integer> b = new LinkedList<Integer>();
    
    // init
    Random rand = new Random();
    for (int i = 1; i <= 1000000; i++) {
      a.add(i);
      b.add(i);
    }
    
    // compare random access
    long start, end;
    start = System.nanoTime();
    a.get(rand.nextInt(a.size()));
    end = System.nanoTime();
    System.out.printf("���� ���� �ð�: %dns (ArrayList)\n", end - start);
    
    start = System.nanoTime();
    b.get(rand.nextInt(b.size()));
    end = System.nanoTime();
    System.out.printf("���� ���� �ð�: %dns (LinkedList)\n", end - start);
    
    
    ////////////////
    start = System.nanoTime();
    a.remove(0);
    end = System.nanoTime();
    System.out.printf("ù ��� ���� �ð�: %dns (ArrayList)\n", end - start);
    
    start = System.nanoTime();
    b.remove(0);
    end = System.nanoTime();
    System.out.printf("ù ��� ���� �ð�: %dns (LinkedList)\n", end - start);
    
    
    ///////////////
    start = System.nanoTime();
    a.remove(rand.nextInt(a.size()));
    end = System.nanoTime();
    System.out.printf("���� ��� ���� �ð�: %dns (ArrayList)\n", end - start);
    
    start = System.nanoTime();
    b.remove(rand.nextInt(b.size()));
    end = System.nanoTime();
    System.out.printf("���� ��� ���� �ð�: %dns (LinkedList)\n", end - start);
  }
}