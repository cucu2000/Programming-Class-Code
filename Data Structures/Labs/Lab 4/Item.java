public class Item {
    //variables
    private String itemName;
    private int    itemPrice;

    //methods
    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public String getItemName(){
        return itemName;
    }

    public void setItemPrice(int itemPrice){
        this.itemPrice = itemPrice;
    }

    public int getItemPrice(){
        return itemPrice;
    }

    @Override
    public String toString() {
        return itemName;
    }

    //constructors
    Item(){
        itemName = " ";
        itemPrice = 0;
    }

    Item(String itemName, int itemPrice){
        this.itemPrice = itemPrice;
        this.itemName = itemName;
    }
}
