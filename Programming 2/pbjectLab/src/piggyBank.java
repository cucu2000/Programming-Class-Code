public class piggyBank {

    // set field
    private float total;

    // method for depositing money
     void Deposit(float x){
        this.total = this.total + x;
    }

    // method for printing result
    void getBalance(){
         System.out.println("Your total is  $" + this.total);
    }
}
