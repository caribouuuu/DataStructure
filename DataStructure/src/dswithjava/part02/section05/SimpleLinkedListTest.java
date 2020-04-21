package dswithjava.part02.section05;

//연결 리스트(linked-list) :: 연결 리스트란 노드(node)의 연결로 이루어진 리스트이다. (리스트: 공백없는 데이터의 나열) 
//https://cloudstudying.kr/lectures/217

// 장점
//	1. 데이터의 삽입 삭제 연산이 빠름. O(1) <-> 배열: O(n)
//	2. 리스트 내, 데이터 이동 없음.
//	3. 큰 메모리공간 필요하지 않음.

// 단점 
//	1. n번째 노드 접근시 O(n) 지연 발생 <-> 배열: O(1)
//	2. 포인터로 인한 메모리 낭비.

// 종류 
//	1) singly linked-list (단순 연결리스트)
//	2) doubly linked-list (이중 연결리스트)
//	3) circularly linked-list (원형 연결리스트)



//1) singly linked-list (단순 연결리스트) 
// 명세
//	데이터를 순서 기준(0부터 시작)으로 다룬다.
//	데이터의 시작점을 head로 가리킨다.
//	데이터는 노드(node)에 담아 보관한다.
//	i번째 위치에 데이터를 추가 및 삭제 할 수 있다.
//	모든 노드를 차례대로 출력한다.


//단일 연결 리스트: addFirst(data)
//https://cloudstudying.kr/challenges/247

//단일 연결 리스트: add(position, data)
//https://cloudstudying.kr/challenges/248

//단일 연결 리스트: remove(position)
//https://cloudstudying.kr/challenges/249

public class SimpleLinkedListTest {
  public static void main (String[] args) {
    SimpleLinkedListImpl list = new SimpleLinkedListImpl();
    System.out.println(list); // List { }
    
    list.addFirst(11);
    list.addFirst(22);
    list.addFirst(33);
    
    list.add(2, 44);
    
    System.out.printf("removed: %d\n", list.remove(1));
    
    System.out.println(list); // List { 33 22 11 }
  } 
}

class SimpleLinkedListImpl {
  private Node head;
  
  public SimpleLinkedListImpl() {
    this.head = null;
  }
  
  public void addFirst(int data) {
    /* 해당 메소드를 구현하시오. */
	  /*
	  if(head != null) {
		  head = new Node(data, head);
	  }else {	//head==null
		  head = new Node(data, null);
	  }
	  */
	  head = new Node(data, head);
	  
  }
  
  public void add(int position, int data) {
    /* 해당 메소드를 구현하시오. */
	  Node temp = head;
	  for(int i=0; i<position-1; i++) {	//넣으려는 위치 직전의 노드까지...이동
		  temp = temp.next;	//다음 노드로 이동
	  }
	  temp.next = new Node(data, temp.next);	
	  //새로 넣을 노드의 next에 현재 노드의 다음 노드(넣으려는 위치 직후의 노드)를 연결해 생성한 후
	  //현재 노드(넣으려는 위치 직전의 노드)의 next에 바로 연결해주기
	  
	  /* -- 정답 --
	  Node prev = head;
	    for (int i = 0; i < position - 1; i++) {
	      prev = prev.next;
	    }
	    // prev == head 인경우 에러!
	    prev.next = new Node(data, prev.next);
	    */
  }
  
  public int remove(int position) {
    /* 해당 메소드를 구현하시오. */
	  
	Node temp = head;
	for(int i=0; i<position-1; i++) {	//지우려는 위치 직전 노드까지 이동
		temp = temp.next;
	}
	
	int removeData = temp.next.data;
	temp.next = temp.next.next;
	
    return removeData;
  }
  
  
  public String toString() {
    StringBuffer sbuf = new StringBuffer("List { ");
    Node current = head;
    while (current != null) {
      sbuf.append(current.data + " ");
      current = current.next;
    }
    return sbuf.append("}").toString();
  }
}

class Node {
  int data;
  Node next;
  
  Node(int data, Node next) {
    this.data = data;
    this.next = next;
  }
}