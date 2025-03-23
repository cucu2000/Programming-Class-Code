import java.util.Scanner;

public class Numbers {

   static int [] numbers = new int [11];

    public static void main(String [] args){

        //variables

        Scanner scan = new Scanner(System.in);

        //Have user input 11 numbers
        for(int x  = 0; x < numbers.length; x++){
            System.out.println("Enter Number " + (x+1));
            numbers[x] = scan.nextInt();
        }

        System.out.println("Sum of first ten numbers divided by the 11th: " + calculate());
    }

    public static int calculate(){
        int total = 0;

        for(int x = 0; x < numbers.length-1; x++){
            total += numbers[x];
        }

        System.out.println("Total of first 10 numbers: " + total);
        total /= numbers[10];
        return total;
    }
}
