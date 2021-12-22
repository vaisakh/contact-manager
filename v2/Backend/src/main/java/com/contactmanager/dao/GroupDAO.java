package com.contactmanager.dao;

import com.contactmanager.entity.Group;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author vaisakhvm
 */
public class GroupDAO extends DBUtils {
    public boolean saveGroup(Group group) {
        try {
            SQLParameter params[] = new SQLParameter[3];
            String query;

            if (group.getId() == null) {
                query = "insert into groups(id, name, description) values(?,?,?)";
                params[0] = new SQLParameter("id", UUID.randomUUID().toString(), SQLType.SQLString);
            } else {
                query = "update groups set id = ?, name = ?, description = ?";
                params[0] = new SQLParameter("id", group.getId().toString(), SQLType.SQLString);
            }

            params[1] = new SQLParameter("name", group.getName(), SQLType.SQLString);
            params[2] = new SQLParameter("description", group.getDescription(), SQLType.SQLString);

            boolean result = executeNonQuery(query, params);
            closeConnection();
            return result;
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Group> getGroups() {
        try {
            ResultSet resultSet = executeQuery("select * from groups");
            ArrayList<Group> groupList = new ArrayList<>();

            while (resultSet.next()) {
                Group group = new Group();
                group.setId(UUID.fromString(resultSet.getString("id")));
                group.setName(resultSet.getString("name"));
                group.setDescription(resultSet.getString("description"));

                groupList.add(group);
            }
            resultSet.close();
            closeConnection();

            return groupList;

        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return null;
        }
    }
}
