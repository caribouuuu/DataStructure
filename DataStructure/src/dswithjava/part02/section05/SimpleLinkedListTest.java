package dswithjava.part02.section05;

//���� ����Ʈ(linked-list) :: ���� ����Ʈ�� ���(node)�� ����� �̷���� ����Ʈ�̴�. (����Ʈ: ������� �������� ����) 
//https://cloudstudying.kr/lectures/217

// ����
//	1. �������� ���� ���� ������ ����. O(1) <-> �迭: O(n)
//	2. ����Ʈ ��, ������ �̵� ����.
//	3. ū �޸𸮰��� �ʿ����� ����.

// ���� 
//	1. n��° ��� ���ٽ� O(n) ���� �߻� <-> �迭: O(1)
//	2. �����ͷ� ���� �޸� ����.

// ���� 
//	1) singly linked-list (�ܼ� ���Ḯ��Ʈ)
//	2) doubly linked-list (���� ���Ḯ��Ʈ)
//	3) circularly linked-list (���� ���Ḯ��Ʈ)



//1) singly linked-list (�ܼ� ���Ḯ��Ʈ) 
// ��
//	�����͸� ���� ����(0���� ����)���� �ٷ��.
//	�������� �������� head�� ����Ų��.
//	�����ʹ� ���(node)�� ��� �����Ѵ�.
//	i��° ��ġ�� �����͸� �߰� �� ���� �� �� �ִ�.
//	��� ��带 ���ʴ�� ����Ѵ�.


//���� ���� ����Ʈ: addFirst(data)
//https://cloudstudying.kr/challenges/247

//���� ���� ����Ʈ: add(position, data)
//https://cloudstudying.kr/challenges/248

//���� ���� ����Ʈ: remove(position)
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
    /* �ش� �޼ҵ带 �����Ͻÿ�. */
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
    /* �ش� �޼ҵ带 �����Ͻÿ�. */
	  Node temp = head;
	  for(int i=0; i<position-1; i++) {	//�������� ��ġ ������ ������...�̵�
		  temp = temp.next;	//���� ���� �̵�
	  }
	  temp.next = new Node(data, temp.next);	
	  //���� ���� ����� next�� ���� ����� ���� ���(�������� ��ġ ������ ���)�� ������ ������ ��
	  //���� ���(�������� ��ġ ������ ���)�� next�� �ٷ� �������ֱ�
	  
	  /* -- ���� --
	  Node prev = head;
	    for (int i = 0; i < position - 1; i++) {
	      prev = prev.next;
	    }
	    // prev == head �ΰ�� ����!
	    prev.next = new Node(data, prev.next);
	    */
  }
  
  public int remove(int position) {
    /* �ش� �޼ҵ带 �����Ͻÿ�. */
	  
	Node temp = head;
	for(int i=0; i<position-1; i++) {	//������� ��ġ ���� ������ �̵�
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