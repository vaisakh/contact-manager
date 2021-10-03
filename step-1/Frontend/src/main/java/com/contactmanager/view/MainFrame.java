package com.contactmanager.view;

import com.contactmanager.controller.ContactController;

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

        tabbedPane.add(contactForm, "Add Contact");
        tabbedPane.add(contactDetails, "List Contact");

        add(tabbedPane);

        contactForm.viewContacts(e -> tabbedPane.setSelectedIndex(1));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,400);
        setVisible(true);
    }
}
