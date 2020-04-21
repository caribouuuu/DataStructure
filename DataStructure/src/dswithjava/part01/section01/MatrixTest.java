package dswithjava.part01.section01;

//행렬의 곱
//https://cloudstudying.kr/challenges/228


public class MatrixTest {
  public static void main(String[] args) {
    // 행렬 x, y의 곱을 구하여 출력
    int[][] x = { { 1, 2, 3 }, 
                  { 4, 5, 6 }, 
                  { 7, 8, 9 } };
    int[][] y = { { 1, 4, 7 }, 
                  { 2, 5, 8 }, 
                  { 3, 6, 9 } };
    int[][] z = MyMatrix.multiply(x, y);	//3*3 X 3*3 = 3*3
    MyMatrix.print(z);
    
    System.out.println();
    
    // 행렬 a, b의 곱을 구하여 출력
    int[][] a = { { 1, 1, 1 }, 
                  { 2, 2, 2 }, 
                  { 3, 3, 3 }, 
                  { 4, 4, 4 } };
    int[][] b = { { 1, 1 }, 
                  { 2, 2 }, 
                  { 3, 3 } };
    int[][] c = MyMatrix.multiply(a, b);	//4*3 X 3*2 = 4*2
    MyMatrix.print(c);
  }
}

class MyMatrix {
  /* static 메소드 multiply를 작성하시오. */
  public static int[][] multiply(int[][] x, int[][] y) {
	  
	  int[][] returnMatrix = new int[x.length][y[0].length];
	  
	  for(int i=0; i < returnMatrix.length; i++) {
		  for(int j=0; j < returnMatrix[0].length; j++) {
			  
			  for(int midNum = 0; midNum<x[0].length; midNum++) {
				  returnMatrix[i][j] += x[i][midNum] * y[midNum][j];				  
			  }
		  }
	  }
	  
    return returnMatrix;
  }
  
  public static void print(int[][] matrix) {
    int iMax = matrix.length;
    int jMax = matrix[0].length;
    
    for (int i = 0; i < iMax; i++) {
      for (int j = 0; j < jMax; j++) {
        System.out.printf("%3d ", matrix[i][j]);
      }
      System.out.println();
    }
  }
  
}
