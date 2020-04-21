package dswithjava.part01.section01;

//랜덤 넘버 갯수
//1~4 범위의 랜덤 넘버 10개를 생성하고, 각 번호당 개수를 출력하시오.
//https://cloudstudying.kr/challenges/210

import java.util.Arrays;
import java.util.Random;

public class RandomNumber {
	public static void main(String[] args) {
	  // generate
	  int[] randNums = generate();
	  // count
	  int[] counters = count(randNums);
	  // print
	  System.out.printf("랜덤 넘버: %s\n", Arrays.toString(randNums));
	  for (int i = 0; i < counters.length; i++) {
	    System.out.printf("%d의 개수: %d\n", i + 1, counters[i]);
	  }
	}
	private static int[] generate() {
	  int[] arr = new int[10];
	  /* 랜덤 넘버를 생성하시오. */
	  
	  for (int i=0; i<arr.length; i++) {
		arr[i] = 1 + new Random().nextInt(4);
	  }
	  
	  return arr;
	}
	private static int[] count(int[] arr) {
	  int[] cnts = new int[4];
	  /* 숫자 개수를 세시오. */
	  
	  for (int i=0; i<arr.length; i++) {
		int index = arr[i];
		cnts[index-1] = cnts[index-1] + 1;
	  }
	  
	  return cnts;
	}
}