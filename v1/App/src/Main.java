import entity.ContactEntity;
import entity.GroupEntity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main implements ActionListener {
    public static void main(String[] args) {

        drawUI();

        ArrayList<ContactEntity> contactList = ContactManagerFacade.getContacts();
        System.out.println(contactList);

        for(int i = 0; i < contactList.size(); i++) {
            System.out.println(contactList.get(i).getContactId());
            System.out.println(contactList.get(i).getContactName());
            System.out.println(contactList.get(i).getContactPhone());
            System.out.println(contactList.get(i).getContactAddr1());
            System.out.println(contactList.get(i).getContactAddr2());
            System.out.println(contactList.get(i).getContactAddr3());
            System.out.println(contactList.get(i).getContactPin());
            System.out.println(contactList.get(i).getGroupId());

            System.out.println("------------------------------------------");
        }
    }

    public static void drawUI() {
        // Create the main fame window for the application.
        JFrame frame = new JFrame("Contact Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a tabbed pane containing two tabs.
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Contacts", drawAddContactListUI());
        tabbedPane.add("Add Contact", drawAddContactUI());
        tabbedPane.add("Add Group", drawAddGroupUI());

        // Display the frame window.
        frame.getContentPane().add(tabbedPane);
        frame.setSize(500, 430);
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

    private static JPanel drawAddContactListUI() {
        ContactListForm contactListForm = new ContactListForm();
        return contactListForm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: Not required???
    }
}
