package dswithjava.part03.section01;

//Non-Linear Structure

//그래프 :: 정점(vertex(=node))과 간선(edge(=line))으로 이루어진 자료구조이다. 
//https://cloudstudying.kr/lectures/371

// 장점 및 활용
//그래프는 객체와 객체 간 관계를 나타냄에 있어 특화되어있다.
//이로 인해 실생활의 다양한 분야에서 사용된다. 
//예를 들면 페이스북의 친구 관계도, 소개팅 매칭 관계도, 지하철역과 연결된 선로 등을 그래프로 표현할 수 있다. 

// 분류 : 그래프는 간선에 대한 방향성과 가중치의 유무에 따라 총 4가지로 분류된다. 
// directed / undirected
// weighted / unweighted

// 구현 : 그래프는 다양한 방법의 구현이 가능하다. 
//여기서는 인접 행렬(adjacency matrix)과 인접 리스트(adjacency list)의 형태로 연습해보자.

//	1. 인접 행렬  adjacency matrix
//	인접 행렬은 2차원 배열로 구현한다. 이 배열을 A라 할 때, 그래프의 정점 0이 1로 연결되었다면, A[0][1] = 1 이다. 
//	무방향 그래프의 경우 1또한 0으로 연결된 것이므로 A[1][0] = 1이다. 연결되지 않은 경우는 0을 대입한다. 
//	연결의 시작점을 start, 도착점을 end로 할 때, 위 내용을 일반화하면 다음과 같다. 
//	A[start][end] = 1 (연결)
//	A[start][end] = 0 (미연결)

//	2. 인접 리스트  adjacency list
//	인접 리스트는 연결 리스트의 배열로 구현한다. 이 배열을 A라 할 때, A[i]는 정점 i에 연결된 모든 노드의 리스트이다.




//그래프와 인접 행렬
//https://cloudstudying.kr/challenges/368

//LINE 1: 정점의 수
//LINE 2: 간선의 수
//LINE 3: 간선의 정보

//4
//4
//0 1 0 2 2 0 3 2 ==  {<0,1>, <0,2>, <2,0>, <3,2>} 


import java.util.Scanner;

public class GraphPractice1 {
  public static void main(String[] args) {
	 
	//String[] argss = {"4", "4", "0 1 0 2 2 0 3 2"};
    // 입력값 받기
    Scanner input = new Scanner(String.join(" ", args));
    //Scanner input = new Scanner(String.join(" ",argss));

    // 변수 생성
    int nodeCnt = input.nextInt(); // 정점 수
    int lineCnt = input.nextInt(); // 간선 수
    
    // 그래프 및 정점 생성
    DirectedGraph graph = new DirectedGraph(nodeCnt);
    
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

class DirectedGraph {
  private int n;          // 정점 수
  private int[][] matrix; // 인접 행렬

  // 정점 V = { 0, 1, ..., n-1 }를 갖는 그래프 생성
  public DirectedGraph(int n) {
    /* 1. 생성자를 완성해주세요. */
	  this.n = n;	//정점 수 초기화
	  matrix = new int[n][n];	//인접 행렬 초기화
  }

  // 간선 <start, end>를 추가
  public void addEdge(int start, int end) {
    /* 2. 해당 메소드를 완성해주세요. */
	  matrix[start][end] = 1;	//방향그래프의 간선 생성
	  //matrix[end][start] = 1;
  }
  
  // 인점 행렬을 출력
  public void printMatrix() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.printf("%d ", matrix[i][j]);
      }
      System.out.println();
    }
  }
}