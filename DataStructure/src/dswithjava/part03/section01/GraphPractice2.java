package dswithjava.part03.section01;

//�׷����� ���� ����Ʈ
//https://cloudstudying.kr/challenges/434

// ���� �׷��� / ������ �׷���


//	�Է� ��
//4 (LINE 1: ������ ��)
//4 (LINE 2: ������ ��)
//0 1 0 2 2 0 3 2 ==  {<0,1>, <0,2>, <2,0>, <3,2>} (LINE 3: ������ ����)

//	��� ��
//	Vertex[0] -> 2 1 null
//	Vertex[1] -> null
//	Vertex[2] -> 0 null
//	Vertex[3] -> 2 null

// ���� �׷����� ���� ����Ʈ�� ����� �ڵ带 �����Ϸ� �Ѵ�. 

import java.util.Scanner;

public class GraphPractice2 {
  public static void main(String[] args) {
	  
	  String[] argss = {"4", "4", "0 1 0 2 2 0 3 2"};
    // �Է°� �ޱ�
    Scanner input = new Scanner(String.join(" ", argss));

    // ���� ����
    int nodeCnt = input.nextInt(); // ���� ��
    int lineCnt = input.nextInt(); // ���� ��

    // �׷��� �� ���� ����
    DirectedGraph2 graph = new DirectedGraph2(nodeCnt);

    // ���� �߰�
    for (int i = 0; i < lineCnt; i++) {
      int startNode = input.nextInt();
      int endNode = input.nextInt();
      graph.addEdge(startNode, endNode);
    }

    // ������� ���
    graph.printMatrix();
  }
}

class DirectedGraph2 {
  private int n;       // ���� ��
  private Node[] list; // ���� ����Ʈ

  // ���� V = { 0, 1, ..., n-1 }�� ���� �׷��� ����
  public DirectedGraph2(int n) {
    /* 1. �׷����� �����ڸ� �ۼ��ϼ���. */
	  this.n = n;
	  this.list = new Node[n];
  }

  // ���� <start, end>�� �߰�
  public void addEdge(int start, int end) {
    /* 2. ���� �߰� �޼ҵ带 �����ϼ���. */
	  Node newNode = new Node(end, list[start]);
	  list[start] = newNode;
  }
  
  // ��� ���� ����Ʈ�� ���
  public void printMatrix() {
    /* 3. �� ������ ���� ����� �������� ����ϼ���. */
	  for(int i=0; i<n; i++) {
		  System.out.print("Vertex["+i+"] ->");
		  Node temp = list[i];
		  while(temp != null) {
			  
			  System.out.printf(" %d", temp.vertex);
			  temp = temp.next;
		  }
		  System.out.println(" null");
	  }
	  
  }
}

class Node {
  int vertex;
  Node next;

  public Node(int vertex, Node next) {
    this.vertex = vertex;
    this.next = next;
  }
}
