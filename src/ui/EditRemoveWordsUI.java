package ui;

import java.awt.Dimension;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import handlers.Vocab;

public class EditRemoveWordsUI extends JFrame {
    private String[] columnNames = { "English", "German" };
    private DefaultTableModel model;
    private JTable table;
    private Vocab vocab;
    private String[][] vocabArray;

    private String engVocabFile = "English.txt";
    private String gerVocabFile = "German.txt";

    public EditRemoveWordsUI() {
        vocab = Vocab.getInstance();
        vocabArray = vocab.getAllVocabsAsArray();

        setDefaultCloseOperation(HIDE_ON_CLOSE);

        // Code by BingAI but edited to my needs
        model = new DefaultTableModel(vocabArray, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
       
        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(600, 200)); // Set Size of Table
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);

        // Add Listener to look for changes in the table and save them to the array
        // Code for addTablModelListener by BingAI(GPT4) but edited to fit my needs.
        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent tme) {
                int row = tme.getFirstRow(); // Gets the row nr that changed
                int column = tme.getColumn(); // Gets the Column nr that changed
                String value = (String) model.getValueAt(row, column); // Saves the new table value to a variable as String
                vocabArray[row][column] = value;


                // Debug Code
                // Print the updated data to console
                System.out.println("-----------VOCAB ARRAY-----------");
                for (int i = 0; i < vocabArray.length; i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.print(vocabArray[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println("---------------------------------");
                
                // Save the edited words to the specific files
                vocab.updateVocabs(vocabArray);
            }
            
        });
        
        add(scrollPane);
        pack();
        setLocationRelativeTo(null); // Show in the center of the display
        setVisible(true);
    }
}
