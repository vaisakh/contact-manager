import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    public static void main(String[] args) {
        drawUI();
    }

    public static void drawUI() {
        // Create the main fame window for the application.
        JFrame frame = new JFrame("Contact Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a tabbed pane containing two tabs.
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Add contact", drawAddContactUI());
        tabbedPane.add("Add Group", drawAddGroupUI());

        // Display the frame window.
        frame.getContentPane().add(tabbedPane);
        frame.setSize(280, 420);
        frame.setVisible(true);
    }

    private static JPanel drawAddContactUI() {
        ContactForm contactForm = new ContactForm();
        return contactForm;
    }

    public static JPanel drawAddGroupUI() {
        GroupForm groupForm = new GroupForm();
        return groupForm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
