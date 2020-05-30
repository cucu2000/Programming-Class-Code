import java.util.Scanner;
import java.util.Random;
public class guessNum {

    static Scanner scan = new Scanner(System.in);

    public static void main(String [] args){
        //print game rules
        System.out.println("");
        System.out.println("Game Rules");
        System.out.println("=============");
        System.out.println("");

        //while for invalid case
        int w1 = 0;  //flag variable
        while(w1==0) {
            //option menu 1 or 2, and invalid
            System.out.println("Menu: 1 for play; 2 for exit");
            System.out.print("Enter your option: ");

            String option = scan.nextLine();

            //option 1: Play game
            if(option.equals("1")) {
                w1 = 999;

                //option2: Terminate
            }else if(option.equals("2")){
                System.exit(0);
            }else{
                System.out.println("Input is invalid");
            }

            System.out.println("");
        }

        //random number generation
        Random rand = new Random();
            int randomN = rand.nextInt(20) + 1;

        //while for valid gnr
        int w2 = 0;
        int count = 0;
        while(w2 == 0) {
            count++;

            //guess menu gnr or quit
            System.out.print("Enter your guess or press q to exit: ");

            String option = scan.nextLine();

            //quit
            if(option.equals("q")) {
                System.out.println("You exited the game: You took " + count + " attempts: The number was " + randomN);
                System.exit(0);

            }else {
                //gnr
                //gnr str > int
                int gnr = Integer.parseInt(option);

                //condition check {1,20}
                if (gnr >= 1 && gnr <= 20) {
                    //test r vs g
                    if (gnr > randomN) {
                        System.out.println("Your guess is too high");

                    } else if (gnr < randomN) {
                        System.out.println("Your guess is too low");

                    } else {
                        System.out.println("You got it! It took you " + count + " attempts");
                        System.exit(0);
                    }

                }else{
                    System.out.println("Number must be [1,20]");
                    System.out.println("");
                }
            }
        }
    }
}
