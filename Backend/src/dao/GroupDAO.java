package dao;

import entity.GroupEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GroupDAO extends DBUtils {
    public ArrayList<GroupEntity> getGroups() {
        try {
            ResultSet resultSet = executeQuery("select * from groups");
            ArrayList<GroupEntity> groups = new ArrayList<GroupEntity>();

            while (resultSet.next()) {
                GroupEntity groupEntity = new GroupEntity();
                groupEntity.setGroupdId(resultSet.getInt("group_id"));
                groupEntity.setGroupName(resultSet.getString("group_name"));
                groupEntity.setGroupDescription(resultSet.getString("group_description"));
                groups.add(groupEntity);
            }
            resultSet.close();
            closeConnection();
            return groups;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public boolean createGroup() {
        try {
            String query = "insert into groups(group_id, group_name, group_description) values(5, 'colleagues', 'friends from work')";
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/dimplemonkey/contact_manager");
            Statement statement = connection.createStatement();
            int resultSet = statement.executeUpdate(query);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean updateGroup() {
        try {
            String query = "update groups set group_description = 'duplicate friends and family' where group_id = 4";
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/dimplemonkey/contact_manager");
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
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/dimplemonkey/contact_manager");
            Statement statement = connection.createStatement();
            int resultSet = statement.executeUpdate(query);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
