//author: Kaleb Cosgrave

public class labStack {
    public static void main(String [] args){
        int x = 5;
        int y = methodA(x);
        System.out.println("I am in Main");
    }

    public static int methodA(int a){
        int z = 2;
        methodB(z);
        System.out.println("I am in method A");
        return z;
    }

    public static void methodB(int b){
        System.out.println("I am in method B");
    }
}
