package com.contactmanager.controller;

import com.contactmanager.view.ContactForm;

import javax.swing.*;

/**
 * @author vaisakhvm
 */
public class ContactController {
    private ContactForm form;

    public ContactController(ContactForm contactForm) {
        this.form = contactForm;

        this.form.submitContact(e -> {
            System.out.println("Contact Form Submitted.");

            String firstName = this.form.getFirstName().trim();
            String lastName = this.form.getLastName().trim();
            String phoneNumber = this.form.getPhoneNumber().trim();
            String addr1 = this.form.getAddr1().trim();
            String addr2 = this.form.getAddr2().trim();
            String addr3 = this.form.getAddr3().trim();
            String pinCode = this.form.getPinCode().trim();

            if(firstName.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "First Name Required.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if(lastName.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Last Name Required.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if(phoneNumber.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Phone Number Required.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if(addr1.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Addr1 Required", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if(addr2.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Addr2 Required", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if(addr3.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Addr3 Required", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if(pinCode.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Pin Code Required.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            this.form.reset(true);
        });
    }
}
