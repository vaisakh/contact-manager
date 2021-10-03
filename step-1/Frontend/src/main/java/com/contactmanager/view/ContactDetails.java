package com.contactmanager.view;

import com.contactmanager.entity.Contact;
import com.contactmanager.model.ContactTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author vaisakhvm
 */
public class ContactDetails extends JPanel {
    private JTable contactTable;
    DefaultTableModel model;

    ContactDetails() {}

    public void viewContacts(ArrayList<Contact> contactList) {
        ContactTableModel model = new ContactTableModel(contactList);
        contactTable = new JTable(model);
        add(new JScrollPane(contactTable));
        add(contactTable);
    }
}
