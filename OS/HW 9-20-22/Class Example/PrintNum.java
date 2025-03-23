public class PrintNum implements Runnable {

    //variables
    private int lastNum;

    //methods
    PrintNum(int n){
        lastNum = n;
    }

    @Override
    public void run() {
        for(int x = 1; x <= lastNum; x++){
            System.out.print(x + " ");
        }
    }
}
