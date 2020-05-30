public class Person {

    String name = "";

    String gender = "";

    String dateOfBirth = "";

    public void write(){
        System.out.println(name + " " + gender + " " + dateOfBirth);
    }

    public static void main(String [] args){
        Person person = new Person();
        Person person2 = new Person();
        Person person3 = new Person();

        String name[] = new String[3];

        person.name = "Kaleb";

        name[0] = person.name;

        person2.name = "Alexa";

        name[1] = person2.name;

        person3.name = "Ryan";

        name[2] = person3.name;

        for(int x = 0; x < 3; x++){
            System.out.println("name [" + x + "]: " + name[x]);
        }
    }
}
