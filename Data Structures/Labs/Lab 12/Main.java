public class Main{
    public static void main(String [] args){
       LinkedQueue<String> lq = new LinkedQueue<>();

       lq.enqueue("Jada");
       lq.enqueue("Jess");
       lq.enqueue("Jazmin");
       lq.enqueue("Jorge");
       lq.enqueue("Jamal");
       System.out.println(lq.dequeue());
       lq.enqueue("Jerry");
       System.out.println(lq.dequeue());
       System.out.println("");

       //Queue after changes
       System.out.println("Queue After Changes");
       while(!lq.isEmpty()){
          System.out.println(lq.dequeue());
       }
    }
}