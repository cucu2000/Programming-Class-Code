public class testVar {

    //fields
    Employee emp = new Employee(); //instance var = non-static field variable

    String str; //instance var = non-static field variable

    int i; //class variable = static field variable

    long L1;

    double d1;

    float f1;

    char c1;

    boolean b1;

    String str1 = "abc";
    char data [] = {'a', 'b', 'c'};

    String str2 = new String(data);

    //methods
    void getI(int j){      //parameter variable
        int k = 0;         //local variable, needs to be initialized

        System.out.println(k);

        //Identifiers can be named with the alphabet, numbers (Cannot start a variable), and the characters _ and $

        //range for byte -128 - 127 = -2^7 - 2^7 - 1

        //range for int -2^31 - 2^31 - 1

        //default byte, short, int,  long, float, double, char, boolean
        //byte, short, int,  long, float = 0
        //double, float = 0.0(d) , 0.0(f); () may or may not be needed
        //char = \u0000 = null char
        //boolean = false

        long l2 = 0;
        System.out.println(l2);
    }
    //constructor
}
