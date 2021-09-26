package dao;

import entity.GroupEntity;

import java.sql.*;
import java.util.ArrayList;

public class GroupDAO extends DBUtils {
    public ArrayList<GroupEntity> getGroups() {
        try {
            ResultSet resultSet = executeQuery("select * from groups");
            ArrayList<GroupEntity> groupList = new ArrayList<GroupEntity>();

            while (resultSet.next()) {
                GroupEntity groupEntity = new GroupEntity();
                groupEntity.setGroupdId(resultSet.getInt("group_id"));
                groupEntity.setGroupName(resultSet.getString("group_name"));
                groupEntity.setGroupDescription(resultSet.getString("group_description"));
                groupList.add(groupEntity);
            }
            resultSet.close();
            closeConnection();
            return groupList;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public boolean saveGroup(GroupEntity groupEntity) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/vaisakhvm/Projects/Learning/9005.java/contact-manager/contact_manager.db");
            PreparedStatement statement = connection.prepareStatement("insert into groups(group_name, group_description) values(?,?)");
            statement.setString(1, groupEntity.getGroupName());
            statement.setString(2, groupEntity.getGroupDescription());

            int resultSet = statement.executeUpdate();
            statement.close();
            connection.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateGroup() {
        try {
            String query = "update groups set group_description = 'duplicate friends and family' where group_id = 4";
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/vaisakhvm/Projects/Learning/9005.java/contact-manager/contact_manager.db");
            Statement statement = connection.createStatement();
            int resultSet = statement.executeUpdate(query);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean deleteGroup() {
        try {
            String query = "delete from groups where group_id > 3";
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/vaisakhvm/Projects/Learning/9005.java/contact-manager/contact_manager.db");
            Statement statement = connection.createStatement();
            int resultSet = statement.executeUpdate(query);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
