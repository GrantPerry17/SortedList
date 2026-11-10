
public class TestSortedList {

    public static void main(String[] args) {

        SortedList list = new SortedList();

        // Add elements in deliberately unsorted order
        list.add("Orange");
        list.add("Apple");
        list.add("Mango");
        list.add("Banana");
        list.add("Grape");

        // Display the sorted list
        System.out.println("Sorted List:");
        System.out.println(list);

        // Search for an existing element
        String foundItem = "Mango";
        int foundResult = list.search(foundItem);

        if (foundResult >= 0) {
            System.out.println(foundItem + " found at index: " + foundResult);
        }

        // Search for a missing element
        String missingItem = "Cherry";
        int missingResult = list.search(missingItem);

        if (missingResult < 0) {
            int insertionPosition = -1 - missingResult;

            System.out.println(missingItem
                    + " not found. It belongs at index: "
                    + insertionPosition);
        }
    }
}
