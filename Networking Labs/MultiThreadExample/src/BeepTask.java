import java.awt.*;

public class BeepTask implements Runnable{
    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        for(int x = 0; x < 5; x++){
            System.out.println(Thread.currentThread());
            toolkit.beep();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
