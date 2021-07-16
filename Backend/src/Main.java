import dao.DBUtils;
import dao.GroupDAO;
import entity.GroupEntity;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        GroupDAO groupDAO = new GroupDAO();
        ArrayList<GroupEntity> groups = groupDAO.getGroups();
        for (GroupEntity group : groups) {
            System.out.print(group.getGroupdId() + " ");
            System.out.print(group.getGroupName() + " ");
            System.out.println(group.getGroupDescription() + " ");
        }
    }
}
