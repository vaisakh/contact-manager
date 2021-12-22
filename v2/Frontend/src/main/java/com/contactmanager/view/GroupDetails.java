package com.contactmanager.view;

import com.contactmanager.entity.Group;
import com.contactmanager.model.GroupTableModel;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.util.ArrayList;

/**
 * @author vaisakhvm
 */
public class GroupDetails extends JPanel implements TableModelListener {
    private JTable groupTable;

    public void viewGroups(ArrayList<Group> groupList) {
        GroupTableModel model = new GroupTableModel(groupList);
        groupTable = new JTable(model);
        add(new JScrollPane(groupTable));

        groupTable.getModel().addTableModelListener(this);
        add(groupTable);
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        //TODO
        JOptionPane.showMessageDialog(this, "success!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
