package jforms;

import kt.business.ContactBusiness;
import kt.entity.Contact;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
    private String name = "";
    private String phone = "";
    private String email = "";

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
                try {
                    contactBusiness.delete(name, phone, email);

                    getContacts();

                    name = ""; phone = ""; email = "";
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(new JFrame(), exception.getMessage());
                }
            }
        });

        tableContacts.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                if (listSelectionEvent.getValueIsAdjusting()) {
                    if (tableContacts.getSelectedRow() != -1) {
                        name = tableContacts.getValueAt(tableContacts.getSelectedRow(), 0).toString();
                        phone = tableContacts.getValueAt(tableContacts.getSelectedRow(), 1).toString();
                        email = tableContacts.getValueAt(tableContacts.getSelectedRow(), 2).toString();
                    }
                }
            }
        });
    }

    protected void getContacts() {
        List<Contact> listContacts = contactBusiness.get();

        String[] columnNames = {"Name", "Phone", "E-mail"};
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

        labelContacts.setText(contactBusiness.getContactsCount());
    }
}
