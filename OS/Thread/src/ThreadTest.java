class ThreadTest extends Thread {
    private Thread t;
    private String threadName;
    private int sum;
    private int number;

    ThreadTest( String name, int number){
        threadName = name;
        this.number = number;
        System.out.println("Creating " +  threadName );
    }
    public void run() {
        System.out.println("Running Thread:.. " );
        try {
            for(int i = number; i > 0; i--) {
                System.out.println(threadName + " Total = " + (sum += i));
                // Let the thread sleep for a while.
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start ()
    {
        System.out.println("Starting " +  threadName );
        if (t == null)
        {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

