//Author: Kaleb Cosgrave

public class MyArray{

  static void Insertionsort(int arr[])
  {
      int n = arr.length;
      for (int i=1; i<n; ++i)
      {
          int key = arr[i];
          int j = i-1;

          /* Move elements of arr[0..i-1], that are
             greater than key, to one position ahead
             of their current position */
          while (j>=0 && arr[j] > key)
          {
              arr[j+1] = arr[j];
              j = j-1;
          }
          arr[j+1] = key;
      }
  }

  static void SelectionSort(int arr[])
  {
      int n = arr.length;

      // One by one move boundary of unsorted subarray
      for (int i = 0; i < n-1; i++)
      {
          // Find the minimum element in unsorted array
          int min_idx = i;
          for (int j = i+1; j < n; j++)
              if (arr[j] < arr[min_idx])
                  min_idx = j;

          // Swap the found minimum element with the first
          // element
          int temp = arr[min_idx];
          arr[min_idx] = arr[i];
          arr[i] = temp;
      }
  }

  public static void shellSort(int[] array) {
    int inner, outer;
    int temp;

    int h = 1;
    while (h <= array.length / 3) {
      h = h * 3 + 1;
    }
    while (h > 0) {
      for (outer = h; outer < array.length; outer++) {
        temp = array[outer];
        inner = outer;

        while (inner > h - 1 && array[inner - h] >= temp) {
          array[inner] = array[inner - h];
          inner -= h;
        }
        array[inner] = temp;
      }
      h = (h - 1) / 3;
    }
  }

/* A utility function to print array of size n*/
  static void printArray(int arr[])
  {
      int n = arr.length;
      for (int i=0; i<n; ++i)
          System.out.print(arr[i] + " ");

      System.out.println();
  }

    public static void main(String [] args){

        //generate variables
        int [] myArray = new int [10];
        int sum = 0;
        double average = 0;

        //set array with random variables
        for(int x = 0; x < myArray.length; x++){
            myArray [x] = (int) ( Math.random()*100);
        }

        System.out.println( "The contents of the Array is ");
          printArray(myArray);

          System.out.println( "Insertion Sort");
          Insertionsort(myArray);
          printArray(myArray);

          System.out.println( "Selection Sort");
          SelectionSort(myArray);
          printArray(myArray);

          System.out.println( "Shell Sort");
          shellSort(myArray);
          printArray(myArray);
    }
}
