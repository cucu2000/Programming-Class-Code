public class handKit {

    //field
    private int quantity;
    private int menuPrice;

    //method
    public int getTotalPrice(){
        int totalPrice = quantity * menuPrice;

        return totalPrice;
    }

    handKit(int quantity, int menuPrice){
        this.menuPrice = menuPrice;
        this.quantity = quantity;

    }

}
