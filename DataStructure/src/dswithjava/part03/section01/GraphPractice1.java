package dswithjava.part03.section01;

//Non-Linear Structure

//�׷��� :: ����(vertex(=node))�� ����(edge(=line))���� �̷���� �ڷᱸ���̴�. 
//https://cloudstudying.kr/lectures/371

// ���� �� Ȱ��
//�׷����� ��ü�� ��ü �� ���踦 ��Ÿ���� �־� Ưȭ�Ǿ��ִ�.
//�̷� ���� �ǻ�Ȱ�� �پ��� �о߿��� ���ȴ�. 
//���� ��� ���̽����� ģ�� ���赵, �Ұ��� ��Ī ���赵, ����ö���� ����� ���� ���� �׷����� ǥ���� �� �ִ�. 

// �з� : �׷����� ������ ���� ���⼺�� ����ġ�� ������ ���� �� 4������ �з��ȴ�. 
// directed / undirected
// weighted / unweighted

// ���� : �׷����� �پ��� ����� ������ �����ϴ�. 
//���⼭�� ���� ���(adjacency matrix)�� ���� ����Ʈ(adjacency list)�� ���·� �����غ���.

//	1. ���� ���  adjacency matrix
//	���� ����� 2���� �迭�� �����Ѵ�. �� �迭�� A�� �� ��, �׷����� ���� 0�� 1�� ����Ǿ��ٸ�, A[0][1] = 1 �̴�. 
//	������ �׷����� ��� 1���� 0���� ����� ���̹Ƿ� A[1][0] = 1�̴�. ������� ���� ���� 0�� �����Ѵ�. 
//	������ �������� start, �������� end�� �� ��, �� ������ �Ϲ�ȭ�ϸ� ������ ����. 
//	A[start][end] = 1 (����)
//	A[start][end] = 0 (�̿���)

//	2. ���� ����Ʈ  adjacency list
//	���� ����Ʈ�� ���� ����Ʈ�� �迭�� �����Ѵ�. �� �迭�� A�� �� ��, A[i]�� ���� i�� ����� ��� ����� ����Ʈ�̴�.




//�׷����� ���� ���
//https://cloudstudying.kr/challenges/368

//LINE 1: ������ ��
//LINE 2: ������ ��
//LINE 3: ������ ����

//4
//4
//0 1 0 2 2 0 3 2 ==  {<0,1>, <0,2>, <2,0>, <3,2>} 


import java.util.Scanner;

public class GraphPractice1 {
  public static void main(String[] args) {
	 
	//String[] argss = {"4", "4", "0 1 0 2 2 0 3 2"};
    // �Է°� �ޱ�
    Scanner input = new Scanner(String.join(" ", args));
    //Scanner input = new Scanner(String.join(" ",argss));

    // ���� ����
    int nodeCnt = input.nextInt(); // ���� ��
    int lineCnt = input.nextInt(); // ���� ��
    
    // �׷��� �� ���� ����
    DirectedGraph graph = new DirectedGraph(nodeCnt);
    
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

class DirectedGraph {
  private int n;          // ���� ��
  private int[][] matrix; // ���� ���

  // ���� V = { 0, 1, ..., n-1 }�� ���� �׷��� ����
  public DirectedGraph(int n) {
    /* 1. �����ڸ� �ϼ����ּ���. */
	  this.n = n;	//���� �� �ʱ�ȭ
	  matrix = new int[n][n];	//���� ��� �ʱ�ȭ
  }

  // ���� <start, end>�� �߰�
  public void addEdge(int start, int end) {
    /* 2. �ش� �޼ҵ带 �ϼ����ּ���. */
	  matrix[start][end] = 1;	//����׷����� ���� ����
	  //matrix[end][start] = 1;
  }
  
  // ���� ����� ���
  public void printMatrix() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.printf("%d ", matrix[i][j]);
      }
      System.out.println();
    }
  }
}