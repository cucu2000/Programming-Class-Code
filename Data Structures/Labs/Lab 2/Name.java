//Author: Kaleb Cosgrave
//Topic: Creating a Class

public class Name {

    //Data Members
    private String firstName;
    private String lastName;

    //methods
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public String toString(){
        return firstName + " " + lastName;
    }

    //Constructors
    Name(){
        firstName = " ";
        lastName = " ";
    } //default constructor

    Name(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }//overloaded constructor

    //main
    public static void main(String [] args){
        Name myName = new Name("Kaleb", "Cosgrave");
        Name myFriend = new Name("Ryan", "Mitchell");
        Name secondFriend = new Name("Gabe", "Overley");
        Name thirdFriend = new Name("Alexa", "Stout");

        System.out.println("My name is " + myName.toString());
        System.out.println("My friend's name is " + myFriend.toString());
        System.out.println("My second friend's name is " + secondFriend.toString());
        System.out.println("My third friend's name is " + thirdFriend.toString());
    }
}
