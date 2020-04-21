package dswithjava.part01.section02;

//02 알고리즘이란?
//https://cloudstudying.kr/lectures/134


//시간 복잡도 분석
//https://cloudstudying.kr/challenges/152

public class Analysis {
	  public static void main(String[] args) {
	    printSquare(10);
	  }
	  /* (1) Big-O 표기법으로 시간 복잡도를 분석하시오. */
	  private static int sum(int[] arr, int n) {
	    int sum = 0;
	    for (int i = 0; i < n; i++) {	//O(n)
	      sum += arr[i];	//O(1)
	    }
	    return sum;
	  }
	  /* (2) Big-O 표기법으로 시간 복잡도를 분석하시오. */
	  private static void swap(int[] arr, int a, int b) {
	    int temp = arr[a];	//O(1)
	    arr[a] = arr[b];	//O(1)
	    arr[b] = temp;		//O(1)
	  }
	  /* (3) Big-O 표기법으로 시간 복잡도를 분석하시오. */
	  private static void printSquare(int n) {
	    for (int i = 0; i < n; i++) {		//O(n)
	      for (int j = 0; j < n; j++) {		//O(n)
	        System.out.print(" * ");		//O(1)
	      }
	      System.out.println();
	    }
	  }
	}