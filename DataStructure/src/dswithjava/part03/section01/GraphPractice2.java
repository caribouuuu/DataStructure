package dswithjava.part03.section01;

//그래프와 인접 리스트
//https://cloudstudying.kr/challenges/434

// 방향 그래프 / 무방향 그래프


//	입력 예
//4 (LINE 1: 정점의 수)
//4 (LINE 2: 간선의 수)
//0 1 0 2 2 0 3 2 ==  {<0,1>, <0,2>, <2,0>, <3,2>} (LINE 3: 간선의 정보)

//	출력 예
//	Vertex[0] -> 2 1 null
//	Vertex[1] -> null
//	Vertex[2] -> 0 null
//	Vertex[3] -> 2 null

// 방향 그래프를 인접 리스트로 만드는 코드를 구현하려 한다. 

import java.util.Scanner;

public class GraphPractice2 {
  public static void main(String[] args) {
	  
	  String[] argss = {"4", "4", "0 1 0 2 2 0 3 2"};
    // 입력값 받기
    Scanner input = new Scanner(String.join(" ", argss));

    // 변수 생성
    int nodeCnt = input.nextInt(); // 정점 수
    int lineCnt = input.nextInt(); // 간선 수

    // 그래프 및 정점 생성
    DirectedGraph2 graph = new DirectedGraph2(nodeCnt);

    // 간선 추가
    for (int i = 0; i < lineCnt; i++) {
      int startNode = input.nextInt();
      int endNode = input.nextInt();
      graph.addEdge(startNode, endNode);
    }

    // 인접행렬 출력
    graph.printMatrix();
  }
}

class DirectedGraph2 {
  private int n;       // 정점 수
  private Node[] list; // 인접 리스트

  // 정점 V = { 0, 1, ..., n-1 }를 갖는 그래프 생성
  public DirectedGraph2(int n) {
    /* 1. 그래프의 생성자를 작성하세요. */
	  this.n = n;
	  this.list = new Node[n];
  }

  // 간선 <start, end>를 추가
  public void addEdge(int start, int end) {
    /* 2. 간선 추가 메소드를 구현하세요. */
	  Node newNode = new Node(end, list[start]);
	  list[start] = newNode;
  }
  
  // 모든 인접 리스트를 출력
  public void printMatrix() {
    /* 3. 각 정점에 대해 연결된 정점들을 출력하세요. */
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
