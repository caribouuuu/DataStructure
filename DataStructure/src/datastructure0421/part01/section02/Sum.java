package datastructure0421.part01.section02;

//수행시간 측정 | 시간 복잡도
//https://cloudstudying.kr/challenges/157

//주어진 2가지 알고리즘을 비교하고, 실제 수행시간 차이가 나는 이유를 주석으로 설명하시오.

//O(1) < O(N) < O(logN) < O(NlogN) < O(N^2) < O(N^3) < O(2^N)

public class Sum {
	  public static void main(String[] args) {
	    int[] sampleCounts = { 1, 10, 100, 1000, 10000, 100000, 1 };	
	    //처음 수행한 1의 elapse가 10보다 오래 걸리는 이유..?
	    //=> 처음 함수를 호출하는거라 시간이 걸려서!
	    //=> 1을 맨 뒤에 다시한번 실행하면 처음 실행한 1보다 훨씬 시간이 덜걸리는것을 알 수 있음
	    
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