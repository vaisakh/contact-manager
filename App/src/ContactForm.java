import entity.GroupEntity;
import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class ContactForm extends JFrame implements ActionListener {
    private JLabel groupIdLabel;
    private JLabel groupNameLabel;
    private JLabel groupDescriptionLabel;
    private JFormattedTextField groupIdText;
    private JTextField groupNameText;
    private JTextField groupDescriptionText;
    private JLabel outputLabel = new JLabel("");
    private JButton button = new JButton("Submit");

    public ContactForm() {
        super("Contact Form");
        groupIdLabel = new JLabel("Group ID");
        NumberFormat numberFormat = NumberFormat.getInstance();
        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
        numberFormatter.setAllowsInvalid(false);
        groupIdText = new JFormattedTextField(numberFormatter);
        groupIdText.setColumns(20);

        groupNameLabel = new JLabel("Group Name");
        groupNameText = new JTextField(20);
        groupDescriptionLabel = new JLabel("Group Description");
        groupDescriptionText = new JTextField(20);

        setLayout(new GridLayout(5,2));
        add(groupIdLabel);
        add(groupIdText);
        add(groupNameLabel);
        add(groupNameText);
        add(groupDescriptionLabel);
        add(groupDescriptionText);
        add(outputLabel);
        add(button);
        button.addActionListener(this);

        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void viewHandler(ContactForm contactForm) {
        System.out.println(contactForm.groupIdText.getText());
        GroupEntity entity = getEntityFromUI(contactForm);
        System.out.println(entity);
        if(entity.equals(null)) {
            System.out.println("Error in input");
            return;
        }

        boolean result = ContactManagerFacade.createGroup(entity);
        if(result) {
            System.out.println("success");
        } else {
            System.out.println("failed");
        }

    }

    public static GroupEntity getEntityFromUI(ContactForm contactForm) {
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setGroupdId(Integer.parseInt(contactForm.groupIdText.getText()));
        groupEntity.setGroupName(contactForm.groupNameText.getText());
        groupEntity.setGroupDescription(contactForm.groupDescriptionText.getText());
        return groupEntity;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        outputLabel.setText("Creating a group");
        viewHandler(this);
    }
}