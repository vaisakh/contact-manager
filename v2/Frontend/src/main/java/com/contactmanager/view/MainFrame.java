package com.contactmanager.view;

import com.contactmanager.controller.ContactController;
import com.contactmanager.controller.GroupController;
import com.contactmanager.entity.Group;

import javax.swing.*;

/**
 * @author vaisakhvm
 */
public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane;
    public MainFrame() {
        super("Contact Manager GUI");

        tabbedPane = new JTabbedPane();


        ContactForm contactForm = new ContactForm();
        ContactDetails contactDetails = new ContactDetails();
        new ContactController(contactForm, contactDetails);
        contactForm.viewContacts(e -> tabbedPane.setSelectedIndex(1));

        GroupForm groupForm = new GroupForm();
        GroupDetails groupDetails = new GroupDetails();
        new GroupController(groupForm, groupDetails);
        groupForm.viewGroups(e -> tabbedPane.setSelectedIndex(3));


        tabbedPane.add(contactForm, "Add Contact");
        tabbedPane.add(contactDetails, "List Contact");
        tabbedPane.add(groupForm, "Add Group");
        tabbedPane.add(groupDetails, "List Group");

        add(tabbedPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,400);
        setVisible(true);
    }
}
