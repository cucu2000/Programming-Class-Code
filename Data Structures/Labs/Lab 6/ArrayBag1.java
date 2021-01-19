/**A class of bags whose entries are stored in a fixed-size array.
 INITIAL, INCOMPLETE DEFINITION; no security checks */
public final class ArrayBag1<T> implements BagInterface<T> {
    private final T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;
    /** Creates an empty bag whose initial capacity is 25. */
    public ArrayBag1() {
        this(DEFAULT_CAPACITY);
    } // end default constructor
    /** Creates an empty bag having a given initial capacity.
     @param desiredCapacity The integer capacity desired. */
    public ArrayBag1(int desiredCapacity) {
        // The cast is safe because the new array contains null entries.
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[desiredCapacity]; // Unchecked cast
        bag = tempBag;
        numberOfEntries = 0;
    } // end constructor

    @Override
    public int getCurrentSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    /** Adds a new entry to this bag.
     @param newEntry The object to be added as a new entry.
     @return True if the addition is successful, or false if not. */
    public boolean add(T newEntry) {
        boolean result = true;
        if (isArrayFull())
        {
            result = false;
        }
        else
        { // Assertion: result is true here
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        } // end if
        return result;
    } // end add

    @Override
    public T remove() {
        return null;
    }

    @Override
    public boolean remove(T anEntry) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getFrequencyOf(T anEntry) {
        return 0;
    }

    @Override
    public boolean contains(T anEntry) {
        return false;
    }

    /** Retrieves all entries that are in this bag.
     @return A newly allocated array of all the entries in this bag. */
    public T[] toArray() {
// The cast is safe because the new array
// contains null entries.
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
        for (int index = 0; index < numberOfEntries; index++)
        {
            result[index] = bag[index];
        } // end for
        return result;
    } // end toArray
    // Returns true if the array bag is full, or false if not.
    private boolean isArrayFull() {
        return numberOfEntries >= bag.length;
    } // end isArrayFull


} // end ArrayBag