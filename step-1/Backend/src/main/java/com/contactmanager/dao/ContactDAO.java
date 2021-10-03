package com.contactmanager.dao;

import com.contactmanager.entity.Contact;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;


/**
 * @author vaisakhvm
 */
public class ContactDAO extends DBUtils {
    public boolean saveContact(Contact contact) {
        try {
            SQLParameter params[] = new SQLParameter[9];
            String query;

            if(contact.getId() == null) {
                query = "insert into contact(id, first_name, last_name, phone_number, addr1, addr2, addr3, pin_code, group_id) values(?,?,?,?,?,?,?,?,?)";
                params[0] = new SQLParameter("id", UUID.randomUUID().toString(), SQLType.SQLString);
            } else {
                query = "update contact set id = ?, first_name = ?, last_name = ?, phone_number = ?, addr1 = ?, addr2 = ?, addr3 = ?, pin_code = ?, group_id = ?";
                params[0] = new SQLParameter("id", contact.getId().toString(), SQLType.SQLString);
            }

            params[1] = new SQLParameter("first_name", contact.getFirstName(), SQLType.SQLString);
            params[2] = new SQLParameter("last_name", contact.getLastName(), SQLType.SQLString);
            params[3] = new SQLParameter("phone_number", contact.getPhone(), SQLType.SQLString);
            params[4] = new SQLParameter("addr1", contact.getAddr1(), SQLType.SQLText);
            params[5] = new SQLParameter("addr2", contact.getAddr2(), SQLType.SQLText);
            params[6] = new SQLParameter("addr3", contact.getAddr3(), SQLType.SQLText);
            params[7] = new SQLParameter("pin_code", contact.getPin(), SQLType.SQLInt);
            params[8] = new SQLParameter("group_id", contact.getGroup().toString(), SQLType.SQLString);

            boolean result = executeNonQuery(query, params);
            closeConnection();
            return result;
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Contact> getContacts() {
        try {
            ResultSet resultSet = executeQuery("select * from contact");
            ArrayList<Contact> contactList = new ArrayList<Contact>();

            while (resultSet.next()) {
                Contact contact = new Contact();
                contact.setId(UUID.fromString(resultSet.getString("id")));
                contact.setFirstName(resultSet.getString("first_name"));
                contact.setLastName(resultSet.getString("last_name"));
                contact.setPhone(resultSet.getString("phone_number"));
                contact.setAddr1(resultSet.getString("addr1"));
                contact.setAddr2(resultSet.getString("addr2"));
                contact.setAddr3(resultSet.getString("addr3"));
                contact.setPin(resultSet.getInt("pin_code"));
                contact.setGroup(UUID.fromString(resultSet.getString("group_id")));

                contactList.add(contact);
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

    public Contact getContact(UUID id) {
        try {
            SQLParameter params[] = new SQLParameter[1];
            params[0] = new SQLParameter("id", id.toString(), SQLType.SQLString);
            ResultSet resultSet = executeQuery("select * from contact where id = ?", params);

            Contact contact = new Contact();
            resultSet.next();

            contact.setId(UUID.fromString(resultSet.getString("id")));
            contact.setFirstName(resultSet.getString("first_name"));
            contact.setLastName(resultSet.getString("last_name"));
            contact.setPhone(resultSet.getString("phone_number"));
            contact.setAddr1(resultSet.getString("addr1"));
            contact.setAddr2(resultSet.getString("addr2"));
            contact.setAddr3(resultSet.getString("addr3"));
            contact.setPin(resultSet.getInt("pin_code"));
            contact.setGroup(UUID.fromString(resultSet.getString("group_id")));


            System.out.println(resultSet);

            return contact;
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return null;
        }
    }
}
