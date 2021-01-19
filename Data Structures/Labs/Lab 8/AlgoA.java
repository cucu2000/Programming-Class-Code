public class AlgoA {
    public static void main(String [] args){
        long sum = 0, n = 100000;
        for (long i = 1; i <= n; i++){
            sum = sum + i;
        }
        System.out.println("The value of the first " + n + " numbers is: " + sum);
    }
}
