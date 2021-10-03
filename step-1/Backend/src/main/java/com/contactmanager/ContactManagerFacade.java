package com.contactmanager;

import com.contactmanager.dao.ContactDAO;
import com.contactmanager.entity.Contact;

import java.util.ArrayList;

/**
 * @author vaisakhvm
 */
public class ContactManagerFacade {
    public static boolean saveContact(Contact contact) {
        ContactDAO contactDAO = new ContactDAO();
        boolean result = contactDAO.saveContact(contact);
        return result;
    }

    public static ArrayList<Contact> getContacts() {
        ContactDAO contactDAO = new ContactDAO();
        ArrayList<Contact> contactList = contactDAO.getContacts();
        return contactList;
    }
}
