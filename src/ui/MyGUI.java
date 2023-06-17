package ui;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import handlers.Config;
import handlers.MyVars;

public class MyGUI extends JFrame {
    // Variables declaration - do not modify                     
    private ButtonGroup buttonGroup2;
    private JButton jButton3_AddWord;
    private JButton jButton4_RemEditWord;
    private JLabel jLabelRightWords;
    private JLabel jLabel2;
    private JLabel jLabelWrongWords;
    private JLabel jLabel5;
    private JLabel jLabel7;
    private JLabel jLabelRightWordsCount;
    private JLabel jLabelWrongWordsCount;
    private JPanel jPanelLeftSideMenu;
    private JPanel jPanelRightWords;
    private JPanel jPanelWrongWords;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JRadioButton jRadioButton1_VoiceRecognition;
    private JRadioButton jRadioButton2_EngToGer;
    private JRadioButton jRadioButton3_GerToEng;
    private JScrollPane jScrollPane1;
    private JTextField jTextField1;
    private JTextPane jTextPane_ToTranslate;

    // Get access to variables from config file
    // Get access to save method to save Variable Changes
    private MyVars myVars;
    private Config config;

    // Color Variables set here once else new color obj will have to be created for each time a color is used.
    private Color mainColor = new java.awt.Color(0x221f3a);
    private Color mainTextColor = new java.awt.Color(0xcecdd8);
    private Color secondaryButtonColor = new java.awt.Color(0x1f2223);

    private Color secondaryColor = new java.awt.Color(0x26233e);
    private Color tertiaryColor = new java.awt.Color(0x2f2b4c);

    private String inputText;
    // End of variables declaration       

    public MyGUI(MyVars myVars, Config config) {
        this.myVars = myVars;
        this.config = config;
        initComponents();
    }

    // Method stolen from a game project im working on
    // Link for the github repo:  https://github.com/TheOriginalAn3/Some2DGame/blob/master/src/main/ImageHandler.java
    public static BufferedImage readImage(String pathToImg) {
        try {
            BufferedImage img = null;
            File file = new File(pathToImg);
            if (file.exists()) {
                try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
                    img = ImageIO.read(inputStream);
                }
            }
            return img;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanelLeftSideMenu = new javax.swing.JPanel();
        jPanelRightWords = new javax.swing.JPanel();
        jLabelRightWords = new javax.swing.JLabel();
        jLabelRightWordsCount = new javax.swing.JLabel();
        jPanelWrongWords = new javax.swing.JPanel();
        jLabelWrongWords = new javax.swing.JLabel();
        jLabelWrongWordsCount = new javax.swing.JLabel();
        jRadioButton1_VoiceRecognition = new javax.swing.JRadioButton();
        jButton3_AddWord = new javax.swing.JButton();
        jButton4_RemEditWord = new javax.swing.JButton();
        jRadioButton2_EngToGer = new javax.swing.JRadioButton();
        jRadioButton3_GerToEng = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane_ToTranslate = new javax.swing.JTextPane();
        jPanel5 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();


        // Main pannel
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vocabulary Trainer by Selin and Andrei");
        getContentPane().setBackground(mainColor);
        setSize(470, 245);
        setResizable(false);
        setName("GUI"); // NOI18N
        setIconImage(readImage("resources/images/logo_BingImageCreator.png"));

        // Left Side Menu
        jPanelLeftSideMenu.setBackground(secondaryColor); // Set jPanel1 (Left menu pannel) color to #262a2b
        
        // Right Words
        jPanelRightWords.setBackground(tertiaryColor); // Panel color
        jLabelRightWords.setFont(new java.awt.Font("Unispace", 1, 14)); // NOI18N
        jLabelRightWords.setText("Right Words:");
        jLabelRightWords.setForeground(mainTextColor); // Text color

        jLabelRightWordsCount.setFont(new java.awt.Font("Unispace", 1, 14)); // NOI18N
        jLabelRightWordsCount.setForeground(mainTextColor); // Number color
        jLabelRightWordsCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRightWordsCount.setText(Integer.toString(myVars.getIntRightWords())); // Set ammount of right words
        
        // I have no idea what this does. I just built and sized the GUI using NetBeans Scene Builder
        // I think this is just for spacing the text inside the "Right Words" pane
        // This also adds the labels as child components to the jPanelRightWords
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanelRightWords);
        jPanelRightWords.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelRightWords)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelRightWordsCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRightWords, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabelRightWordsCount))
                .addContainerGap())
        );


        // Wrong words
        jPanelWrongWords.setBackground(tertiaryColor); // Panel color
        jLabelWrongWords.setFont(new java.awt.Font("Unispace", 1, 14)); // NOI18N
        jLabelWrongWords.setForeground(mainTextColor); // Text color
        jLabelWrongWords.setText("Wrong Words:");

        jLabelWrongWordsCount.setFont(new java.awt.Font("Unispace", 1, 14)); // NOI18N
        jLabelWrongWordsCount.setForeground(mainTextColor); // Number color
        jLabelWrongWordsCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelWrongWordsCount.setText(Integer.toString(myVars.getIntWrongWords())); // Set ammount of wrong words
        
        // I have no idea what this does. I just built and sized the GUI using NetBeans Scene Builder
        // I think this is just for spacing the text inside the "Wrong Words" pane
        // This also adds the labels as child components to the jPanelWrongWords
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanelWrongWords);
        jPanelWrongWords.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelWrongWords)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelWrongWordsCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelWrongWords, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabelWrongWordsCount))
                .addContainerGap())
        );


        // Vocie Recognition Toggle
        jRadioButton1_VoiceRecognition.setBackground(secondaryColor);
        jRadioButton1_VoiceRecognition.setFont(new java.awt.Font("Unispace", 1, 12)); // NOI18N
        jRadioButton1_VoiceRecognition.setForeground(mainTextColor); // Set text color
        jRadioButton1_VoiceRecognition.setText("Voice Recognition");
        jRadioButton1_VoiceRecognition.setToolTipText("!!ONLY WORKS WITH INTERNET CONNECTION!!\nSelected: Voice Recognition is on.\nDeselected: Voice Recognition is off.\nThis will use your microphone to analyze speech and convert it to text using Google API.");
        jRadioButton1_VoiceRecognition.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton1_VoiceRecognition.setSelected(myVars.isVoiceToggleSelected()); // Set state (selected/deselected). This code calls the 
        jRadioButton1_VoiceRecognition.setBorder(null);
        jRadioButton1_VoiceRecognition.setFocusable(false);
        jRadioButton1_VoiceRecognition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButton1_VoiceRecognitionActionPerformed(evt);
            }
        });

        // Add Word Button
        jButton3_AddWord.setBackground(tertiaryColor); // Set panel color
        jButton3_AddWord.setFont(new java.awt.Font("Unispace", 0, 12)); // NOI18N
        jButton3_AddWord.setForeground(mainTextColor); // Set text color
        jButton3_AddWord.setText("Add a Word");
        jButton3_AddWord.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3_AddWord.setFocusable(false);
        jButton3_AddWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3_AddWordActionPerformed(evt);
            }
        });

        // Remove Edit Word Button
        jButton4_RemEditWord.setBackground(tertiaryColor); // Set panel color
        jButton4_RemEditWord.setFont(new java.awt.Font("Unispace", 0, 12)); // NOI18N
        jButton4_RemEditWord.setForeground(mainTextColor); // Set text color
        jButton4_RemEditWord.setText("Remove / Edit a Word");
        jButton4_RemEditWord.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4_RemEditWord.setFocusable(false);
        jButton4_RemEditWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4_RemEditWordActionPerformed(evt);
            }
        });


        // Language Select Menu
        jLabel7.setFont(new java.awt.Font("Unispace", 0, 12)); // NOI18N
        jLabel7.setText("Language Select:");
        jLabel7.setForeground(mainTextColor); // Set text color

        // English to German Toggle
        buttonGroup2.add(jRadioButton2_EngToGer);
        jRadioButton2_EngToGer.setFont(new java.awt.Font("Unispace", 0, 12)); // NOI18N
        jRadioButton2_EngToGer.setSelected(!myVars.isGerToEngSelected()); // Read the state of the Toggle and set it to its opposite.
        jRadioButton2_EngToGer.setText("English -> German");
        jRadioButton2_EngToGer.setBackground(secondaryColor); // Set background color
        jRadioButton2_EngToGer.setForeground(mainTextColor); // Set text color
        jRadioButton2_EngToGer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton2_EngToGer.setFocusable(false);
        jRadioButton2_EngToGer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButton2_EngToGerActionPerformed(evt);
            }
        });

        // German to English Toggle
        buttonGroup2.add(jRadioButton3_GerToEng);
        jRadioButton3_GerToEng.setFont(new java.awt.Font("Unispace", 0, 12)); // NOI18N
        jRadioButton3_GerToEng.setSelected(myVars.isGerToEngSelected()); // Read the state of the Toggle and set it.
        jRadioButton3_GerToEng.setText("German -> English");
        jRadioButton3_GerToEng.setBackground(secondaryColor); // Set background color
        jRadioButton3_GerToEng.setForeground(mainTextColor); // Set text color
        jRadioButton3_GerToEng.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton3_GerToEng.setFocusable(false);
        jRadioButton3_GerToEng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButton3_EngToGerActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanelLeftSideMenu);
        jPanelLeftSideMenu.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jButton3_AddWord, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRightWords, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelWrongWords, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4_RemEditWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton1_VoiceRecognition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton3_GerToEng, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton2_EngToGer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelRightWords, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelWrongWords, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton1_VoiceRecognition)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2_EngToGer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3_GerToEng)
                .addGap(18, 18, 18)
                .addComponent(jButton3_AddWord)
                
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4_RemEditWord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addContainerGap())
        );

        // TODO #6 BUG: window resizes with the lenght of the word @TheOriginalAn3
        // Word Display Pane
        jPanel4.setBackground(mainColor); // Change pane color

        // Translate This Label
        jLabel5.setFont(new java.awt.Font("Unispace", 1, 14)); // NOI18N
        jLabel5.setForeground(mainTextColor); // Set text color
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Translate this word:");

        // Word To Translate
        jTextPane_ToTranslate.setEditable(false);
        jTextPane_ToTranslate.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jTextPane_ToTranslate.setForeground(mainTextColor); // Set text color
        jTextPane_ToTranslate.setText("to do sth without knowing what youre doing");
        jTextPane_ToTranslate.setAutoscrolls(false);
        jTextPane_ToTranslate.setBackground(secondaryButtonColor); // Set background color
        jScrollPane1.setViewportView(jTextPane_ToTranslate);
        jScrollPane1.setBorder(null); // Removes White Border

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel5))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        // Write Translation Pane
        jPanel5.setBackground(mainColor);

        // Translation Text
        jLabel2.setFont(new java.awt.Font("Unispace", 1, 12)); // NOI18N
        jLabel2.setForeground(mainTextColor);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Translation:");

        // Translation Input Text Field
        jTextField1.setFont(new java.awt.Font("Unispace", 0, 12)); // NOI18N
        jTextField1.setForeground(mainTextColor); // Set text color
        jTextField1.setBackground(secondaryButtonColor);
        jTextField1.setText("Translation");
        jTextField1.setBorder(null); // Removes White Border

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelLeftSideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(52, 52, 52)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanelLeftSideMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        // Show the UI in the middle of the screen
        setLocationRelativeTo(null);
        // Set visible
        this.setVisible(true);
    }// </editor-fold>                        

    // Setters
    public void setIntRightWords(int intRightWords) {
        myVars.setIntRightWords(intRightWords);
        config.save();
        jLabelRightWordsCount.setText(Integer.toString(myVars.getIntRightWords()));
    }
    public void setIntWrongWords(int intWrongWords) {
        myVars.setIntWrongWords(intWrongWords);
        config.save();
        jLabelWrongWordsCount.setText(Integer.toString(intWrongWords));
    }

    // Event Handler Methods                                                                         
    // TODO #17 Change vocab translation language depending on isGerToEngSelected Variable @Selin-SenSei
    private void jRadioButton2_EngToGerActionPerformed(ActionEvent evt) {    
        System.out.println("EngToGer selected!");
        myVars.setGerToEngSelected(false);       
        config.save();                                   
    }

    private void jRadioButton3_EngToGerActionPerformed(ActionEvent evt) {                                              
        System.out.println("GerToEng selected!");
        myVars.setGerToEngSelected(true);
        config.save();
    }
 
    // TODO #18 Start VoiceRecognition if VoiceRecogToggle is selected @Selin-SenSei,@TheOriginalAn3
    private void jRadioButton1_VoiceRecognitionActionPerformed(ActionEvent evt) {
        myVars.setVoiceToggleSelected(!myVars.isVoiceToggleSelected());
        System.out.println("Voice Recognition Selected: " + myVars.isVoiceToggleSelected());
        config.save();
    }

    private void jButton3_AddWordActionPerformed(ActionEvent evt) {
        System.out.println("Add Words button clicked12!");
        AddWordsUI addWordsUI = new AddWordsUI();
    }
    
    private void jButton4_RemEditWordActionPerformed(ActionEvent evt) {
        System.out.println("Remove / Edit Word button clicked!");
        EditRemoveWordsUI editRemoveWordsUI = new EditRemoveWordsUI();
    }

    // TODO: #24 Update right/wrong words based on user input @Selin-SenSei
    private void jTextField1ActionPerformed(ActionEvent evt) {
        inputText = jTextField1.getText();
        System.out.println("Text submited: " + inputText);
        jTextField1.setText("");
        showNewVocab();
    }
    // TODO #25 Show a random vocab in "jTextPane_ToTranslate" based on translation language after jTextField1ActionPerformed() @Selin-SenSei
    private void showNewVocab() {
        System.out.println("new vocab"); // Placeholder
    }
}
