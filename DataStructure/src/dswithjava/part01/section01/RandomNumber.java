package dswithjava.part01.section01;

//���� �ѹ� ����
//1~4 ������ ���� �ѹ� 10���� �����ϰ�, �� ��ȣ�� ������ ����Ͻÿ�.
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
	  System.out.printf("���� �ѹ�: %s\n", Arrays.toString(randNums));
	  for (int i = 0; i < counters.length; i++) {
	    System.out.printf("%d�� ����: %d\n", i + 1, counters[i]);
	  }
	}
	private static int[] generate() {
	  int[] arr = new int[10];
	  /* ���� �ѹ��� �����Ͻÿ�. */
	  
	  for (int i=0; i<arr.length; i++) {
		arr[i] = 1 + new Random().nextInt(4);
	  }
	  
	  return arr;
	}
	private static int[] count(int[] arr) {
	  int[] cnts = new int[4];
	  /* ���� ������ ���ÿ�. */
	  
	  for (int i=0; i<arr.length; i++) {
		int index = arr[i];
		cnts[index-1] = cnts[index-1] + 1;
	  }
	  
	  return cnts;
	}
}