package dswithjava.part02.section04;


//https://cloudstudying.kr/lectures/138

// 배열 리스트(array-list) :: 배열을 사용한 리스트
// 리스트는 순서를 갖는 자료구조로서, 데이터간 공백이 없다. 

// 장점 
// 배열리스트는 읽기 속도가 O(1)로 빠르다. 왜? 고정된 연속적 메모리 공간을 차지하기 때문.

// 단점
// 1) 데이터 삽입(또는 삭제) 시, 속도가 O(n)으로 느리다. 왜? 기존 항목을 시프트 해야하기 때문. 
// 2) 배열의 크기가 큰 경우, 메모리 할당이 곤란할 수 있다.
// 3) 크기가 고정되어 있다. 배열이 꽉 차면 크기를 새롭게 늘리고 복사해줘야 한다.

//	단순 읽기(read) 및 쓰기(write) 작업이 많은 데이터에 좋다. 
//	삽입(insert) 및 삭제(remove) 연산이 많은 경우, 연결리스트(linked-list)를 추천한다.


//ArrayList 사용하기
//https://cloudstudying.kr/challenges/227

//주어진 뼈대코드를 실행하고 출력 결과 분석을 주석으로 작성하시오.

import java.util.ArrayList;
public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    System.out.printf("list = %s\n", list.toString());
    list.add(4);
    list.add(8);
    list.add(12);
    System.out.printf("list = %s\n", list.toString());
    list.add(1, 10);
    list.add(1, 100);
    System.out.printf("list = %s\n", list.toString());
    list.remove(2);
    list.remove(3);
    System.out.printf("list = %s\n", list.toString());
    System.out.printf("size: %d\n", list.size());
  }
}
