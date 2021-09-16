import dao.CommonDAO;
import dao.ContactDAO;
import dao.GroupDAO;
import entity.ContactEntity;
import entity.GroupEntity;

import java.util.ArrayList;

public class ContactManagerFacade {

    public static boolean saveGroup(GroupEntity groupEntity) {
        GroupDAO groupDAO = new GroupDAO();
        boolean result = groupDAO.saveGroup(groupEntity);
        return result;
    }

    public static boolean saveContact(ContactEntity contactEntity) {
        ContactDAO contactDAO = new ContactDAO();
        boolean result = contactDAO.saveContact(contactEntity);
        return result;
    }

    public static ArrayList<GroupEntity> getGroups() {
        CommonDAO commonDAO = new CommonDAO();
        ArrayList<GroupEntity> listGroups = commonDAO.getGroups();
        return listGroups;
    }

    public static ArrayList<ContactEntity> getContacts() {
        ContactDAO contactDAO = new ContactDAO();
        ArrayList<ContactEntity> contactList = contactDAO.getContacts();
        return contactList;
    }
}
