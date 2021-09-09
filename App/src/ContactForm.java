import entity.ContactEntity;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class ContactForm extends JPanel implements ActionListener {
    private JLabel contactNameLabel;
    private JLabel contactPhoneLabel;
    private JLabel contactAddr1Label;
    private JLabel contactAddr2Label;
    private JLabel contactAddr3Label;
    private JLabel contactPinLabel;

    private JTextField contactNameText;
    private JFormattedTextField contactPhoneText;
    private JTextField contactAddr1Text;
    private JTextField contactAddr2Text;
    private JTextField contactAddr3Text;
    private JFormattedTextField contactPinText;

    private JLabel outputLabel = new JLabel("");
    private JButton button = new JButton("Submit");

    public ContactForm() {
//        super("Contact Form");
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(false);
        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
        numberFormatter.setAllowsInvalid(false);


        contactNameLabel = new JLabel("Contact Name");
        contactNameText = new JTextField(20);
        contactPhoneLabel = new JLabel("Phone");
        contactPhoneText = new JFormattedTextField(numberFormatter);
        contactPhoneText.setColumns(20);
        contactAddr1Label = new JLabel("Addr1");
        contactAddr1Text = new JTextField(20);
        contactAddr2Label = new JLabel("Addr2");
        contactAddr2Text = new JTextField(20);
        contactAddr3Label = new JLabel("Addr3");
        contactAddr3Text = new JTextField(20);
        contactPinLabel = new JLabel("Pin");
        contactPinText = new JFormattedTextField(numberFormatter);
        contactPinText.setColumns(20);

//        setLayout(new GridLayout(7,2));

        add(contactNameLabel);
        add(contactNameText);
        add(contactPhoneLabel);
        add(contactPhoneText);
        add(contactAddr1Label);
        add(contactAddr1Text);
        add(contactAddr2Label);
        add(contactAddr2Text);
        add(contactAddr3Label);
        add(contactAddr3Text);
        add(contactPinLabel);
        add(contactPinText);
        add(outputLabel);
        add(button);
        button.addActionListener(this);

//        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
//        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
//        setSize(400, 400);
//        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void viewHandler(ContactForm contactForm) {
        ContactEntity entity = getEntityFromUI(contactForm);
        if(entity.equals(null)) {
            System.out.println("Error in input");
            return;
        }

        boolean result = ContactManagerFacade.createOrUpdateContact(entity);
        if(result) {
            System.out.println("success!");
            contactForm.outputLabel.setText("success!");
        } else {
            System.out.println("failed");
            contactForm.outputLabel.setText("failed");
        }
    }

    public static ContactEntity getEntityFromUI(ContactForm contactForm) {
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setContactName(contactForm.contactNameText.getText());
        contactEntity.setContactPhone(Double.parseDouble(contactForm.contactPhoneText.getText()));
        contactEntity.setContactAddr1(contactForm.contactAddr1Text.getText());
        contactEntity.setContactAddr2(contactForm.contactAddr2Text.getText());
        contactEntity.setContactAddr3(contactForm.contactAddr3Text.getText());
        contactEntity.setContactPin(Integer.parseInt(contactForm.contactPinText.getText()));

        return contactEntity;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        outputLabel.setText("Creating a contact");
        viewHandler(this);
    }
}
