public class Coin {

    //variables
    private String coinName;
    private int coinValue;
    private int coinYear;

    //methods
    public void setCoinName(String coinName){
       this.coinName = coinName;
    }

    public String getCoinName(){
        return coinName;
    }

    public void setCoinValue(int coinValue){
        this.coinValue = coinValue;
    }

    public int getCoinValue(){
        return coinValue;
    }

    public void setCoinYear(int coinYear){
        this.coinYear = coinYear;
    }

    public int getCoinYear(){
        return coinYear;
    }

    //constructors
    Coin(int coinValue, int coinYear){
        this.coinYear = coinYear;
        this.coinValue = coinValue;

        if(coinValue == 1){
            coinName = "Penny";
        }else if(coinValue == 5){
            coinName = "Nickel";
        }else if(coinValue == 10){
            coinName = "Dime";
        }else if(coinValue == 25){
            coinName = "Quarter";
        }
    }
}
