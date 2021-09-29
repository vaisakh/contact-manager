package com.contactmanager.service;

import com.contactmanager.ContactManagerFacade;
import com.contactmanager.entity.Contact;

/**
 * @author vaisakhvm
 */
public class ContactService {

    public void getContacts() {

    }

    public void getContact() {

    }

    public static boolean saveContact(Contact contact) {
        System.out.println("Adding contact");
        boolean result = ContactManagerFacade.saveContact(contact);
        return result;
    }

    public void deleteContact() {

    }
}
