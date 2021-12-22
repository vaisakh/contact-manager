import entity.GroupEntity;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GroupForm extends JPanel implements ActionListener {
    //    private JLabel groupIdLabel;
    private JLabel groupNameLabel;
    private JLabel groupDescriptionLabel;
    private JFormattedTextField groupIdText;
    private JTextField groupNameText;
    private JTextField groupDescriptionText;
    private JLabel outputLabel = new JLabel("");
    private JButton button = new JButton("Submit");

    public GroupForm() {
        //TODO
//        super("Group Form");
//        groupIdLabel = new JLabel("Group ID");
//        NumberFormat numberFormat = NumberFormat.getInstance();
//        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
//        numberFormatter.setAllowsInvalid(false);
//        groupIdText = new JFormattedTextField(numberFormatter);
//        groupIdText.setColumns(20);

        groupNameLabel = new JLabel("Group Name");
        groupNameText = new JTextField(20);
        groupDescriptionLabel = new JLabel("Group Description");
        groupDescriptionText = new JTextField(20);

        setLayout(new GridLayout(5,2));
//        add(groupIdLabel);
//        add(groupIdText);
        add(groupNameLabel);
        add(groupNameText);
        add(groupDescriptionLabel);
        add(groupDescriptionText);
        add(outputLabel);
        add(button);
        button.addActionListener(this);

        setSize(400, 400);
        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void viewHandler(GroupForm groupForm) {
        GroupEntity entity = getEntityFromUI(groupForm);
        if(entity.equals(null)) {
            System.out.println("Error in input");
            return;
        }

        boolean result = ContactManagerFacade.saveGroup(entity);
        if(result) {
            System.out.println("success!");
            groupForm.outputLabel.setText("success!");
        } else {
            System.out.println("failed");
            groupForm.outputLabel.setText("failed!");
        }

    }

    public static GroupEntity getEntityFromUI(GroupForm groupForm) {
        GroupEntity groupEntity = new GroupEntity();
//        groupEntity.setGroupdId(Integer.parseInt(groupForm.groupIdText.getText()));
        groupEntity.setGroupName(groupForm.groupNameText.getText());
        groupEntity.setGroupDescription(groupForm.groupDescriptionText.getText());
        return groupEntity;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
        outputLabel.setText("Creating a group");
        viewHandler(this);
    }
}