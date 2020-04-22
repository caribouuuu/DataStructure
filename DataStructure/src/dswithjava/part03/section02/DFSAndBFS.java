package dswithjava.part03.section02;

import java.util.LinkedList;
import java.util.Queue;

// 깊이 우선 탐색 (DFS :Depth-First Search) 
// 너비 우선 탐색 (BFS :Breadth-First Search)


//https://mygumi.tistory.com/102
//DFS는 스택을 사용, BFS는 큐를 사용한다


//이진 트리 깊이 우선(DFS) 순회 - 전위 (Preorder)
//https://cloudstudying.kr/challenges/280
// 전위 순회 (Preorder) : 현재 노드 -> 좌측 자식 -> 우측 자식 순으로 우선 방문한다. 트리의 모든 노드를 방문하는 방법 중 하나이다. 
//	출력 예 :: preorder: 11 22 44 55 33 66 77


//이진 트리 깊이 우선(DFS) 순회 - 중위
//https://cloudstudying.kr/challenges/438
// 중위 순회 (Inorder) : 좌측 자식 -> 현재 노드 -> 우측 자식 순으로 우선 방문한다.
//	출력 예 :: inorder: 44 22 55 11 66 33 77


//이진 트리 깊이 우선(DFS) 순회 - 후위
//https://cloudstudying.kr/challenges/439
// 후위 순회 (Postorder) : 좌측자식 -> 우측자식 -> 현재 노드 순으로 우선 방문한다.
//	출력 예 :: postorder: 44 55 22 66 77 33 11


//이진 트리 넓이 우선(BFS) 순회
//https://cloudstudying.kr/challenges/440
//	출력 예 :: BFS 순회: 11 22 33 44 55 66 77 


public class DFSAndBFS {
  public static void main(String[] args) {
    // 트리 생성 및 구조화
    MyTree tree7 = new MyTree(77, null, null);
    MyTree tree6 = new MyTree(66, null, null);
    MyTree tree5 = new MyTree(55, null, null);
    MyTree tree4 = new MyTree(44, null, null);
    MyTree tree3 = new MyTree(33, tree6, tree7);
    MyTree tree2 = new MyTree(22, tree4, tree5);
    MyTree tree1 = new MyTree(11, tree2, tree3);
    
    //깊이 우선 탐색 DFS
    // 전위 순회 출력
    tree1.printPreorder(); 
    
    // 중위 순회 출력
    tree1.printInorder();
    
    // 후위 순회 출력
    tree1.printPostorder();
    
    
    //너비 우선 탐색 BFS
    tree1.printBFS();
    
  }
}

class MyTree {
  // 최상위 노드
  private Node root;

  // 생성자
  public MyTree(int data, MyTree leftSubtree, MyTree rightSubtree) {
    // 루트 노드 생성
    this.root = new Node(data, null, null);

    // 서브 트리 연결
    root.leftChild = (leftSubtree == null) ? null : leftSubtree.root;
    root.rightChild = (rightSubtree == null) ? null : rightSubtree.root;
  }
  
  // DFS
  // 전위 순회
  public void printPreorder() {
    System.out.print("preorder: ");
    _preorder(root); // 재귀 호출
    System.out.println();
  }
  private void _preorder(Node parent) {
    /* 1: 재귀적 전위 순회를 구현하시오. */
	  
	  if(parent == null) {
		  return;
	  }//else {
		  System.out.printf("%d ", parent.data);
	  //}
	  _preorder(parent.leftChild);
	  _preorder(parent.rightChild);
	  
  }
  
  //중위 순회
  public void printInorder() {
	  System.out.print("inorder: ");
	  _inorder(root); // 재귀 호출
	  System.out.println();
  }
  private void _inorder(Node parent) {
   /* 재귀적 중위 순회를 구현하시오. */
	  if(parent == null) {
		  return;
	  }
	  _inorder(parent.leftChild);
	  System.out.printf("%d ", parent.data);
	  _inorder(parent.rightChild);
  }
  
  //후위 순회
  public void printPostorder() {
	  System.out.print("postorder: ");
	  _postorder(root); // 재귀 호출
	  System.out.println();
  }
  private void _postorder(Node parent) {
	/* 해당 메소드를 구현하여 후위 순회를 완성하시오. */
	  if(parent == null) {
		  return;
	  }
	  _postorder(parent.leftChild);
	  _postorder(parent.rightChild);
	  System.out.printf("%d ", parent.data);
  }
  
  
  // BFS
  public void printBFS() {
	  System.out.print("BFS 순회: ");
	  /* 해당 메소드를 구현하시오. */
	 
	  //큐를 이용한 이진트리 BFS 구현
	  Queue<Node> queue = new LinkedList<Node>();
	  
	  queue.add(root);	//트리의 최상위 노드부터 시작
	  
	  while(!queue.isEmpty()) {
		  
		  Node firstNode = queue.poll();	//큐의 맨 앞 노드를 꺼내옴
		  
		  if(firstNode.leftChild != null) {
			  queue.add(firstNode.leftChild);	//꺼내온 노드의 왼쪽 자식노드가 있다면 큐에 넣기 
		  }
		  if(firstNode.rightChild != null) {
			  queue.add(firstNode.rightChild);	//꺼내온 노드의 오른쪽 자식노드가 있다면 큐에 넣기 
		  }
		  //큐에서 꺼냈던 노드의 모든 자식노드를 검사후 큐에 넣은 후, 순회의 의미로 data 출력
		  System.out.printf("%d ", firstNode.data);
	  }	//큐에 더이상 노드가 남지 않을때까지 실행
	  
	  
	  System.out.println();
  }
}

class Node {
  int data; // 데이터
  Node leftChild; // 왼쪽 자식 노드
  Node rightChild; // 오른쪽 자식 노드
  
  public Node(int data, Node leftChild, Node rightChild) {
    this.data = data;
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }
}
