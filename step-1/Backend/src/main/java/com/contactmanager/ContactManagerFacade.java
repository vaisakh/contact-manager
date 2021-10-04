package com.contactmanager;

import com.contactmanager.dao.ContactDAO;
import com.contactmanager.dao.GroupDAO;
import com.contactmanager.entity.Contact;
import com.contactmanager.entity.Group;

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

    public static boolean saveGroup(Group group) {
        GroupDAO groupDAO = new GroupDAO();
        boolean result = groupDAO.saveGroup(group);
        return result;
    }

    public static ArrayList<Group> getGroups() {
        GroupDAO groupDAO = new GroupDAO();
        ArrayList<Group> groupList = groupDAO.getGroups();
        return groupList;
    }
}
