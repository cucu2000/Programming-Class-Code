public class Factory {

    static String name = "ABC";

    public static Product getInstance(){
        return new Product(name);
    }
}
