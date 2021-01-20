import java.util.Arrays;
import java.util.Scanner;

public class Selection{

    static Scanner scan = new Scanner(System.in);
    static int [] toSort = new int [10];
    static int count = 0;

    public static void main(String [] args){

        setArray();

        printArray();

    }

    public static void setArray(){

        System.out.println("Input 10 numbers");

        do{
            toSort[count] = scan.nextInt();
            count ++;

        }while (toSort [toSort.length - 1] == 0);

    }

    public static int [] sortArray(int [] toSort) {

        int sortedArray [] = new int [10];

        int n = toSort.length;

        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (toSort[j] < toSort[min_idx]) {
                    min_idx = j;
                }
            }

            // Swap the found minimum element with the first
            // element
            int temp = toSort[min_idx];
            toSort[min_idx] = toSort[i];
            toSort[i] = temp;
        }

        sortedArray = toSort;
        return sortedArray;
    }

    public static void printArray(){
        System.out.println("The sorted array is : " + Arrays.toString(sortArray(toSort)));
    }
}
