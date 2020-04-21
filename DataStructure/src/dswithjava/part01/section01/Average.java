package dswithjava.part01.section01;

//평균 구하기
//https://cloudstudying.kr/challenges/211

import java.util.Arrays;
public class Average {
  public static void main(String[] args) {
    // input
    int n = Integer.parseInt(args[0]);
    int[] numbers = getInputNumbers(Arrays.copyOfRange(args, 1, args.length));
    // average
    double average = getAverage(numbers);
    // print
    System.out.printf("평균: %.2f\n", average);
  }
  private static int[] getInputNumbers(String[] args) {
    int[] arr = new int[args.length];
    for (int i = 0; i < args.length; i++) {
      arr[i] = Integer.parseInt(args[i]);
    }
    return arr;
  }
  private static double getAverage(int[] arr) {
    /* 평균을 구하시오. */
	  
	  int sum = 0;
	  for (int num : arr) {
		  sum += num;
	  }
	  
    return (double)sum/arr.length;
    
    /* ---- 소영언니 풀이 -----
    double sum = 0;
    for(int val : arr) {
      sum += val;
    }
    return sum/arr.length;
     * */
  }
}