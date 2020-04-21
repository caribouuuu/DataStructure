package datastructure0421.part01.section02;

//����ð� ���� | �ð� ���⵵
//https://cloudstudying.kr/challenges/157

//�־��� 2���� �˰����� ���ϰ�, ���� ����ð� ���̰� ���� ������ �ּ����� �����Ͻÿ�.

//O(1) < O(N) < O(logN) < O(NlogN) < O(N^2) < O(N^3) < O(2^N)

public class Sum {
	  public static void main(String[] args) {
	    int[] sampleCounts = { 1, 10, 100, 1000, 10000, 100000, 1 };	
	    //ó�� ������ 1�� elapse�� 10���� ���� �ɸ��� ����..?
	    //=> ó�� �Լ��� ȣ���ϴ°Ŷ� �ð��� �ɷ���!
	    //=> 1�� �� �ڿ� �ٽ��ѹ� �����ϸ� ó�� ������ 1���� �ξ� �ð��� ���ɸ��°��� �� �� ����
	    
	    long start = 0;
	    long end = 0;
	    int sum = 0;
	    for (int n : sampleCounts) {
	      System.out.println("=================================");
	      // sumA(n)
	      start = System.nanoTime();
	      sum = sumA(n);
	      end = System.nanoTime();
	      System.out.printf("sumA(%d): %d ns\n", sum, end - start);
	      // sumB(n)
	      start = System.nanoTime();
	      sum = sumB(n);
	      end = System.nanoTime();
	      System.out.printf("sumB(%d): %d ns\n", sum, end - start);
	    }
	  }
	  private static int sumA(int n) {
	    return n * (n + 1) / 2;		//O(1)
	  }
	  private static int sumB(int n) {
	    int sum = 0;
	    for (int i = 1; i <= n; i++) {	//O(n)
	      sum += i;						//O(1)
	    }
	    return sum;
	  }
	}