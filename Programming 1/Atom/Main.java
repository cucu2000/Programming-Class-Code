import java.util.*;

public class Main {
  static Scanner scan = new Scanner(System.in);


  public static void main(String[] args){

    String input1 = "";
    String inputFinal = "";
    Guess number = new Guess();
    Guess scoreF = new Guess();

    do{

      int randomNumber = number.generateRandomNumber();
      int pickedNumber = readInput();
      int offNumber = getOffNumber(pickedNumber, randomNumber);
      scoreF.compare(offNumber);
      scoreF.getFinal();
    System.out.println("You picked " + pickedNumber);
    System.out.println("The number was " + randomNumber);
    System.out.println("You were " + offNumber + " off");
    System.out.println("Your score is " + scoreF.getFinal());


    do{
       System.out.print("Would you like to play again?");
      input1 = scan.next();
     if(input1.equalsIgnoreCase("yes")){
      inputFinal = "Yes";
     }else if(input1.equalsIgnoreCase("No")){
      inputFinal = "No";
     }else{
        System.out.println("Must be yes or no");
        String garbage2 = input1;
     }

    }while((!inputFinal.equalsIgnoreCase("yes")) && (!inputFinal.equalsIgnoreCase("no")));


   }while(inputFinal.equalsIgnoreCase("yes"));
    System.out.println("Your final score is " + scoreF.getFinal());
  }

  private static int readInput(){
     System.out.println("Pick a number between 1 - 100");
     while(!scan.hasNextInt()){
      System.out.println("Must be a number in between 0 and 100");
      String garbage = scan.next();
       }
    int pickedNumber = scan.nextInt();
    return pickedNumber;
  }
  public static int getOffNumber(int _guess, int _random){
    int offNumber = Math.abs(_guess - _random);
    return offNumber;
  }
}
