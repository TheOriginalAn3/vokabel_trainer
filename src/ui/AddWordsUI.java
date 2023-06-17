package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import handlers.Vocab;

public class AddWordsUI extends JFrame {
    private String[] columnNames = { "English", "German" };
    private Vocab vocab;
    private DefaultTableModel model;
    private JTextField jTextFieldEng, jTextFieldGer;
    private String inputTextEng, inputTextGer;
    private JTable table;

    public AddWordsUI() {
        vocab = Vocab.getInstance();
        // model = new DefaultTableModel(columnNames, 1);
        // table = new JTable(model);
        // add(table);

        // Window settings
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setSize(300, 80);
        setFocusable(true);
        setTitle("VT 01 by Selin & Andrei");
        setResizable(false);

        // Panel where JTextFields will be
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Adds a empty border around the panel/"padding"

        // Translation Input Text Field For English
        jTextFieldEng = new JTextField();
        jTextFieldEng.setFont(new java.awt.Font("Unispace", 0, 12)); // NOI18N
        jTextFieldEng.setText("English Vocab");
        jTextFieldEng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextFieldActionPerformed(evt);
            }
        });
        jTextFieldEng.setSize(150, 80);
        // Create Border. Code from BingAI(GPT4) but edited to fit my preferences
        jTextFieldEng.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(0, 0, 0, 5)));
        panel.add(jTextFieldEng);

        // Translation Input Text Field For German
        jTextFieldGer = new JTextField();
        jTextFieldGer.setFont(new java.awt.Font("Unispace", 0, 12)); // NOI18N
        jTextFieldGer.setText("German Vocab");
        jTextFieldGer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextFieldActionPerformed(evt);
            }
        });
        jTextFieldGer.setSize(100, 80);
        // Create Border. Code from BingAI(GPT4) but edited to fit my preferences
        jTextFieldGer.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(0, 0, 0, 5)));
        panel.add(jTextFieldGer);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void jTextFieldActionPerformed(ActionEvent evt) {
        inputTextEng = jTextFieldEng.getText();
        inputTextGer = jTextFieldGer.getText();
        System.out.println("Eng Text submited: " + inputTextEng);
        System.out.println("Ger Text submited: " + inputTextGer);
        jTextFieldEng.setText("");
        jTextFieldGer.setText("");
        vocab.addNewWord(inputTextEng, inputTextGer);
    }
}
