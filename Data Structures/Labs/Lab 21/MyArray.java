public class MyArray{

  public static void main(String [] args){

          //generate variables
          int [] myArray = new int [20];

          //set array with random variables
          for(int x = 0; x < myArray.length; x++){
              myArray [x] = (int) ( Math.random()*100);
          }

          System.out.println( "The contents of the Array is ");
            printArray(myArray);
              System.out.println(" ");

          System.out.println( "The sorted Array is ");
            Insertionsort(myArray);
            printArray(myArray);
              System.out.println(" ");

          System.out.println( "The average of the Array is ");
            System.out.println(findAverage(myArray));
              System.out.println(" ");

            System.out.println("Is the average in the Array?");
              if(inArray(myArray, findAverage(myArray)) == true){
                System.out.println(findAverage(myArray) + " is in the array");
              }else{
                System.out.println(findAverage(myArray) + " is not in the array");
              }

  }

  static public void printArray(int [] Array){
    for(int x = 0; x < Array.length; x++){
      System.out.print(Array [x] + " ");
    }
      System.out.println(" ");
  }

  static void Insertionsort(int arr[]) {
      int n = arr.length;
      for (int i=1; i<n; ++i) {
          int key = arr[i];
          int j = i-1;

          /* Move elements of arr[0..i-1], that are
             greater than key, to one position ahead
             of their current position */
          while (j>=0 && arr[j] > key) {
              arr[j+1] = arr[j];
              j = j-1;
          }

          arr[j+1] = key;
      }
  }

  static public int findAverage(int [] Array){
    int sum = 0;
    int average = 0;
    for(int x = 0; x < Array.length; x++){
      sum += Array [x];
    }
    average = sum / Array.length;
      return average;
  }

  /** Searches an array for anEntry. */
  public static <T> boolean inArray(int [] anArray, int anEntry)
  {
   return search(anArray, 0, anArray.length - 1, anEntry);
  } // end inArray
  // Searches anArray[first] through anArray[last] for desiredItem.
  // first >= 0 and < anArray.length.
  // last >= 0 and < anArray.length.

  private static <T> boolean search(int [] anArray, int first, int last, int desiredItem)
  {
   boolean found;
   if (first > last)
   found = false; // No elements to search
   else if (desiredItem == (anArray[first]))
   found = true;
   else
   found = search(anArray, first + 1, last, desiredItem);

   return found;
  } // end search

}
