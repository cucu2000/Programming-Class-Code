/** A driver that uses a list to track the
 runners in a race as they cross the finish line. */
public class RoadRace {
    public static void main(String[] args) {
        recordWinners();
    } // end main
    public static void recordWinners() {
        ListInterface<String> runnerList = new AList<>();
        // runnerList has only methods in ListInterface
        runnerList.add("3");  // Winner
        runnerList.add("16"); // Second place
        runnerList.add(" 4"); // Third Place
        runnerList.add("33"); // Fourth Place
        runnerList.add("27"); // Fifth Place
        runnerList.add("51"); // Sixth Place
        displayList(runnerList);
    } // end recordWinners

    public static void displayList(ListInterface<String> list) {
        int numberOfEntries = list.getLength();
        System.out.println("The list contains " + numberOfEntries +
                " entries, as follows:");
        for (int position = 1; position <= numberOfEntries; position++)
            System.out.println(list.getEntry(position) +
                    " is entry " + position);
        System.out.println();
    } // end displayList
} // end RoadRace
