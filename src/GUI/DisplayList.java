package GUI;

import javax.swing.*;
import Data.FileIO;
import java.util.Vector;

public class DisplayList extends JFrame {

    private static final long serialVersionUID = 1L;
    public static DefaultListModel<String> arr;

    public DisplayList() {
        setTitle("Accounts List");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        getContentPane().setLayout(null);

        arr = new DefaultListModel<>();

        // Convert Vector<String> returned by bank.display() to DefaultListModel
        Vector<String> vec = FileIO.bank.display();
        for (String s : vec) {
            arr.addElement(s);
        }

        JList<String> list = new JList<>(arr);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(10, 10, 360, 240);
        getContentPane().add(scrollPane);
    }
}