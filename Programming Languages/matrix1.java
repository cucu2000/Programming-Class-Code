public class matrix1{
  public static void main(String [] args){
    int [][] Matrix = new int[5][5];

    //generate random #s for Matrix
    for(int x = 0; x < Matrix.length; x++){
      for(int i = 0; i < Matrix.length; i++){
        Matrix[x][i] = (int) (Math.random() * 10 + 1);
        System.out.print(Matrix[x][i] + " ");
      }
      System.out.println();
    }
  }
}
