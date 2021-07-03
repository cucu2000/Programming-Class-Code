//Author: Kaleb Cosgrave

public class matrixMultiplication{
  public static void main(String [] args){

    //Intialize Matrix 1
    int matrix1Rows =  2;
    int matrix1Columns = 2;
    int [][] Matrix1 = new int[matrix1Rows][matrix1Columns];

    //Intialize Matrix 1
    int matrix2Rows =  2;
    int matrix2Colums = 1;
    int [][] Matrix2 = new int[matrix2Rows][matrix2Colums];

    //generate random #s for Matrix1
    System.out.println("Matrix 1:");
    for(int x = 0; x < Matrix1.length; x++){
      for(int i = 0; i < Matrix1.length; i++){
        Matrix1[x][i] = (int) (Math.random() * 10 + 1);
        System.out.print(Matrix1[x][i] + " ");
      }
      System.out.println();
    }

    System.out.println();

  //generate random #s for Matrix2
      System.out.println("Matrix 2:");
    for(int x = 0; x < matrix2Rows; x++){
      for(int i = 0; i < matrix2Colums; i++){
        Matrix2[x][i] = (int) (Math.random() * 10 + 1);
        System.out.print(Matrix2[x][i] + " ");
      }
      System.out.println();
    }

    System.out.println();

    //Intialize matrixOutput and them multiply Matrix1 and Matrix2
    int[][] matrixOutput = new int [matrix1Rows][matrix2Colums];
    matrixOutput = matrixMultiplication(Matrix1, Matrix2, matrix1Rows, matrix1Columns, matrix2Rows, matrix2Colums);

//print out matrixOutput
    System.out.println("Multiplied Matrix:");
  for(int x = 0; x < matrix1Rows; x++){
    for(int i = 0; i < matrix2Colums; i++){
      System.out.print(matrixOutput[x][i] + " ");
    }
    System.out.println();
  }
}

  public  static int[][] matrixMultiplication(int[][] m1, int[][] m2, int matrix1Rows, int matrix1Columns, int matrix2Rows, int matrix2Colums){
    //intialize matrixOutput
    int [][] matrixOutput = new int[matrix1Rows][matrix2Colums];

    //check if matrices can be multiplied. If true multiply Rows by Columns and add
    if(matrix1Columns == matrix2Rows){
        for(int x = 0; x < matrix1Rows; x++){
          for(int y = 0; y < matrix2Colums; y++){
            for(int k = 0; k < matrix1Columns; k++){
              matrixOutput[x][y] += m1[x][k] * m2[k][y];
            }
          }
        }
        //if false Program Stops
    }else{
      System.exit(-1);
    }
    //return multiplied Matrix
    return matrixOutput;
  }
}
