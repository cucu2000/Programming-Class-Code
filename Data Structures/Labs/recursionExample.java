public class Main{

  public static int factorial(int x){
    if(x == 0 || x == 1) {
      return 1;
    }else{
      return x * factorial(x - 1);
    }
  }
  public static void main(String [] args){

    System.out.println(factorial(5));
  }
}
