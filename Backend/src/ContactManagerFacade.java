import dao.ContactDAO;
import dao.GroupDAO;
import entity.ContactEntity;
import entity.GroupEntity;

public class ContactManagerFacade {

    public static boolean createOrUpdateGroup(GroupEntity groupEntity) {
        GroupDAO groupDAO = new GroupDAO();
        boolean result = groupDAO.createOrUpdateGroup(groupEntity);
        return result;
    }

    public static boolean createOrUpdateContact(ContactEntity contactEntity) {
        ContactDAO contactDAO = new ContactDAO();
        boolean result = contactDAO.createOrUpdateContact(contactEntity);
        return result;
    }
}
