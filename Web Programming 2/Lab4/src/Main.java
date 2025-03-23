public class Main {
    public static void main(String[] args) {
        //Activation 1
        innerClassEx out = new innerClassEx();
        innerClassEx.InnerMember in = out.new InnerMember();
        in.printInner();

        //activation 2
        innerClassEx.InnerMember in2 = new innerClassEx().new InnerMember();
        in2.printInner();

        out.ntPrint();
        in.tapNt();


        innerClassEx.StaticClass staticClass = new innerClassEx.StaticClass();
        staticClass.printInner();

        out.aClass.prnt();

        System.out.println("Generic Class");
        genericClass<String> gc1 = new genericClass<String>();
        gc1.setVar("Hello World");
        System.out.println(gc1.getVar());

        genericClass<Double> gc2 = new genericClass<Double>();
        gc2.setVar(5.5);
        System.out.println(gc2.getVar());


    }
}
