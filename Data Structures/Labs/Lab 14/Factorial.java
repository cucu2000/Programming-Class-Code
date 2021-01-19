
//Author: Kaleb Cosgrave

public class Factorial{

    public static  int factorial(int n){
        if(n == 1 || n == 0){
            return 1;
        }else{
            return n * factorial(n-1);
        }
    }

    public static void main(String [] args){

        int value, n = 10;

        value = factorial(n);

        System.out.println("The Factorial of " + n + " is: " + value);
    }
}
