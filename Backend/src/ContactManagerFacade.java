import dao.GroupDAO;
import entity.GroupEntity;

public class ContactManagerFacade {

    public static boolean createOrUpdateGroup(GroupEntity groupEntity) {
        GroupDAO groupDAO = new GroupDAO();
        boolean result = groupDAO.createOrUpdateGroup(groupEntity);
        return result;
    }
}
