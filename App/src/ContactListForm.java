import entity.ContactEntity;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ContactListForm extends JPanel {
    private JTable contactListTable;
    private String[] columns;
    private String[][] data;
    DefaultTableModel defaultTableModel;

    public ContactListForm() {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        ArrayList<ContactEntity> contactList = ContactManagerFacade.getContacts();
//        String header[] = new String[] { "ID", "NAME", "PHONE", "ADDR1", "ADDR2", "ADDR3", "PIN", "GROUP"};
//        defaultTableModel.setColumnIdentifiers(header);

        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("NAME");
        defaultTableModel.addColumn("PHONE");
        defaultTableModel.addColumn("ADDR1");
        defaultTableModel.addColumn("ADDR2");
        defaultTableModel.addColumn("ADDR3");
        defaultTableModel.addColumn("PIN");
        defaultTableModel.addColumn("GROUP");

        for (int i = 0; i < contactList.size(); i++) {
            System.out.println(contactList.get(i).getContactId());
            defaultTableModel.addRow(new Object[]{contactList.get(i).getContactId(), contactList.get(i).getContactName(), contactList.get(i).getContactPhone(), contactList.get(i).getContactAddr1(), contactList.get(i).getContactAddr2(),contactList.get(i).getContactAddr3(), contactList.get(i).getContactPin(),contactList.get(i).getGroupId()});
        }

        JTable contactListTable = new JTable(defaultTableModel);
        contactListTable.setModel(defaultTableModel);
        add(contactListTable);

    }
}
