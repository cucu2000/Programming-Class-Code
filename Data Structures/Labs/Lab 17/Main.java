import java.util.Arrays;

public class Main {
    public static void main(String [] args){
            System.out.println("Create an empty list.");
            ListInterface<String> myList = new LList<String>();
            System.out.println("List should be empty; isEmpty returns " +
                    myList.isEmpty() + ".");
            System.out.println("\nTesting add to end:");
            myList.add("15");
            myList.add("25");
            myList.add("35");
            myList.add("45");

            //add 55 remove position 1
            myList.add("55");
            myList.remove(1);

            System.out.println("List should contain 25 35 45 55.");
            displayList(myList);
            System.out.println("List should not be empty; isEmpty() returns " +
                    myList.isEmpty() + ".");
            System.out.println("\nTesting clear():");
            myList.clear();
            System.out.println("List should be empty; isEmpty returns " +
                    myList.isEmpty() + ".");
        } // end main

    private static void displayList(ListInterface<String> myList) {
        System.out.println( Arrays.toString(myList.toArray()));
    }
}

