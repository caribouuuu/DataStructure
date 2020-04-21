package dswithjava.part03.section02;


//https://cloudstudying.kr/lectures/322
//트리(tree) :: 여러 노드들이 부모와 자식 관계를 갖는 자료구조이다. 나무가 가지를 쳐가는 모습과 닮았다고 하여 트리(tree)라 명명되었다. 

// 트리는 계층적 관계(hierachical relationship)를 구조화 하기 좋다. 
// 트리는 수많은 분야에서 사용된다. 대표적인 예로 컴퓨터의 파일 시스템, 인공지능의 의사결정모델등에 사용된다. 

// 최상위 노드를 루트(root)라고 하며, 한 노드가 하위 노드를 가질 때, 부모(parent)와 자식(child) 관계가 형성된다. 
// 자식이 없는 노드는 리프(leaf) 노드라고 한다. 노드와 노드를 연결하는 선은 간선(edge)라 한다. 



// 이진 트리란? : 자식을 최대 2개까지 가지는 트리


//이진트리(binary tree) 만들기
//https://cloudstudying.kr/challenges/278

//	출력 예
//	preorder: 11 22 44 55 33 66 77

public class MyBinaryTreeTest {
  public static void main(String[] args) {
    // 트리 생성
    MyTree01 tree1 = new MyTree01(11, null, null);
    MyTree01 tree2 = new MyTree01(22, null, null);
    MyTree01 tree3 = new MyTree01(33, null, null);
    MyTree01 tree4 = new MyTree01(44, null, null);
    MyTree01 tree5 = new MyTree01(55, null, null);
    MyTree01 tree6 = new MyTree01(66, null, null);
    MyTree01 tree7 = new MyTree01(77, null, null);
    
    // 트리 조합
    tree1.setLeftSubtree(tree2);
    tree1.setRightSubtree(tree3);

    /* 나머지 트리를 조합하여 트리를 완성하시오. */
    tree2.setLeftSubtree(tree4);
    tree2.setRightSubtree(tree5);
    
    tree3.setLeftSubtree(tree6);
    tree3.setRightSubtree(tree7);
    
    // 트리 순회
    tree1.printPreorder();
  }
}

class MyTree01 {
  // 최상위 노드
  private TreeNode root;

  // 생성자
  public MyTree01(int data, MyTree01 leftSubtree, MyTree01 rightSubtree) {
    // 루트 노드 생성
    this.root = new TreeNode(data, null, null);
 
    // 서브 트리 연결
    root.leftChild = (leftSubtree == null) ? null : leftSubtree.root;
    root.rightChild = (rightSubtree == null) ? null : rightSubtree.root;
  }

  public void setLeftSubtree(MyTree01 subtree) {
    root.leftChild = subtree.root;
  }

  public void setRightSubtree(MyTree01 subtree) {
    root.rightChild = subtree.root;
  }
  
  // 전위 순회
  public void printPreorder() {
    System.out.print("preorder: ");
    _preorder(root); // 재귀 호출
    System.out.println();
  }
  
  private void _preorder(TreeNode parent) {		//재귀 함수
    if (parent == null) {
      return;
    }

    System.out.printf("%d ", parent.data);
    _preorder(parent.leftChild);
    _preorder(parent.rightChild);
  }
  
}


class TreeNode {
  int data; // 데이터
  TreeNode leftChild; // 왼쪽 자식 노드
  TreeNode rightChild; // 오른쪽 자식 노드
 
  public TreeNode(int data, TreeNode leftChild, TreeNode rightChild) {
    this.data = data;
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }
}
