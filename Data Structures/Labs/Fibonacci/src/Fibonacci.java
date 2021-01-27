import java.util.Scanner;

public class Fibonacci {

   static Scanner scan = new Scanner(System.in);

    public static void main(String [] args){

        System.out.println("Input a number to return the Fibonacci Sequence up to that place. Example 6 will return 1 1 2 3 5 8");
        int number = scan.nextInt();

        System.out.println("");
        System.out.println("Fibonacci Sequence to " + number + " places is: ");

        for( int x = 1; x <= number; x++){
            System.out.println(Fibonacci(x) + " ");
        }
    }

    public static int Fibonacci(int number){
        if(number == 1 || number == 2){
            return 1;
        }else{
            return Fibonacci(number - 1) + Fibonacci(number - 2);
        }
    }
}
