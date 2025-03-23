import java.util.InputMismatchException;
import java.util.Scanner;

public class Converter {
    public static void main(String [] args){

        //Variables
        double tempIn, tempOut;
        Scanner scan = new Scanner(System.in);
        int input = 0;
        boolean test1 = false;
        boolean check2 = false;

        //Get Conversion from User
        System.out.println("Press 1 for Fahrenheit to Celsius");
        System.out.println("Press 2 for Celsius to Fahrenheit");

        //check for correct inputs
        while(!test1){
            if(scan.hasNextInt()){
                input = scan.nextInt();

                if(input == 1 || input == 2){
                    test1 = true;
                }else{
                    System.out.println("Invalid Input");
                    String trash = scan.nextLine();
                }

            }else{
                System.out.println("Invalid Input");
                String trash = scan.nextLine();
            }
        }


        //get Temperature from User
        System.out.println("Insert Temperature to Convert");
        tempIn = scan.nextDouble();

        //check for correct conversion
        if(input == 1){
            tempOut = (tempIn - 32) * 5/9;
            System.out.println("Temperature in Celsius: " + tempOut);

        } else if (input == 2){
            tempOut = (tempIn * 9/5) + 32;
            System.out.println("Temperature in Fahrenheit: " + tempOut);
        }
    }
}
