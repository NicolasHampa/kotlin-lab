package jforms;

import kt.business.ContactBusiness;
import kt.entity.Contact;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainForm extends JFrame {
    private JPanel panelBase;
    private JButton buttonAbout;
    private JButton buttonNewContact;
    private JButton buttonRemoveContact;
    private JTable tableContacts;
    protected JLabel labelContacts;

    private ContactBusiness contactBusiness;

    public MainForm() {
        setContentPane(panelBase);
        setSize(500, 300);
        setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

        contactBusiness = new ContactBusiness();

        setListeners();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        getContacts();

        labelContacts.setText(contactBusiness.getContactsCount());
    }

    private void setListeners() {
        MainForm mainForm = MainForm.this;

        buttonNewContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new ContactForm(mainForm);
            }
        });

        buttonRemoveContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    protected void getContacts() {
        List<Contact> listContacts = contactBusiness.get();

        String[] columnNames = { "Name", "Phone", "E-mail" };
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);

        for (Contact contact : listContacts) {
            Object[] row = new Object[3];

            row[0] = contact.getName();
            row[1] = contact.getPhone();
            row[2] = contact.getEmail();

            model.addRow(row);
        }

        tableContacts.clearSelection();
        tableContacts.setModel(model);
    }
}
