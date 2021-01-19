//Author: Kaleb Cosgrave

public class MyArray{
    public static void main(String [] args){

        //generate variables
        int [] myArray = new int [100];
        int sum = 0;
        double average = 0;

        //set array with random variables
        for(int x = 0; x < myArray.length; x++){
            myArray [x] = (int) ( Math.random()*100);
        }

         System.out.println( "The contents of the Array is ");
        //print array
        for(int x = 0; x < myArray.length; x++){
            System.out.print(myArray[x] + " ");
        }

        for(int x = 0; x < myArray.length; x++){
            sum += myArray[x];
            average = sum / myArray.length;

        }

        System.out.println("");
        System.out.println("Sum is : " + sum);
        System.out.println("Average is : " + average);

    }
}
