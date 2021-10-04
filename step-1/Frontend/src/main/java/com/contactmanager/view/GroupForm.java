package com.contactmanager.view;

import com.contactmanager.entity.Group;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.UUID;

/**
 * @author vaisakhvm
 */
public class GroupForm extends JPanel {
    private JTextField nameField;
    private JTextField descriptionField;

    private JButton addButton;
    private JButton viewGroupButton;

    GroupForm() {
        JLabel nameLabel = new JLabel("Group name: ");
        JLabel descriptionLabel = new JLabel("Description: ");

        nameField = new JTextField(25);
        descriptionField = new JTextField(25);


        addButton = new JButton("Add Group");
        viewGroupButton = new JButton("View Groups");

        // Layout
        setLayout(new GridLayout(3,2));

        add(nameLabel);
        add(nameField);

        add(descriptionLabel);
        add(descriptionField);

        add(viewGroupButton);
        add(addButton);
    }

    public String getName() {
        return nameField.getText();
    }

    public String getDescription() {
        return descriptionField.getText();
    }

    public void submitGroup(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void viewGroups(ActionListener actionListener) {
        viewGroupButton.addActionListener(actionListener);
    }

    public Group getEntityFromUI() {
        Group group = new Group();

//        group.setId();
        group.setName(getName().trim());
        group.setDescription(getDescription().trim());

        return group;
    }

    public boolean validateForm() {
        if(nameField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Group Name Required.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if(descriptionField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Description Required", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public void reset(boolean bln) {
        if(bln) {
            nameField.setText("");
            descriptionField.setText("");
        }
    }
}
