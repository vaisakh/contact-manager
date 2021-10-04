package com.contactmanager.controller;

import com.contactmanager.entity.Group;
import com.contactmanager.service.ContactService;
import com.contactmanager.service.GroupService;
import com.contactmanager.view.GroupDetails;
import com.contactmanager.view.GroupForm;

import javax.swing.*;

/**
 * @author vaisakhvm
 */
public class GroupController {
    private GroupForm form;
    private GroupDetails groupDetails;

    public GroupController(GroupForm groupForm, GroupDetails groupDetails) {
        this.form = groupForm;
        this.groupDetails = groupDetails;

        this.form.submitGroup(e -> {
            System.out.println("Group Form Submitted.");

            if(this.form.validateForm()) {
                Group group = this.form.getEntityFromUI();

                if(group.equals(null)) {
                    JOptionPane.showMessageDialog(this.form, "Invalid Group Entity.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                boolean result = GroupService.saveGroup(group);

                if(result) {
                    JOptionPane.showMessageDialog(this.form, "success!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this.form, "failed!", "Error", JOptionPane.ERROR_MESSAGE);
                }

                this.form.reset(true);
            }
        });

        this.form.viewGroups(e -> {
            this.groupDetails.viewGroups(GroupService.getGroups());
        });
    }
}
