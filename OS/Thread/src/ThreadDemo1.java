public class ThreadDemo1 {
    public static void main(String args[]) {

        ThreadTest T1 = new ThreadTest("Thread-1", 5);
        T1.start();

        ThreadTest T2 = new ThreadTest("Thread-2", 10);
        T2.start();
    }
}