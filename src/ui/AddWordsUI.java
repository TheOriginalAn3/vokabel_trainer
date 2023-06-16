package ui;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AddWordsUI extends JFrame{
    String[] columnNames = { "English", "German" };

    public AddWordsUI() {
        DefaultTableModel model = new DefaultTableModel(columnNames, 1);
        JTable table = new JTable(model);
        add(table);
    }

    public static show

}
