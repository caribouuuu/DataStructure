package dswithjava.part02.section05;

//이중 연결 리스트: addFirst(data)
//https://cloudstudying.kr/challenges/250

//이중 연결 리스트: add(pos, data)
//https://cloudstudying.kr/challenges/251

//이중 연결 리스트: remove(pos)
//https://cloudstudying.kr/challenges/252


public class DoublyLinkedListTest {
  public static void main(String[] args) {
    DoublyLinkedList list = new DoublyLinkedList();
    
    list.addFirst(11);
    list.addFirst(22);
    list.addFirst(33);
    
    list.add(1, 44); // 1번 위치에 새로운 노드를 추가(0부터 시작함을 주의)
    
    list.remove(2);
    
    System.out.println(list.toString());
    System.out.println(list.toStringBackward());
  }
}

class DoublyLinkedList {
  private Node head;
  private Node tail;
  public DoublyLinkedList() {
    this.head = null;
    this.tail = null;
  }
  
  public void addFirst(int data) {
    /* 해당 메소드를 구현하시오. */
	  Node newNode = new Node(data, null, head);	//새로운 노드의 왼쪽은 항상 null, 오른쪽은 이전 head!
	  if( tail == null) {
		  tail = newNode;	//마지막 노드가 없으면 tail이 새로운 노드를 가리킴
	  }else {	//tail!=null
		  head.left = newNode;	//새로운 노드를 기존 head의 왼쪽에 연결
	  }
	  head = newNode;	
  }
  
  public void add(int pos, int data) {
    /* 해당 메소드를 구현하시오. */
	  
	  Node prev = head;
	  
	  for(int i=0; i<pos-1; i++) {
		  prev = prev.right;
	  }
	  
	  Node next = prev.right;
	  Node newest = new Node(data, prev, next);
	  
	  prev.right = newest;
	  next.left = newest;
  }
  
  public void remove(int pos) {
    /* 해당 메소드를 구현하시오. */
	  
	  Node prev = head;
	  for(int i=0; i<pos-1; i++) {
		  prev = prev.right;
	  }
	  prev.right = prev.right.right;
	  prev.right.left = prev;
	  
  }
  
  /*
  public int remove(int pos) {
	  Node target = head;
	  for(int i=0; i<pos; i++) {
		  target = target.right;
	  }
	  Node prev = target.left;
	  Node next = target.right;
	  
	  int removed = target.data;
	  prev.right = next;
	  next.left = prev;
	  
	  return removed;
  }
  */
  
  public String toString() {
    StringBuffer sbuf = new StringBuffer("list: head -> ");
    Node temp = head;
    while (temp != null) {
      sbuf.append(temp.data + " -> ");
      temp = temp.right;
    }
    return sbuf.append("null").toString();
  }
  
  public String toStringBackward() {
    StringBuffer sbuf = new StringBuffer("list: tail -> ");
    Node temp = tail;
    while (temp != null) {
      sbuf.append(temp.data + " -> ");
      temp = temp.left;
    }
    return sbuf.append("null").toString();
  }
  
  class Node {
    int data;
    Node left;
    Node right;
    private Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  } //Node Class
  
}