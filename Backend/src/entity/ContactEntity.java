package entity;

public class ContactEntity {
    private int contactId;
    private String contactName;
    private double contactPhone;
    private String contactAddr1;
    private String contactAddr2;
    private String contactAddr3;
    private int contactPin;
    private int groupId;
    //TODO: contact can have multiple group
    // private ArrayList<int> groupIds;

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Double getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(Double contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactAddr1() {
        return contactAddr1;
    }

    public void setContactAddr1(String contactAddr1) {
        this.contactAddr1 = contactAddr1;
    }

    public String getContactAddr2() {
        return contactAddr2;
    }

    public void setContactAddr2(String contactAddr2) {
        this.contactAddr2 = contactAddr2;
    }

    public String getContactAddr3() {
        return contactAddr3;
    }

    public void setContactAddr3(String contactAddr3) {
        this.contactAddr3 = contactAddr3;
    }

    public int getContactPin() {
        return contactPin;
    }

    public void setContactPin(int contactPin) {
        this.contactPin = contactPin;
    }

    public int getGroupId() { return groupId; }

    public void setGroupId(int groupId) { this.groupId = groupId; }
}
