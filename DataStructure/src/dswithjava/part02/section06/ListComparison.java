package dswithjava.part02.section06;

//배열 및 연결 리스트 접근시간 비교
//https://cloudstudying.kr/challenges/301

//요구사항을 만족하는 배열리스트와 연결리스트를 생성하고, 랜덤 요소에 대한 접근시간을 비교하여 출력 예와 같은 결과를 만드시오.
//각 리스트는 Integer를 저장한다.
//각 리스트의 초기 데이터 개수는 10만개이다.
//측정 시각 단위는 나노초(ns)로 한다.

// 출력 예
//	랜덤 접근 시간: 23244ns (ArrayList)
//	랜덤 접근 시간: 4033463ns (LinkedList)



//배열 및 연결 리스트 삭제시간 비교
//https://cloudstudying.kr/challenges/307

// 출력 예
//	첫 요소 삭제 시간: 933189ns (ArrayList)
//	첫 요소 삭제 시간: 25739ns (LinkedList)


//배열 및 연결 리스트 랜덤삭제 비교
//https://cloudstudying.kr/challenges/308

//	랜덤 요소 삭제 시간: 273464ns (ArrayList)
//	랜덤 요소 삭제 시간: 4036401ns (ArrayList)


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
    System.out.printf("랜덤 접근 시간: %dns (ArrayList)\n", end - start);
    
    start = System.nanoTime();
    b.get(rand.nextInt(b.size()));
    end = System.nanoTime();
    System.out.printf("랜덤 접근 시간: %dns (LinkedList)\n", end - start);
    
    
    ////////////////
    start = System.nanoTime();
    a.remove(0);
    end = System.nanoTime();
    System.out.printf("첫 요소 삭제 시간: %dns (ArrayList)\n", end - start);
    
    start = System.nanoTime();
    b.remove(0);
    end = System.nanoTime();
    System.out.printf("첫 요소 삭제 시간: %dns (LinkedList)\n", end - start);
    
    
    ///////////////
    start = System.nanoTime();
    a.remove(rand.nextInt(a.size()));
    end = System.nanoTime();
    System.out.printf("랜덤 요소 삭제 시간: %dns (ArrayList)\n", end - start);
    
    start = System.nanoTime();
    b.remove(rand.nextInt(b.size()));
    end = System.nanoTime();
    System.out.printf("랜덤 요소 삭제 시간: %dns (LinkedList)\n", end - start);
  }
}