package dswithjava.part02.section01;

//https://cloudstudying.kr/lectures/141
// 스택 : 가장 마지막에 넣은 자료가 가장 먼저 나오는 특징(LIFO: last in first out)을 가진 자료구조

//스택은 히스토리 역추적에 최적화 되어있다. 가장 최근에 일어난 이벤트부터 가장 이전에 일어난 이벤트 관리 시 스택을 사용하면 수월하다.
//문서 작업시 빈번히 사용하는 실행 취소(Undo) 및 복구(Redo)의 경우를 스택의 적용 예로 들 수 있다.
//스택은 탑(top)이라 하는 한쪽 끝에서 모든 삽입(push)과 삭제(pop)가 이루어진다. 
//메소드 호출과 복귀는 스택을 통해 관리된다.
//프로그램의 호출과 복귀는 가장 나중(last)에 호출된 함수가 가장 먼저(first) 실행을 완료하고 복귀한다. 
//이때 사용하는 스택을 시스템 스택이라 한다.

//JVM은 메소드 호출 시 수행에 필요한 지역변수, 매개변수, 수행 후 복귀 주소 등의 정보를 시스템 스택에 삽입한다. 
//시스템 스택의 top은 현재 실행중인 메소드이다. 메소드 수행이 완료되면 top 원소는 제거되고 새로운 top의 메소드의 복귀주소로 실행흐름이 넘어간다. 이러한 과정을 반복하여 전체 프로그램 수행이 종료되면 시스템 스택은 공백이 된다. 

//5.1 명세서
//1) 요소를 삽입(push)하고 꺼낼(pop) 수 있다.
//2) 마지막에 넣은 요소가 가장 먼저 나오게 된다. (Last In First Out)
//3) 스택이 가득찬(full) 경우 요소를 삽입 할 수 없다.
//4) 스택이 비어있는(empty) 경우, 요소를 꺼내올 수 없다.


//스택: push() 구현
//https://cloudstudying.kr/challenges/264


public class MyStackTes01 {
  public static void main(String[] args) {
    MyStack stack = new MyStack();
    stack.push(1);
    stack.push(2);
    stack.push(32);
    stack.push(4);
    stack.push(5);
    stack.push(6);
    stack.push(7);
    System.out.println(stack);
  }
}
class MyStack {
  private int[] array;
  private int capacity;
  private int top;
  public MyStack() {
    this.array = new int[5];
    this.capacity = 5;
    this.top = -1;
  }
  
  public void push(int data) {
    /* 해당 메소드를 구현하시오. */
	if(top < capacity-1) {	//현재 마지막 원소의 위치가 스택의 맨 위거나 그보다 아래인 경우
		//마지막 원소 위치+1 한 후 그 위치에 데이터 삽입 
		//-1이었으면 0에 데이터넣고, 0이었으면 1에 넣고... 3이었으면 4에넣고 
		top++;	
		array[top] = data;
		//=> array[++top] = data;
		
	}else {	//top >= capacity-1 :: 
		System.out.println("Stack is Full");
		return;
	} 
  }
  
  @Override
  public String toString() {
    StringBuffer sbuf = new StringBuffer();
    for (int i = capacity - 1; i >= 0; i--) {
      Integer data = (i <= top) ? array[i] : null;
      sbuf.append(String.format("| %4s |%s\n", data, (i == top) ? " <- top " : ""));
    }
    return sbuf.append("--------\n").toString();
  }
  
}