package com.contactmanager.dao;

import com.contactmanager.entity.Contact;

/**
 * @author vaisakhvm
 */
public class ContactDAO {
    public boolean saveContact(Contact contact) {
        try {
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return false;
        }
    }
}
