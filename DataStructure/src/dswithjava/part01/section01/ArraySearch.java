package dswithjava.part01.section01;

//배열 숫자 검색
//https://cloudstudying.kr/challenges/209

public class ArraySearch {
	// CONSTANT
	public static final int SIZE = 10;
	public static void main(String[] args) {
	  // input
	  int[] numbers = getInputNumbers(args);
	  int x = Integer.parseInt(args[10]);
	  // search
	  int index = search(numbers, x);
	  // print
	  System.out.println(index);
	}
	
	private static int[] getInputNumbers(String[] args) {
	  int[] arr = new int[SIZE];
	  for (int i = 0; i < SIZE; i++) {
	    arr[i] = Integer.parseInt(args[i]);
	  }
	  return arr;
	}
	
	private static int search(int[] arr, int n) {
	  /* 해당 메소드를 구현하시오. */
		
		for (int i=0; i<arr.length; i++) {
			if(arr[i] == n) {
				return i;
			}
		}
		
		
	  return -1;
	}
}