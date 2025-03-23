public class TaskThreadDemo {
    public static void main(String [] args){

        System.out.println("Create Tasks");
        Runnable printA = new PrintChar('a', 10);
        Runnable printB = new PrintChar('b', 10);
        Runnable print20 = new PrintNum(20);
        Runnable printC = new PrintChar('c', 10);

        System.out.println("Creating Threads");
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print20);
        Thread thread4 = new Thread(printC);

        System.out.println("Starting Threads");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
