package com.contactmanager.model;

import com.contactmanager.entity.Contact;
import com.contactmanager.entity.Group;
import com.contactmanager.service.ContactService;
import com.contactmanager.service.GroupService;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author vaisakhvm
 */
public class GroupTableModel extends AbstractTableModel {
    private ArrayList<Group> groupList;

    private final String[] columnNames = new String[] { "ID", "NAME", "DESCRIPTION" };

    private final Class[] columnClass = new Class[] { String.class, String.class, String.class };

    public GroupTableModel(ArrayList<Group> groupList) {
        this.groupList = groupList;
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
        return groupList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex == 0) {
            return false;
        } else {
            return true;
        }
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Group row = groupList.get(rowIndex);

        if(0 == columnIndex) {
            return row.getId();
        }
        else if(1 == columnIndex) {
            return row.getName();
        }
        else if(2 == columnIndex) {
            return row.getDescription();
        }

        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Group row = groupList.get(rowIndex);

        if(0 == columnIndex) {
            //TODO ?
            row.setId(UUID.fromString(aValue.toString()));
        } else if(1 == columnIndex) {
            row.setName((String) aValue);
        } else if(2 == columnIndex) {
            row.setDescription((String) aValue);
        }

        fireTableCellUpdated(rowIndex, columnIndex);
        boolean result = GroupService.saveGroup((Group) row);
    }
}
