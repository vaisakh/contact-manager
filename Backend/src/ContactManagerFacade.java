import dao.GroupDAO;
import entity.GroupEntity;

public class ContactManagerFacade {

    public static boolean createGroup(GroupEntity groupEntity) {
        GroupDAO groupDAO = new GroupDAO();
        boolean result = groupDAO.createGroup();
        return result;
    }
}
