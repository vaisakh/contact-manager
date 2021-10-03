package com.contactmanager.service;

import com.contactmanager.ContactManagerFacade;
import com.contactmanager.entity.Contact;

import java.util.ArrayList;

/**
 * @author vaisakhvm
 */
public class ContactService {

    public static ArrayList<Contact> getContacts() {
        ArrayList<Contact> contactList = ContactManagerFacade.getContacts();
        return contactList;
    }

    public void getContact() {

    }

    public static boolean saveContact(Contact contact) {
        System.out.println("Saving contact");
        boolean result = ContactManagerFacade.saveContact(contact);
        return result;
    }

    public void deleteContact() {

    }
}
