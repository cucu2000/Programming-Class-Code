//Author: Kaleb Cosgrave

public class fibModel{

    public static  int fibonacci(int n){
        int result = 0;

        if(n <=4){
            result = 1;

        }else{
            result = fibonacci(n / 2) + fibonacci(n / 4);
        }

        return result;
    }

    public static void main(String [] args){

        int fibvalue, n = 100;

        fibvalue = fibonacci(n);

        System.out.println("The Fib Model  of " + n + " is: " + fibvalue);
    }
}
