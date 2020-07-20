package jforms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JPanel panelBase;
    private JButton buttonAbout;
    private JButton buttonNewContact;
    private JButton buttonRemoveContact;
    private JTable tableContacts;

    public MainForm() {
        setContentPane(panelBase);
        setSize(500, 300);
        setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

        setListeners();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void setListeners() {
        buttonNewContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new ContactForm();
            }
        });

        buttonRemoveContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
}
