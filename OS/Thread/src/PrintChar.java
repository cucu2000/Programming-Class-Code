public class PrintChar implements Runnable{

    //variables
    private char charToPrint;
    private int times;

    //methods
    PrintChar(char c, int num){
        charToPrint = c;
        times = num;
    }

    @Override
    public void run() {
        for(int x = 0; x < times; x++){
            System.out.print(charToPrint + " ");
        }
    }
}
