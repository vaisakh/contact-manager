package com.contactmanager.view;

import com.contactmanager.entity.Contact;
import com.contactmanager.model.ContactTableModel;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author vaisakhvm
 */
public class ContactDetails extends JPanel implements TableModelListener {
    private JTable contactTable;
    DefaultTableModel model;

    ContactDetails() {
    }

    public void viewContacts(ArrayList<Contact> contactList) {
        ContactTableModel model = new ContactTableModel(contactList);
        contactTable = new JTable(model);
        add(new JScrollPane(contactTable));

        contactTable.getModel().addTableModelListener(this);

        add(contactTable);
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        //TODO
        System.out.println("CHANGING");
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel)e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);

        System.out.println(row);
        System.out.println(data.toString());

        JOptionPane.showMessageDialog(this, "success!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
