import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyGUI2 extends javax.swing.JFrame {

    // Declare Variables (reserve sapce in memory)
    private JPanel leftMenuPanel;
    private JPanel centerPanel;

    private JPanel rightWordsPanel;
    private JLabel rightWordsLabel;
    private JLabel rightWordsLabelCount;

    private JPanel wrongWordsPanel;
    private JLabel wrongWordsLabel;
    private JLabel wrongWordsLabelCount;

    // Colors
    private final Color priamryColor_RichBlack = new java.awt.Color(0x020c12);
    private final Color secondaryColor_EerieBlack = new java.awt.Color(0x181a1b);
    private final Color accentColor_MidnightGreen = new java.awt.Color(0x003c3c);
    private final Color textColor_AzureWeb = new java.awt.Color(0xf0ffff);
    private final Color contrastColor_MayaBlue = new java.awt.Color(0x6dbcee);

    
    // End of variable declaration

    public MyGUI2(){

        // this.[...] reffers to THIS JFrame. This is possible because this class extends javax.swing.JFrame
        this.setName("Vocabulary Trainer by Selin & Andrei");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 500);
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        // -------------------- Left Menu Panel --------------------
        leftMenuPanel = new JPanel();
        leftMenuPanel.setPreferredSize(new Dimension(200, 100));
        leftMenuPanel.setBackground(secondaryColor_EerieBlack);

        // Sub-Panels of Menu Panel
        leftMenuPanel.add(rightWordsPanel = new JPanel(), CENTER_ALIGNMENT);
        rightWordsPanel.add(rightWordsLabel = new JLabel("Right Words: "), LEFT_ALIGNMENT);
        rightWordsPanel.add(rightWordsLabelCount = new JLabel("871"), RIGHT_ALIGNMENT);

        leftMenuPanel.add(wrongWordsPanel = new JPanel(), CENTER_ALIGNMENT);
        wrongWordsPanel.add(wrongWordsLabel = new JLabel("Wrong Words: "), LEFT_ALIGNMENT);
        wrongWordsPanel.add(wrongWordsLabelCount = new JLabel("126"), RIGHT_ALIGNMENT);


        // ---------------------- Center Panel ----------------------
        centerPanel = new JPanel();
        centerPanel.setBackground(priamryColor_RichBlack);
        





        this.add(leftMenuPanel, BorderLayout.WEST);
        this.add(centerPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
