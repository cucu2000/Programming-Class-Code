import java.util.Scanner;

public class UI {
    //field
    static Scanner scan = new Scanner(System.in);

    //method
    void showMenu(){
        System.out.print("Menu Price: ");
        int menuPrice = scan.nextInt();

        System.out.print("Quantity: ");
        int quantity = scan.nextInt();

        handKit hk1 =  new handKit(menuPrice, quantity);

        System.out.println("Food price is: $" + hk1.getTotalPrice());


    }
}
