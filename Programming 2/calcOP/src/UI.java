import java.util.Scanner;

public class UI {
    static Scanner scan = new Scanner(System.in);

    public void showMenu(){
        System.out.print("input1: ");
        int opr1 = scan.nextInt();
        System.out.print("input2: ");
        int opr2 = scan.nextInt();
        System.out.print("operator: ");
        char operator = scan.next().charAt(0);

        Calculator c1 = new Calculator(opr1, opr2, operator);
       int result = c1.calculate();
       System.out.println("Your result is: " + result);
    }
}
