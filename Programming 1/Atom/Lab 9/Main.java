import java.util.Scanner;
public class Main{
  static Scanner scan = new Scanner(System.in);
  public static void main(String [] args){

    Person pers = new Person();
    System.out.println("Enter your name");
     String name = scan.next();
    System.out.println("Enter your email");
      String email = scan.next();

    pers.setName(name);
    pers.setEmail(email);
    pers.printInfo();

    Person Kyle = new Person("Kyle", "Kyle.yahoo.com");
    Kyle.printInfo();

    Student Gerome = new Student("Gerome", "GeromeH@yahoo.com", "Physics", 3);
    Gerome.printInfo();

    Professor Jeff = new Professor("Jeff", "Jeffmaxwwell@hotmail.com", "BA Comp. Sci.", "OSU", 1993);
    Jeff.printInfo();
  }
}
