import entity.ContactEntity;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ContactTableModel extends AbstractTableModel {
    private ArrayList<ContactEntity> contactList;
    private String header[] = new String[] { "ID", "NAME", "PHONE", "ADDR1", "ADDR2", "ADDR3", "PIN", "GROUP"};
    private ArrayList<ContactEntity> list = new ArrayList<ContactEntity>();
    public ContactTableModel(ArrayList<ContactEntity> contactList) {
        this.contactList = contactList;
    }

    @Override
    public String getColumnName(int column)
    {
        return header[column];
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ContactEntity row = contactList.get(rowIndex);
        if(0 == columnIndex) {
            return row.getContactId();
        }
        return null;
    }
}
