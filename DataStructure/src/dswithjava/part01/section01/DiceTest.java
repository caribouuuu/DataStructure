package dswithjava.part01.section01;

//주사위 통계
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
* 주사위 한 쌍
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
	  /* 주사위를 n번 던질경우 생기는 통계를 출력하시오.  */
	  for(int i=0; i<n; i++){
	    int sum = this.rollDice();
	    counts[sum]++;
	  }

	  for(int k=2; k<counts.length; k++) {
		  //문자열 반복하는 방법 (아무것도 import할필요 없음)
		  String countString = new String(new char[counts[k]]).replace("\0", "#");
		  //format에 맞춰 2자리수로 숫자 출력 + 반복한 문자열 스트링 출력
		  System.out.println(String.format("%2s", k)+" => "+countString +" ("+counts[k]+")");
	  }
	  
	  /* ----- 소영언니 풀이 -----
	  for(int i=0; i<n; i++) {
	      counts[rollDice()-2]++;
	    }
	    String hash = "#";
	    for(int i=0; i<counts.length; i++) {
	      System.out.println((i+2)+" => "+hash.repeat(counts[i]));	//repeat 함수 :: Java 11부터 사용가
	    }
	    */
	}
}
/**
* 주사위 한 개
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