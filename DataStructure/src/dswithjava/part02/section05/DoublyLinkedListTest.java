package dswithjava.part02.section05;

//���� ���� ����Ʈ: addFirst(data)
//https://cloudstudying.kr/challenges/250

//���� ���� ����Ʈ: add(pos, data)
//https://cloudstudying.kr/challenges/251

//���� ���� ����Ʈ: remove(pos)
//https://cloudstudying.kr/challenges/252


public class DoublyLinkedListTest {
  public static void main(String[] args) {
    DoublyLinkedList list = new DoublyLinkedList();
    
    list.addFirst(11);
    list.addFirst(22);
    list.addFirst(33);
    
    list.add(1, 44); // 1�� ��ġ�� ���ο� ��带 �߰�(0���� �������� ����)
    
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
    /* �ش� �޼ҵ带 �����Ͻÿ�. */
	  Node newNode = new Node(data, null, head);	//���ο� ����� ������ �׻� null, �������� ���� head!
	  if( tail == null) {
		  tail = newNode;	//������ ��尡 ������ tail�� ���ο� ��带 ����Ŵ
	  }else {	//tail!=null
		  head.left = newNode;	//���ο� ��带 ���� head�� ���ʿ� ����
	  }
	  head = newNode;	
  }
  
  public void add(int pos, int data) {
    /* �ش� �޼ҵ带 �����Ͻÿ�. */
	  
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
    /* �ش� �޼ҵ带 �����Ͻÿ�. */
	  
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