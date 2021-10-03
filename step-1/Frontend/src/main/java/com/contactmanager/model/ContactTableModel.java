package com.contactmanager.model;

import com.contactmanager.entity.Contact;
import com.contactmanager.service.ContactService;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author vaisakhvm
 */
public class ContactTableModel extends AbstractTableModel {
    private ArrayList<Contact> contactList;

    private final String[] columnNames = new String[] {
            "ID", "FIRST NAME", "LAST NAME", "PHONE", "ADDR1", "ADDR2", "ADDR3", "PIN CODE", "GROUP ID"
    };

    private final Class[] columnClass = new Class[] {
            String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class
    };

    public ContactTableModel(ArrayList<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClass[columnIndex];
    }

    @Override
    public int getRowCount() {
        return contactList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex == 0) {
            return false;
        } else if(columnIndex == 8) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Contact row = contactList.get(rowIndex);

        if(0 == columnIndex) {
            return row.getId();
        }
        else if(1 == columnIndex) {
            return row.getFirstName();
        }
        else if(2 == columnIndex) {
            return row.getLastName();
        }
        else if(3 == columnIndex) {
            return row.getPhone();
        } else if(4 == columnIndex) {
            return row.getAddr1();
        } else if(5 == columnIndex) {
            return row.getAddr2();
        } else if(6 == columnIndex) {
            return row.getAddr3();
        } else if(7 == columnIndex) {
            return row.getPin();
        } else if(8 == columnIndex) {
            return row.getGroup();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        Contact row = contactList.get(rowIndex);

        if(0 == columnIndex) {
            //TODO ?
            row.setId(UUID.fromString(aValue.toString()));
        } else if(1 == columnIndex) {
            row.setFirstName((String) aValue);
        } else if(2 == columnIndex) {
            row.setLastName((String) aValue);
        } else if(3 == columnIndex) {
            row.setPhone((String) aValue);
        } else if(4 == columnIndex) {
            row.setAddr1((String) aValue);
        } else if(5 == columnIndex) {
            row.setAddr2((String) aValue);
        } else if(6 == columnIndex) {
            row.setAddr3((String) aValue);
        } else if(7 == columnIndex) {
            row.setPin((Integer) aValue);
        } else if(8 == columnIndex) {
            row.setGroup(UUID.fromString(aValue.toString()));
        }
        fireTableCellUpdated(rowIndex, columnIndex);

        //TODO
        boolean result = ContactService.saveContact((Contact) row);
    }
}
