package jforms;

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

    public ContactForm() {
        setContentPane(panelBase);
        setSize(500, 300);
        setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

        setListeners();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void setListeners() {
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

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