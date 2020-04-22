package dswithjava.part03.section02;

import java.util.LinkedList;
import java.util.Queue;

// ���� �켱 Ž�� (DFS :Depth-First Search) 
// �ʺ� �켱 Ž�� (BFS :Breadth-First Search)


//https://mygumi.tistory.com/102
//DFS�� ������ ���, BFS�� ť�� ����Ѵ�


//���� Ʈ�� ���� �켱(DFS) ��ȸ - ���� (Preorder)
//https://cloudstudying.kr/challenges/280
// ���� ��ȸ (Preorder) : ���� ��� -> ���� �ڽ� -> ���� �ڽ� ������ �켱 �湮�Ѵ�. Ʈ���� ��� ��带 �湮�ϴ� ��� �� �ϳ��̴�. 
//	��� �� :: preorder: 11 22 44 55 33 66 77


//���� Ʈ�� ���� �켱(DFS) ��ȸ - ����
//https://cloudstudying.kr/challenges/438
// ���� ��ȸ (Inorder) : ���� �ڽ� -> ���� ��� -> ���� �ڽ� ������ �켱 �湮�Ѵ�.
//	��� �� :: inorder: 44 22 55 11 66 33 77


//���� Ʈ�� ���� �켱(DFS) ��ȸ - ����
//https://cloudstudying.kr/challenges/439
// ���� ��ȸ (Postorder) : �����ڽ� -> �����ڽ� -> ���� ��� ������ �켱 �湮�Ѵ�.
//	��� �� :: postorder: 44 55 22 66 77 33 11


//���� Ʈ�� ���� �켱(BFS) ��ȸ
//https://cloudstudying.kr/challenges/440
//	��� �� :: BFS ��ȸ: 11 22 33 44 55 66 77 


public class DFSAndBFS {
  public static void main(String[] args) {
    // Ʈ�� ���� �� ����ȭ
    MyTree tree7 = new MyTree(77, null, null);
    MyTree tree6 = new MyTree(66, null, null);
    MyTree tree5 = new MyTree(55, null, null);
    MyTree tree4 = new MyTree(44, null, null);
    MyTree tree3 = new MyTree(33, tree6, tree7);
    MyTree tree2 = new MyTree(22, tree4, tree5);
    MyTree tree1 = new MyTree(11, tree2, tree3);
    
    //���� �켱 Ž�� DFS
    // ���� ��ȸ ���
    tree1.printPreorder(); 
    
    // ���� ��ȸ ���
    tree1.printInorder();
    
    // ���� ��ȸ ���
    tree1.printPostorder();
    
    
    //�ʺ� �켱 Ž�� BFS
    tree1.printBFS();
    
  }
}

class MyTree {
  // �ֻ��� ���
  private Node root;

  // ������
  public MyTree(int data, MyTree leftSubtree, MyTree rightSubtree) {
    // ��Ʈ ��� ����
    this.root = new Node(data, null, null);

    // ���� Ʈ�� ����
    root.leftChild = (leftSubtree == null) ? null : leftSubtree.root;
    root.rightChild = (rightSubtree == null) ? null : rightSubtree.root;
  }
  
  // DFS
  // ���� ��ȸ
  public void printPreorder() {
    System.out.print("preorder: ");
    _preorder(root); // ��� ȣ��
    System.out.println();
  }
  private void _preorder(Node parent) {
    /* 1: ����� ���� ��ȸ�� �����Ͻÿ�. */
	  
	  if(parent == null) {
		  return;
	  }//else {
		  System.out.printf("%d ", parent.data);
	  //}
	  _preorder(parent.leftChild);
	  _preorder(parent.rightChild);
	  
  }
  
  //���� ��ȸ
  public void printInorder() {
	  System.out.print("inorder: ");
	  _inorder(root); // ��� ȣ��
	  System.out.println();
  }
  private void _inorder(Node parent) {
   /* ����� ���� ��ȸ�� �����Ͻÿ�. */
	  if(parent == null) {
		  return;
	  }
	  _inorder(parent.leftChild);
	  System.out.printf("%d ", parent.data);
	  _inorder(parent.rightChild);
  }
  
  //���� ��ȸ
  public void printPostorder() {
	  System.out.print("postorder: ");
	  _postorder(root); // ��� ȣ��
	  System.out.println();
  }
  private void _postorder(Node parent) {
	/* �ش� �޼ҵ带 �����Ͽ� ���� ��ȸ�� �ϼ��Ͻÿ�. */
	  if(parent == null) {
		  return;
	  }
	  _postorder(parent.leftChild);
	  _postorder(parent.rightChild);
	  System.out.printf("%d ", parent.data);
  }
  
  
  // BFS
  public void printBFS() {
	  System.out.print("BFS ��ȸ: ");
	  /* �ش� �޼ҵ带 �����Ͻÿ�. */
	 
	  //ť�� �̿��� ����Ʈ�� BFS ����
	  Queue<Node> queue = new LinkedList<Node>();
	  
	  queue.add(root);	//Ʈ���� �ֻ��� ������ ����
	  
	  while(!queue.isEmpty()) {
		  
		  Node firstNode = queue.poll();	//ť�� �� �� ��带 ������
		  
		  if(firstNode.leftChild != null) {
			  queue.add(firstNode.leftChild);	//������ ����� ���� �ڽĳ�尡 �ִٸ� ť�� �ֱ� 
		  }
		  if(firstNode.rightChild != null) {
			  queue.add(firstNode.rightChild);	//������ ����� ������ �ڽĳ�尡 �ִٸ� ť�� �ֱ� 
		  }
		  //ť���� ���´� ����� ��� �ڽĳ�带 �˻��� ť�� ���� ��, ��ȸ�� �ǹ̷� data ���
		  System.out.printf("%d ", firstNode.data);
	  }	//ť�� ���̻� ��尡 ���� ���������� ����
	  
	  
	  System.out.println();
  }
}

class Node {
  int data; // ������
  Node leftChild; // ���� �ڽ� ���
  Node rightChild; // ������ �ڽ� ���
  
  public Node(int data, Node leftChild, Node rightChild) {
    this.data = data;
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }
}
