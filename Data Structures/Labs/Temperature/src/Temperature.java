import java.io.*;
import java.util.*;

public class Temperature {

    public static final int DAYS_PER_WEEK = 7;

    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        double[] temperature = new
                double[DAYS_PER_WEEK];

        System.out.println("Enter " + DAYS_PER_WEEK + " temperatures:");
        double sum = 0;
        for(int index = 0; index < DAYS_PER_WEEK; index++) {
            temperature[index] = keyboard.nextDouble();
            sum = sum + temperature[index];
        }//end for

        double average = sum / DAYS_PER_WEEK;

        System.out.println("The average temperature is " +
                average);
        System.out.println("The temperatures are");

        for(int index = 0; index <DAYS_PER_WEEK; index++) {
            if(temperature[index] < average)
                System.out.println(temperature[index] + " below average.");
            else if(temperature[index] > average )
                System.out.println(temperature[index] + " above average.");
            else // temperature[index] = average
                System.out.println(temperature[index] + " average.");
        }
    }
}