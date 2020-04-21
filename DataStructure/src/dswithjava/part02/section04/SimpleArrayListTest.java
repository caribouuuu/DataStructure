package dswithjava.part02.section04;

//SimpleArrayList: add 구현
//https://cloudstudying.kr/challenges/256

//SimpleArrayList: insert 구현
//SimpleArrayList: remove 구현

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
    /* 해당 메소드를 구현하시오. */
	  if(size < elements.length) {
		  elements[size++] = data;
	  }
  }
  
  public void insert(int index, int n) {
     /* 해당 코드를 구현하시오. */
	  if( size < elements.length) {	//넣을 공간이 있을경우 
		  for(int i=size; i>index; i--) {
			  elements[i] = elements[i-1];
		  }
		  size++;
		  elements[index] = n;
	  }else {
		  //못넣음!
	  } 
  }
  
  public void remove(int index) {
    /* 해당 메소드를 구현하시오. */
	  if(size>0 && index<=size) {
		  for(int i=index; i<size; i++) {
			  elements[i] = elements[i+1];
		  }
		  size--;
	  }else {
		  System.out.println("remove 실행불가 ");
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
