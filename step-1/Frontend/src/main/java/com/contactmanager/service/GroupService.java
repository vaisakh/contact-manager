package com.contactmanager.service;

import com.contactmanager.ContactManagerFacade;
import com.contactmanager.entity.Contact;
import com.contactmanager.entity.Group;

import java.util.ArrayList;

/**
 * @author vaisakhvm
 */
public class GroupService {
    public static ArrayList<Group> getGroups() {
        ArrayList<Group> groupList = ContactManagerFacade.getGroups();
        return groupList;
    }

    public void getGroup() {

    }

    public static boolean saveGroup(Group group) {
        System.out.println("Saving group");
        boolean result = ContactManagerFacade.saveGroup(group);
        return result;
    }

    public void deleteGroup() {

    }
}
