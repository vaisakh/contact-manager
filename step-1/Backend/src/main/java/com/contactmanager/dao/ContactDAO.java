package com.contactmanager.dao;

import com.contactmanager.entity.Contact;


/**
 * @author vaisakhvm
 */
public class ContactDAO extends DBUtils {
    public boolean saveContact(Contact contact) {
        try {
            SQLParameter params[] = new SQLParameter[9];
            params[0] = new SQLParameter("id", contact.getId().toString(), SQLType.SQLString);
            params[1] = new SQLParameter("first_name", contact.getFirstName(), SQLType.SQLString);
            params[2] = new SQLParameter("last_name", contact.getLastName(), SQLType.SQLString);
            params[3] = new SQLParameter("phone_number", contact.getPhone(), SQLType.SQLString);
            params[4] = new SQLParameter("addr1", contact.getAddr1(), SQLType.SQLText);
            params[5] = new SQLParameter("addr2", contact.getAddr2(), SQLType.SQLText);
            params[6] = new SQLParameter("addr3", contact.getAddr3(), SQLType.SQLText);
            params[7] = new SQLParameter("pin_code", contact.getPin(), SQLType.SQLInt);
            params[8] = new SQLParameter("group_id", contact.getGroup().toString(), SQLType.SQLString);
            boolean result = executeQuery("insert into contact(id, first_name, last_name, phone_number, addr1, addr2, addr3, pin_code, group_id) values(?,?,?,?,?,?,?,?,?)", params);
            closeConnection();
            return result;
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return false;
        }
    }
}
