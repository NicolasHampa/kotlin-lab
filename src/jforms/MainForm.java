package jforms;

import javax.swing.*;
import java.awt.*;

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

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
