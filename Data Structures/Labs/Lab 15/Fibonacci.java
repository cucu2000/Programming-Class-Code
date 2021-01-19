//Author: Kaleb Cosgrave

public class Fibonacci{

    public static int  fibonacci(int n){
        Integer result = 0;

        if(n == 0 || n == 1){
            result = 1;

        }else{
            result = fibonacci(n - 1) + fibonacci(n - 2);
        }

        return result;
    }

    public static void main(String [] args){
        int fibvalue, n = 8;

        fibvalue = fibonacci(n);

        System.out.println("The Fibonacci Sum of " + n + " is: " + fibvalue);
    }
}
