package dao;

import entity.GroupEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class GroupDAO extends DBUtils {
    public ArrayList<GroupEntity> getGroups() {
        try {
            ResultSet resultSet = executeQuery("select * from groups");
            ArrayList<GroupEntity> groupEntities = new ArrayList<GroupEntity>();

            while (resultSet.next()) {
                GroupEntity groupEntity = new GroupEntity();
                groupEntity.setGroupdId(resultSet.getInt("group_id"));
                groupEntity.setGroupName(resultSet.getString("group_name"));
                groupEntity.setGroupDescription(resultSet.getString("group_description"));
                groupEntities.add(groupEntity);
            }
            resultSet.close();
            closeConnection();
            return groupEntities;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
