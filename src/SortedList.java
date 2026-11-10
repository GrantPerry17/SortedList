
import java.util.ArrayList;

public class SortedList {

    private ArrayList<String> elements;

    // Constructor
    public SortedList() {
        elements = new ArrayList<>();
    }

    // Uses binary search to find the correct insertion position
    private int binarySearch(String value) {
        int low = 0;
        int high = elements.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int comparison = elements.get(mid).compareTo(value);

            if (comparison < 0) {
                low = mid + 1;
            } else if (comparison > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return low;
    }

    // Adds a String while maintaining sorted order
    public void add(String value) {
        int position = binarySearch(value);
        elements.add(position, value);
    }

    // Searches for a String
    // Returns its index if found, otherwise its insertion position
    public int search(String value) {
        int position = binarySearch(value);

        if (position < elements.size()
                && elements.get(position).equals(value)) {
            return position;
        }

        return -1 - position;
    }

    // Returns the number of elements
    public int size() {
        return elements.size();
    }

    // Returns the element at a specified index
    public String get(int index) {
        return elements.get(index);
    }

    // Returns the list as a String
    @Override
    public String toString() {
        return elements.toString();
    }
}
