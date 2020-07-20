package jforms;

import kt.business.ContactBusiness;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {

    private JPanel panelBase;
    private JPanel panelButtons;
    private JButton buttonSave;
    private JButton buttonCancel;
    private JTextField textFieldName;
    private JTextField textFieldPhone;
    private JTextField textFieldEmail;
    private JLabel labelName;
    private JLabel labelPhone;
    private JLabel labelEmail;

    private MainForm mainForm;
    private ContactBusiness contactBusiness;

    public ContactForm(MainForm mainForm) {
        setContentPane(panelBase);
        setSize(500, 300);
        setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

        this.mainForm = mainForm;
        contactBusiness = new ContactBusiness();

        setListeners();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void setListeners() {
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String name = textFieldName.getText();
                    String phone = textFieldPhone.getText();
                    String email = textFieldEmail.getText();

                    contactBusiness.save(name, phone, email);

                    mainForm.getContacts();

                    dispose();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(new JFrame(), exception.getMessage());
                }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
    }
}