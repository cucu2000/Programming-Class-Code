import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String [] args){

        //initialize piggy bank
        piggyBank bank1 = new piggyBank();

        //Ask for deposit amount
        System.out.println("Enter your deposit amount");
        while(!scan.hasNextInt()){
            System.out.println("Input must be a number");
        }

        //set deposit amount
        float deposit1 = scan.nextInt();

        bank1.Deposit(10);

        //run deposit in piggy bank
        bank1.Deposit(deposit1);

        //print out balance
        bank1.getBalance();

    }
}
