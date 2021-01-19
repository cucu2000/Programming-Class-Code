//Made by Kaleb Cosgrave

public class Fruit {
    public static void main(String [] args){
        //making array
        String [] fruit = {"Mango", "Banana", "Apple", "Kiwi", "Orange"};

        //number 3
        System.out.println("Number 3");
        for(int x = 0; x < fruit.length; x++){
            System.out.println(fruit[x]);
        }//for

        //changing objects in array
        System.out.println("");
        fruit [1] = "Grapes";
        fruit [3] = "Avocado";

        //number 5
        System.out.println("Number 5");
        for(int y = 0; y < fruit.length; y++){
            System.out.println(fruit[y]);
        }//for
    }//main
}//Fruit
