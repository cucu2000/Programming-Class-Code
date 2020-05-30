import java.util.Scanner;
import java.util.Random;

public class guess {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
    //Print Game Rules(1)
        printRules();

    // If one is pressed start the game if 2 is pressed end the program (2)
        printStart();

    //Take user input and either start the game or end the game: (3)
        intialGame(getInput());

    //Play the game after getting the Random Number
        playGame(setRandomNumber());

    }

    public static void printRules() {
        System.out.println("Welcome to the guessing game");
        System.out.println("The number is in the interval [1,20]");
        System.out.println("Enter your guess");
        System.out.println("See if your guess is to high or too low");
        System.out.println("Change your guess");
        System.out.println("The computer will keep track of the number of your guess");
    }

    public static void printStart() {
        System.out.println("Press 1 to start or press 2 to exit");
    }

    public static int getInput() {
        boolean inputTest = false;
        int firstInput;

        while (inputTest = true) {
            while (!scan.hasNextInt()) {
                String garbage = scan.nextLine();
                System.out.println(garbage + " is not a number");
                System.out.println("Press 1 to start or press 2 to exit");
            }
            firstInput = scan.nextInt();
            if (firstInput == 1 || firstInput == 2) {
                inputTest = true;
                return firstInput;
            } else {
                System.out.println("Input was not 1 or 2");
            }
        }
        return 0;
    }

    public static void intialGame(int x) {
        int input = x;
        if (input == 2) {
            System.out.println("Thank you for playing");
            System.exit(0);
        } else {
            System.out.println("Game Starting");
        }
    }

    public static int setRandomNumber() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(20) + 1;
        return randomNumber;
    }

    public static void playGame(int x) {
        int count = 0;
        System.out.println("Enter your guess or press Q to exit");
        int guess;
        do {
            guess = getGameInput();
            if (guess == 100) {
                System.out.println("Thanks for playing. Your amount of guesses was " + count);
            } else {
                count++;
                if (guess < x) {
                    System.out.println("Your Guess is too low");
                } else if (guess > x) {
                    System.out.println("Your guess is too high");
                } else {
                    System.out.println("You guessed it");
                    System.out.println("It took " + count + " guesses");
                    System.exit(0);
                }
            }

        } while (guess != 100);
    }

    public static int getGameInput() {
        boolean determineInput = false;
        while (determineInput = true) {
            String testInput = scan.next();
            if (testInput.equalsIgnoreCase("q")) {
                determineInput = true;
                return 100;
            } else if (!testInput.equalsIgnoreCase("q")) {
                try {
                    int testIn = Integer.parseInt(testInput);
                    if (testIn < 1 || testIn > 20) {
                        System.out.println("Input is out of bounds [1,20]");
                    } else {
                        determineInput = true;
                        return testIn;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Input is not valid");
                    System.out.println(e.getMessage());
                }
            }
        }
        return 0;
    }
}