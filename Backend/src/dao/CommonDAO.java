package dao;

import entity.GroupEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CommonDAO extends DBUtils {

    public ArrayList<GroupEntity> getGroups() {
        try {
            ResultSet resultSet = executeQuery("select * from groups");
            ArrayList<GroupEntity> listGroups = new ArrayList<GroupEntity>();

            while (resultSet.next()) {
                GroupEntity objGroup = new GroupEntity();
                objGroup.setGroupdId(resultSet.getInt("group_id"));
                objGroup.setGroupName(resultSet.getString("group_name"));
                listGroups.add(objGroup);
            }

            resultSet.close();
            closeConnection();
            return listGroups;
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return null;
        }
    }
}
