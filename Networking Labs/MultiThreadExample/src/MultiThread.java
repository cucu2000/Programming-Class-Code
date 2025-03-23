import javax.tools.Tool;
import java.awt.*;

public class MultiThread {

    public static void main(String[] args) {


        BeepTask beep = new BeepTask();
        Thread thread = new Thread(beep);
        thread.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < 5; x++) {
                    System.out.println(Thread.currentThread());
                    Toolkit toolkit = Toolkit.getDefaultToolkit();
                    toolkit.beep();

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread2.start();

        Thread thread3 = new Thread(() -> {
            for (int x = 0; x < 5; x++) {
                System.out.println(Thread.currentThread());
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                toolkit.beep();

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread3.start();

        for (int x = 0; x < 5; x++) {
            System.out.println(Thread.currentThread());
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            toolkit.beep();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
