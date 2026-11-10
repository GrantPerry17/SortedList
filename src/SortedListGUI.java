
import javax.swing.*;
import java.awt.*;

public class SortedListGUI extends JFrame {

    private SortedList sortedList;

    private JTextField addTextField;
    private JTextField searchTextField;
    private JTextArea displayArea;

    private JButton addButton;
    private JButton searchButton;

    public SortedListGUI() {

        sortedList = new SortedList();

        // Window settings
        setTitle("Sorted Array List - Binary Search");
        setSize(650, 550);
        setMinimumSize(new Dimension(500, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        // Title
        JLabel titleLabel = new JLabel("Sorted Array List");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 1, 5, 5));

        // Add section
        JPanel addPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel addLabel = new JLabel("Enter String:");
        addTextField = new JTextField(20);
        addButton = new JButton("Add");

        addPanel.add(addLabel);
        addPanel.add(addTextField);
        addPanel.add(addButton);

        // Search section
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel searchLabel = new JLabel("Search String:");
        searchTextField = new JTextField(20);
        searchButton = new JButton("Search");

        searchPanel.add(searchLabel);
        searchPanel.add(searchTextField);
        searchPanel.add(searchButton);

        inputPanel.add(addPanel);
        inputPanel.add(searchPanel);

        // Display area
        displayArea = new JTextArea(15, 45);
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );

        // Arrange components
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Button actions
        addButton.addActionListener(e -> addString());
        searchButton.addActionListener(e -> searchString());

        // Enter key actions
        addTextField.addActionListener(e -> addString());
        searchTextField.addActionListener(e -> searchString());

        // Initial display
        displayArea.append("Sorted List Application Started\n");
        displayArea.append("----------------------------------------\n");
        displayArea.append("List is currently empty.\n");
    }

    // Add a String to the sorted list
    private void addString() {

        String value = addTextField.getText().trim();

        if (value.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a String to add.",
                    "Input Required",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        sortedList.add(value);

        displayArea.append("\nAdded: " + value + "\n");

        displayList();

        addTextField.setText("");
        addTextField.requestFocus();
    }

    // Search for a String
    private void searchString() {

        String value = searchTextField.getText().trim();

        if (value.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a String to search.",
                    "Input Required",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        int result = sortedList.search(value);

        displayArea.append("\nSearch: " + value + "\n");

        if (result >= 0) {

            displayArea.append(
                    "Result: " + value
                    + " found at index " + result + ".\n"
            );

        } else {

            int insertionPosition = -1 - result;

            displayArea.append(
                    "Result: " + value
                    + " was not found.\n"
            );

            displayArea.append(
                    "It would be inserted at index "
                    + insertionPosition + ".\n"
            );
        }

        searchTextField.setText("");
        searchTextField.requestFocus();
    }

    // Display all elements in sorted order
    private void displayList() {

        displayArea.append("Current Sorted List: ");

        for (int i = 0; i < sortedList.size(); i++) {

            displayArea.append(sortedList.get(i));

            if (i < sortedList.size() - 1) {
                displayArea.append(", ");
            }
        }

        displayArea.append("\n");
        displayArea.append("----------------------------------------\n");
    }

    // Launch application
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            SortedListGUI gui = new SortedListGUI();
            gui.setVisible(true);
        });
    }
}
