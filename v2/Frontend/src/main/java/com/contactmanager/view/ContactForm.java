package com.contactmanager.view;

import com.contactmanager.entity.Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.UUID;

/**
 * @author vaisakhvm
 */
public class ContactForm extends JPanel {
    private JTextField firstNameField;
    private JTextField lastNameField;

    private JTextField phoneNumberField;

    private JTextField addr1Field;
    private JTextField addr2Field;
    private JTextField addr3Field;

    private JTextField pinCodeField;

    private JButton addButton;
    private JButton viewContactButton;

    ContactForm() {
        JLabel firstNameLabel = new JLabel("First name: ");
        JLabel lastNameLabel = new JLabel("Last name: ");

        JLabel phoneNumberLabel = new JLabel("Phone number: ");

        JLabel addr1Label = new JLabel("Address1: ");
        JLabel addr2Label = new JLabel("Address2: ");
        JLabel addr3Label = new JLabel("Address3: ");

        JLabel pinCodeLabel = new JLabel("Pin code: ");

        firstNameField = new JTextField(25);
        lastNameField = new JTextField(25);

        // TODO: NumberFormat
        phoneNumberField = new JTextField(25);

        addr1Field = new JTextField(25);
        addr2Field = new JTextField(25);
        addr3Field = new JTextField(25);

        //TODO: NumberFormat
        pinCodeField = new JTextField(25);

        addButton = new JButton("Add Contact");
        viewContactButton = new JButton("View Contacts");

        // Layout
        setLayout(new GridLayout(8,2));

        add(firstNameLabel);
        add(firstNameField);
        add(lastNameLabel);
        add(lastNameField);

        add(phoneNumberLabel);
        add(phoneNumberField);

        add(addr1Label);
        add(addr1Field);
        add(addr2Label);
        add(addr2Field);
        add(addr3Label);
        add(addr3Field);

        add(pinCodeLabel);
        add(pinCodeField);

        add(viewContactButton);
        add(addButton);
    }

    public String getFirstName() {
        return firstNameField.getText();
    }

    public String getLastName() {
        return lastNameField.getText();
    }

    public String getPhoneNumber() {
        return phoneNumberField.getText();
    }

    public String getAddr1() {
        return addr1Field.getText();
    }

    public String getAddr2() {
        return addr2Field.getText();
    }

    public String getAddr3() {
        return addr3Field.getText();
    }

    public String getPinCode() {
        return pinCodeField.getText();
    }

    public void submitContact(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }
    public void viewContacts(ActionListener actionListener) { viewContactButton.addActionListener(actionListener); }

    public Contact getEntityFromUI() {
        Contact contact = new Contact();

//        contact.setId(UUID.randomUUID());
        contact.setFirstName(getFirstName().trim());
        contact.setLastName(getLastName().trim());
        contact.setPhone(getPhoneNumber().trim());
        contact.setAddr1(getAddr1().trim());
        contact.setAddr2(getAddr2().trim());
        contact.setAddr3(getAddr3().trim());
        contact.setPin(Integer.parseInt(getPinCode().trim()));
        contact.setGroup(UUID.randomUUID());

        return contact;
    }

    public boolean validateForm() {
        if(firstNameField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "First Name Required.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if(lastNameField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Last Name Required.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if(phoneNumberField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Phone Number Required.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if(addr1Field.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Addr1 Required", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if(addr2Field.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Addr2 Required", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if(addr3Field.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Addr3 Required", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if(pinCodeField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pin Code Required.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public void reset(boolean bln) {
        if(bln) {
            firstNameField.setText("");
            lastNameField.setText("");
            phoneNumberField.setText("");
            addr1Field.setText("");
            addr2Field.setText("");
            addr3Field.setText("");
            pinCodeField.setText("");
        }
    }

}
