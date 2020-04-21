package dswithjava.part03.section02;


//https://cloudstudying.kr/lectures/322
//Ʈ��(tree) :: ���� ������ �θ�� �ڽ� ���踦 ���� �ڷᱸ���̴�. ������ ������ �İ��� ����� ��Ҵٰ� �Ͽ� Ʈ��(tree)�� ���Ǿ���. 

// Ʈ���� ������ ����(hierachical relationship)�� ����ȭ �ϱ� ����. 
// Ʈ���� ������ �о߿��� ���ȴ�. ��ǥ���� ���� ��ǻ���� ���� �ý���, �ΰ������� �ǻ�����𵨵 ���ȴ�. 

// �ֻ��� ��带 ��Ʈ(root)��� �ϸ�, �� ��尡 ���� ��带 ���� ��, �θ�(parent)�� �ڽ�(child) ���谡 �����ȴ�. 
// �ڽ��� ���� ���� ����(leaf) ����� �Ѵ�. ���� ��带 �����ϴ� ���� ����(edge)�� �Ѵ�. 



// ���� Ʈ����? : �ڽ��� �ִ� 2������ ������ Ʈ��


//����Ʈ��(binary tree) �����
//https://cloudstudying.kr/challenges/278

//	��� ��
//	preorder: 11 22 44 55 33 66 77

public class MyBinaryTreeTest {
  public static void main(String[] args) {
    // Ʈ�� ����
    MyTree01 tree1 = new MyTree01(11, null, null);
    MyTree01 tree2 = new MyTree01(22, null, null);
    MyTree01 tree3 = new MyTree01(33, null, null);
    MyTree01 tree4 = new MyTree01(44, null, null);
    MyTree01 tree5 = new MyTree01(55, null, null);
    MyTree01 tree6 = new MyTree01(66, null, null);
    MyTree01 tree7 = new MyTree01(77, null, null);
    
    // Ʈ�� ����
    tree1.setLeftSubtree(tree2);
    tree1.setRightSubtree(tree3);

    /* ������ Ʈ���� �����Ͽ� Ʈ���� �ϼ��Ͻÿ�. */
    tree2.setLeftSubtree(tree4);
    tree2.setRightSubtree(tree5);
    
    tree3.setLeftSubtree(tree6);
    tree3.setRightSubtree(tree7);
    
    // Ʈ�� ��ȸ
    tree1.printPreorder();
  }
}

class MyTree01 {
  // �ֻ��� ���
  private TreeNode root;

  // ������
  public MyTree01(int data, MyTree01 leftSubtree, MyTree01 rightSubtree) {
    // ��Ʈ ��� ����
    this.root = new TreeNode(data, null, null);
 
    // ���� Ʈ�� ����
    root.leftChild = (leftSubtree == null) ? null : leftSubtree.root;
    root.rightChild = (rightSubtree == null) ? null : rightSubtree.root;
  }

  public void setLeftSubtree(MyTree01 subtree) {
    root.leftChild = subtree.root;
  }

  public void setRightSubtree(MyTree01 subtree) {
    root.rightChild = subtree.root;
  }
  
  // ���� ��ȸ
  public void printPreorder() {
    System.out.print("preorder: ");
    _preorder(root); // ��� ȣ��
    System.out.println();
  }
  
  private void _preorder(TreeNode parent) {		//��� �Լ�
    if (parent == null) {
      return;
    }

    System.out.printf("%d ", parent.data);
    _preorder(parent.leftChild);
    _preorder(parent.rightChild);
  }
  
}


class TreeNode {
  int data; // ������
  TreeNode leftChild; // ���� �ڽ� ���
  TreeNode rightChild; // ������ �ڽ� ���
 
  public TreeNode(int data, TreeNode leftChild, TreeNode rightChild) {
    this.data = data;
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }
}
