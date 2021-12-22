package dao;

import entity.ContactEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ContactDAO extends DBUtils {
    public ArrayList<ContactEntity> getContacts() {
        try {
            ResultSet resultSet = executeQuery("select * from contact");
            ArrayList<ContactEntity> contactList = new ArrayList<ContactEntity>();

            while (resultSet.next()) {
                System.out.println("HAS CONTACT");
                ContactEntity contactEntity = new ContactEntity();
                contactEntity.setContactId(resultSet.getInt("contact_id"));
                contactEntity.setContactName(resultSet.getString("contact_name"));
                contactEntity.setContactPhone(resultSet.getDouble("contact_phone"));
                contactEntity.setContactAddr1(resultSet.getString("contact_addr_1"));
                contactEntity.setContactAddr2(resultSet.getString("contact_addr_2"));
                contactEntity.setContactAddr3(resultSet.getString("contact_addr_3"));
                contactEntity.setContactPin(resultSet.getInt("contact_pin"));
                contactEntity.setGroupId(resultSet.getInt("group_id"));

                contactList.add(contactEntity);
            }
            resultSet.close();
            closeConnection();

            return contactList;
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return null;
        }
    }

    public boolean saveContact(ContactEntity contactEntity) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/vaisakhvm/Projects/Learning/9005.java/contact-manager/contact_manager.db");
            PreparedStatement statement = connection.prepareStatement("insert into contact(contact_name, contact_phone, contact_addr_1, contact_addr_2, contact_addr_3, contact_pin, group_id) values(?,?,?,?,?,?,?)");
            //TODO: conditional check if contact ID exists?

            statement.setString(1, contactEntity.getContactName());
            statement.setDouble(2, contactEntity.getContactPhone());
            statement.setString(3, contactEntity.getContactAddr1());
            statement.setString(4, contactEntity.getContactAddr2());
            statement.setString(5, contactEntity.getContactAddr3());
            statement.setDouble(6, contactEntity.getContactPin());
            statement.setInt(7, contactEntity.getGroupId());

            //TODO: conditional check if Group ID exists?
            //TODO: if multiple group ID exists: ArrayList
//            if(contactEntity.getGroupId() != 0) {
//                statement.setInt(7, contactEntity.getGroupId());
//            }


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
}
