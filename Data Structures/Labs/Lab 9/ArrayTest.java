public class ArrayTest {
    public static void main(String [] args){
        String myName = "Kaleb Cosgrave";
        int [] myArray = {89, 78, 93, 95, 85};
        int sum1 = 0;
        int sum2 = 0;

        myArray[2] = 97;
        myArray[4] = 100;

        System.out.println("Hello " + myName);

        for( int x = 0; x < myArray.length; x++){
            System.out.println(myArray[x] + " ");
        }

        for(int y = 0; y < myArray.length; y++){
            sum1 += myArray[y];
        }

        for(int z = 0; z <= 2; z++){
            sum2 += myArray[z];
        }

        System.out.println("The average of the array is: " + sum1/myArray.length);
        System.out.println("The average of the first 3 students is: " + sum2/3);
        System.out.println("Thank you " + myName);


    }
}
