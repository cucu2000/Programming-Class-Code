public class Thread extends java.lang.Thread {

    //Sub Thread
    @Override
    public void run(){

try{

    for (int x = 0; x < 5; x++){
        sleep(1000);
        System.out.println("Before");
    }

} catch (InterruptedException e) {
    e.printStackTrace();
}
    }

    //Main Thread
    public static void main(String [] args){

        Thread example = new Thread();
        example.start();

        try{
        for (int x = 0; x < 5; x++) {
            sleep(1000);
            System.out.println("After");
        }

        } catch (InterruptedException er){
              er.printStackTrace();
            }
        }

    }
