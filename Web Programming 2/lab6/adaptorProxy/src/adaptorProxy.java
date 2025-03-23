public class adaptorProxy {
    public static void main(String [] args){

        Adaptor adaptor = new Adaptor();
        double num = 3.6;

        //Double
        System.out.println("Output Math: " + mathOne.dblNum(num));
        System.out.println("Output Math: " + mathOne.dblNum((float)num));

        //Float
        System.out.println("Output Adaptor: " + adaptor.twiceOf((float)num));

        //Proxy
        Proxy proxy = new Proxy();
        System.out.println("Proxy Output: " + proxy.numDbl((float)num));
    }
}
