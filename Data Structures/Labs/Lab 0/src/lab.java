// Author: Kaleb Cosgrave
//Topic: Introduction to Java using Intellij

public class lab {

    public static void main(String [] args){
        System.out.println("Welcome to Data Structures. I am Kaleb Cosgrave.");


        int sum = 0;
        int number = 10; //Number changes based on Test

        //find the sum of the Integers up to
        for(int x = 1; x <= number; x++){
            sum = sum + x;
        }

        System.out.println("The Sum of the numbers up to " + number + " is " + sum);

        //find the factorial of number
        int fact = number;
        for(int x = 1; x < number; x++){
            fact *= (number - x);

        }

        System.out.println("The factorial of " + number + " is " + fact);
        // test sum with numbers = 10, 100, 500, 1000, 10000
        // test factorial with numbers 3, 5, 7, 8, 10

    }
}
