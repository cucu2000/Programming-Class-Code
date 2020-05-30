package sample;

import java.util.Random;

public class Guess {
    private int numberOfGuesses;
    private int randomNumber;


    public Guess(){
        generateRandomNumber();
        numberOfGuesses = 0;
    }

    public int generateRandomNumber(){
        Random rand = new Random();
        this.randomNumber = rand.nextInt(100 + 1);
        return this.randomNumber;
    }

    public String compare(int guessedNumber){
        this.numberOfGuesses++;

        if (guessedNumber <this.randomNumber){
            return ("HIGHER");
        }else if(guessedNumber >this.randomNumber){
            return ("LOWER");
        }else{
            return("YOU GUESSED IT");
        }
    }

    public int getNumberOfGuesses() {
        return this.numberOfGuesses;
    }
}
