package dswithjava.part02.section01;

//https://cloudstudying.kr/lectures/141
// ���� : ���� �������� ���� �ڷᰡ ���� ���� ������ Ư¡(LIFO: last in first out)�� ���� �ڷᱸ��

//������ �����丮 �������� ����ȭ �Ǿ��ִ�. ���� �ֱٿ� �Ͼ �̺�Ʈ���� ���� ������ �Ͼ �̺�Ʈ ���� �� ������ ����ϸ� �����ϴ�.
//���� �۾��� ����� ����ϴ� ���� ���(Undo) �� ����(Redo)�� ��츦 ������ ���� ���� �� �� �ִ�.
//������ ž(top)�̶� �ϴ� ���� ������ ��� ����(push)�� ����(pop)�� �̷������. 
//�޼ҵ� ȣ��� ���ʹ� ������ ���� �����ȴ�.
//���α׷��� ȣ��� ���ʹ� ���� ����(last)�� ȣ��� �Լ��� ���� ����(first) ������ �Ϸ��ϰ� �����Ѵ�. 
//�̶� ����ϴ� ������ �ý��� �����̶� �Ѵ�.

//JVM�� �޼ҵ� ȣ�� �� ���࿡ �ʿ��� ��������, �Ű�����, ���� �� ���� �ּ� ���� ������ �ý��� ���ÿ� �����Ѵ�. 
//�ý��� ������ top�� ���� �������� �޼ҵ��̴�. �޼ҵ� ������ �Ϸ�Ǹ� top ���Ҵ� ���ŵǰ� ���ο� top�� �޼ҵ��� �����ּҷ� �����帧�� �Ѿ��. �̷��� ������ �ݺ��Ͽ� ��ü ���α׷� ������ ����Ǹ� �ý��� ������ ������ �ȴ�. 

//5.1 ����
//1) ��Ҹ� ����(push)�ϰ� ����(pop) �� �ִ�.
//2) �������� ���� ��Ұ� ���� ���� ������ �ȴ�. (Last In First Out)
//3) ������ ������(full) ��� ��Ҹ� ���� �� �� ����.
//4) ������ ����ִ�(empty) ���, ��Ҹ� ������ �� ����.


//����: push() ����
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
    /* �ش� �޼ҵ带 �����Ͻÿ�. */
	if(top < capacity-1) {	//���� ������ ������ ��ġ�� ������ �� ���ų� �׺��� �Ʒ��� ���
		//������ ���� ��ġ+1 �� �� �� ��ġ�� ������ ���� 
		//-1�̾����� 0�� �����ͳְ�, 0�̾����� 1�� �ְ�... 3�̾����� 4���ְ� 
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