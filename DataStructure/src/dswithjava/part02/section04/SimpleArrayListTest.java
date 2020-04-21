package dswithjava.part02.section04;

//SimpleArrayList: add ����
//https://cloudstudying.kr/challenges/256

//SimpleArrayList: insert ����
//SimpleArrayList: remove ����

public class SimpleArrayListTest {
  public static void main(String[] args) {
    SimpleArrayList list = new SimpleArrayList();
    System.out.println(list);
    
    //add
//    list.add(11);
//    list.add(22);
//    list.add(33);
//    list.add(44);
    
    //insert
//    list.insert(3, 90);
//    list.insert(1, 99);
    
    //remove
    //list.remove(4);
    //list.remove(2);
    list.remove(0);
    list.remove(0);
    //list.remove(0);
    
    System.out.println(list);
  }
}
class SimpleArrayList {
  int[] elements;
  int size;
  public SimpleArrayList() {
    this.elements = new int[10];
    //this.size = 0;
    this.size = 8;
    for (int i = 0; i < size; i++) {
      elements[i] = 100 - 4 * i;
    }
  }
  public void add(int data) {
    /* �ش� �޼ҵ带 �����Ͻÿ�. */
	  if(size < elements.length) {
		  elements[size++] = data;
	  }
  }
  
  public void insert(int index, int n) {
     /* �ش� �ڵ带 �����Ͻÿ�. */
	  if( size < elements.length) {	//���� ������ ������� 
		  for(int i=size; i>index; i--) {
			  elements[i] = elements[i-1];
		  }
		  size++;
		  elements[index] = n;
	  }else {
		  //������!
	  } 
  }
  
  public void remove(int index) {
    /* �ش� �޼ҵ带 �����Ͻÿ�. */
	  if(size>0 && index<=size) {
		  for(int i=index; i<size; i++) {
			  elements[i] = elements[i+1];
		  }
		  size--;
	  }else {
		  System.out.println("remove ����Ұ� ");
	  }
  }
  
  
  public String toString() {
    StringBuffer sbuf = new StringBuffer("list = ");
    for (int i = 0; i < size; i++) {
      sbuf.append(elements[i] + " ");
    }
    return sbuf.toString();
  }
}
