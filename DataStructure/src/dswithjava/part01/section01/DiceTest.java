package dswithjava.part01.section01;

//�ֻ��� ���
//https://cloudstudying.kr/challenges/168

import java.util.Random;

/**
* DiceTest
*/
public class DiceTest {
	public static void main(String[] args) {
	  // input
	  //int n = Integer.parseInt(args[0]);
	int n = 20;
	  // create instance
	  Dice dice = new Dice();
	  // print
	  dice.printStatistics(n);
	}
}
/**
* �ֻ��� �� ��
*/
class Dice {
	private int[] counts;
	
	public Dice() {
	  this.counts = new int[13]; // for 0 ~ 12
	}
	public int rollDice() {
	  Die a = new Die(6);
	  Die b = new Die(6);
	  return a.rollADie() + b.rollADie();
	}
	public void printStatistics(int n) {
	  /* �ֻ����� n�� ������� ����� ��踦 ����Ͻÿ�.  */
	  for(int i=0; i<n; i++){
	    int sum = this.rollDice();
	    counts[sum]++;
	  }

	  for(int k=2; k<counts.length; k++) {
		  //���ڿ� �ݺ��ϴ� ��� (�ƹ��͵� import���ʿ� ����)
		  String countString = new String(new char[counts[k]]).replace("\0", "#");
		  //format�� ���� 2�ڸ����� ���� ��� + �ݺ��� ���ڿ� ��Ʈ�� ���
		  System.out.println(String.format("%2s", k)+" => "+countString +" ("+counts[k]+")");
	  }
	  
	  /* ----- �ҿ���� Ǯ�� -----
	  for(int i=0; i<n; i++) {
	      counts[rollDice()-2]++;
	    }
	    String hash = "#";
	    for(int i=0; i<counts.length; i++) {
	      System.out.println((i+2)+" => "+hash.repeat(counts[i]));	//repeat �Լ� :: Java 11���� ��밡
	    }
	    */
	}
}
/**
* �ֻ��� �� ��
*/
class Die {
	private int max;
	
	public Die(int max) {
	  this.max = max;
	}
	public int rollADie() {
	  return 1 + new Random().nextInt(max); // 1 ~ max
	}
}