//Author: Kaleb Cosgrave

public class SlowSortAlgorithm{
    public static void main(String [] args){

        //generate variables
        int [] myArray = new int [100];
        int sum = 0;
        double average = 0;

        //set array with random variables
        for(int x = 0; x < myArray.length; x++){
            myArray [x] = (int) ( Math.random()*100);
        }

         System.out.println( "The contents of the non-sorted  Array is ");

         //print array
        for(int x = 0; x < myArray.length; x++){

            System.out.print(myArray[x] + " ");
        }

        System.out.println("");

        // One by one move boundary of unsorted subarray
        int n = myArray.length;

        for(int i = 0; i < n-1; i++){

        // Find the minimum element in unsorted array
        int min_idx = i;
        for (int j = i+1; j < n; j++){
            if (myArray[j] < myArray[min_idx]){
                min_idx = j;
            }
        }

        // Swap the found minimum element with the first
        // element
        int temp = myArray[min_idx];
        myArray[min_idx] = myArray[i];
        myArray[i] = temp;
        }

System.out.println( "The contents of the sorted  Array is ");

//print array
for(int x = 0; x < myArray.length; x++){
    System.out.print(myArray[x] + " ");
}


        /*      for(int x = 0; x < myArray.length; x++){
            sum += myArray[x];
            average = sum / myArray.length;

        }

        System.out.println("");

        }


            for(int x = 0; x < myArray.length; x++){
            sum += myArray[x];
            average = sum / myArray.length;

        }

        System.out.println("");
        System.out.println("Sum is : " + sum);
        System.out.println("Average is : " + average);
*/

    }
}
