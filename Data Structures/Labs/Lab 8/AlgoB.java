public class AlgoB {
    public static void main(String[] args) {
        long n = 100000, sum;
        sum = 0;
        for (long i = 1; i <= n; i++) {
            for (long j = 1; j <= i; j++)
                sum = sum + 1;
        } // end for
        System.out.println("The value of the first " + n + " numbers is: " + sum);
    }
}
