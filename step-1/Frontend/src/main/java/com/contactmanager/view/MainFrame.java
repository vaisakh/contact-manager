package com.contactmanager.view;

import com.contactmanager.controller.ContactController;

import javax.swing.*;

/**
 * @author vaisakhvm
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        super("Contact Manager GUI");

        ContactForm contactForm = new ContactForm();
        new ContactController(contactForm);
        add(contactForm);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,400);
        setVisible(true);
    }
}
