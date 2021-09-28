package com.contactmanager;

import com.contactmanager.dao.ContactDAO;
import com.contactmanager.entity.Contact;

/**
 * @author vaisakhvm
 */
public class ContactManagerFacade {
    public static boolean saveContact(Contact contact) {
        ContactDAO contactDAO = new ContactDAO();
        boolean result = contactDAO.saveContact(contact);
        return result;
    }
}
