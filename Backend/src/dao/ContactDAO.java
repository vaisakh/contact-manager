package dao;

import entity.ContactEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ContactDAO extends DBUtils {
    public boolean createOrUpdateContact(ContactEntity contactEntity) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/vaisakhvm/Projects/Learning/9005.java/contact-manager/contact_manager.db");
            PreparedStatement statement = connection.prepareStatement("insert into contact(contact_name, contact_phone, contact_addr_1, contact_addr_2, contact_addr_3, contact_pin) values(?,?,?,?,?,?)");
            statement.setString(1, contactEntity.getContactName());
            statement.setDouble(2, contactEntity.getContactPhone());
            statement.setString(3, contactEntity.getContactAddr1());
            statement.setString(4, contactEntity.getContactAddr2());
            statement.setString(5, contactEntity.getContactAddr3());
            statement.setDouble(6, contactEntity.getContactPin());

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
