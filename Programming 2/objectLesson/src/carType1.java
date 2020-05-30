public class carType1 {

    //field
    int mileage;

    //method
    public void accelerate(){
        System.out.println("Step On");
    }

    public static void main(String [] args){
        carType1 car = new carType1();

        System.out.println(car.mileage);
        car.accelerate();

    }
}
