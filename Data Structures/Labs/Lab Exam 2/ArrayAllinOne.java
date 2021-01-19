import java.util.Random;

public class ArrayAllinOne{

    public static void main(String [] args){
        Random rn = new Random();
        int [] Array = new int [15];
        int min = 1;
        int max = 30;

        //input random ints to Array
        for(int x = 0; x < Array.length; x++) {
            Array [x] = (int) (Math.random() * (max - min + 1) + min);
        }

            //Beginning Array
            System.out.println("The unsorted Array is: ");
            printArray(Array);

            //SelectionSort
            System.out.println("SelectionSort: ");
            SelectionSort(Array);
            printArray(Array);

            //InsertionSort
            System.out.println("InsertionSort: ");
            InsertionSort(Array);
            printArray(Array);
    }

    static void InsertionSort(int [] Array){
        int n = Array.length;
        for (int i=1; i<n; ++i){
            int key = Array[i];
            int j = i-1;

        /* Move elements of arr[0..i-1], that are
           greater than key, to one position ahead
           of their current position */
            while (j>=0 && Array[j] > key){
                Array[j+1] = Array[j];
                j = j-1;
            }

            Array[j+1] = key;
        }
    }

    static void SelectionSort(int [] Array){
        int n = Array.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++){

            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (Array[j] < Array[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = Array[min_idx];
            Array[min_idx] = Array[i];
            Array[i] = temp;
        }
    }

    static void printArray(int [] Array){

        for(int x = 0; x < Array.length; x++){
            System.out.print(Array [x] + " ");
        }
        System.out.println(" ");
    }
}
