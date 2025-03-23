import java.util.Scanner;

public class calculator {
  public static void main(String [] args) {
  
    int number1, number2, quotient = 0, product = 0, sum = 0, sub = 0, maximum = 0;
    long numPow = 0;
    
    Scanner scan = new Scanner(System.in);

    System.out.println("Welcome to my digital calculator");
    System.out.println("Enter 2 numbers");
    number1 = scan.nextInt();
    number2 = scan.nextInt();
    
    division div = new division();
    multiply mult = new multiply();
    add plus = new add();
    substract minus = new substract();
    power pow = new power();
    max maxClass = new max();

    sum = plus.add(number1, number2);
    sub = minus.substract(number1, number2);
    product = mult.multiply(number1, number2);
    quotient = div.division(number1, number2);
    numPow = pow.numPower(number1, number2);
    maximum = maxClass.maxNum(number1, number2);

    System.out.println("The sum of the two numbers is: " + sum);
    System.out.println("Number1 - number2 is: " + sub);
    System.out.println("The product of the two numbers is: " + product);
    System.out.println("The quotient of the two numbers is: " + quotient);
    System.out.println("Number 1 to the power of number2 is: " + numPow);
    System.out.println("The max of the 2 numbers is: " + maximum);
  }
}
