import java.util.Scanner;

public class uI {
    //field
    Scanner scanner = new Scanner(System.in);

    //method
   public void Menu(){
        Warrior warrior = new Warrior();

        while(true){
            System.out.println("Menu----------------------------------------");
            System.out.println("F: Fist");
            System.out.println("K: Knife");
            System.out.println("S: Sword");
            System.out.println("E: Exit");

            String option = scanner.nextLine();
            System.out.println(option);

            switch (option){
                case "f": warrior.setWeapon(null); break;
                case "s": warrior.setWeapon(new Sword()); break;
                case "k": warrior.setWeapon(new Knife()); break;
                case "e":  System.exit(0);
                break;
            }
            warrior.Attack();
        }
    }
}
