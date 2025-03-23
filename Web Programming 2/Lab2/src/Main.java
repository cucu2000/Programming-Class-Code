import java.util.Enumeration;
import java.util.Vector;

public class Main {
    public static void main(String [] args){

        Vector v = new Vector(3, 3);
        System.out.println(v.capacity());

        v.add(5);
        v.add("Five");
        v.add(true);
        v.add(3.15);

        System.out.println(v.capacity());

        Enumeration e = v.elements();
        while(e.hasMoreElements()){
            System.out.println(e.nextElement());
        }

        v.removeElement(5);

        Enumeration e2 = v.elements();
        while(e2.hasMoreElements()){
            System.out.println(e2.nextElement());
        }

    }
}
