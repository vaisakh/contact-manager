package com.contactmanager.controller;

import com.contactmanager.entity.Contact;
import com.contactmanager.service.ContactService;
import com.contactmanager.view.ContactForm;

import javax.swing.*;
import java.util.UUID;

/**
 * @author vaisakhvm
 */
public class ContactController {
    private ContactForm form;

    public ContactController(ContactForm contactForm) {
        this.form = contactForm;

        this.form.submitContact(e -> {
            System.out.println("Contact Form Submitted.");
            if(this.form.validateForm()) {
                Contact contact = this.form.getEntityFromUI();

                //TODO
                if(contact.equals(null)) {
                    JOptionPane.showMessageDialog(this.form, "Invalid Contact Entity.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                boolean result = ContactService.saveContact(contact);

                if(result) {
                    JOptionPane.showMessageDialog(this.form, "success!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this.form, "failed!", "Error", JOptionPane.ERROR_MESSAGE);
                }

                this.form.reset(true);
            }
        });
    }
}
