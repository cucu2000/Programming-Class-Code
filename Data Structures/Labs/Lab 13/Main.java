public class Main {
    public static void main(String [] args) {
        WaitLine wl = new WaitLine();

        wl.simulate(10, 100, 10);

        wl.displayResults();
    }
}
