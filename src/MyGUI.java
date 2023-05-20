public class MyGUI extends javax.swing.JFrame {

    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1_Settings;
    private javax.swing.JButton jButton2_Home;
    private javax.swing.JButton jButton3_AddWord;
    private javax.swing.JButton jButton4_RemEditWord;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_RightWords;
    private javax.swing.JLabel jLabel_WrongWords;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1_VoiceRecognition;
    private javax.swing.JRadioButton jRadioButton2_EngToGer;
    private javax.swing.JRadioButton jRadioButton3_GerToEng;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane_ToTranslate;

    // TODO #3 This variables should be read and saved from/to a File
    // Temporary default states
    private int intRightWords = 134;
    private int intWrongWords = 971;
    private boolean stateVocieRecognitionToggle = false; 

    // TODO #4 Variables should be created for the UI Colors
    /* 
    Create Variables For Colors
    */
    // End of variables declaration       

    public MyGUI() {
        initComponents();
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
        jPanel1 = new javax.swing.JPanel();
        jButton1_Settings = new javax.swing.JButton();
        jButton2_Home = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_RightWords = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel_WrongWords = new javax.swing.JLabel();
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
        setBackground(new java.awt.Color(0x262a2b));
        setSize(470, 245);
        setResizable(false);
        setName("GUI"); // NOI18N

        // Left Side Menu
        jPanel1.setBackground(new java.awt.Color(0x262a2b)); // Set jPanel1 (Left menu pannel) color to #262a2b

        // Settings Button
        jButton1_Settings.setBackground(new java.awt.Color(0x624d35)); // Set Settings button color to #624d35
        jButton1_Settings.setFont(new java.awt.Font("Unispace", 1, 13)); // NOI18N
        jButton1_Settings.setText("Settings");
        jButton1_Settings.setForeground(new java.awt.Color(0xdbd8d3)); // Set text color to #dbd8d3
        jButton1_Settings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1_Settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_SettingsActionPerformed(evt);
            }
        });

        // Home Button
        jButton2_Home.setBackground(new java.awt.Color(0x624d35)); // Set home button color to #624d35
        jButton2_Home.setFont(new java.awt.Font("Unispace", 1, 13)); // NOI18N
        jButton2_Home.setText("Home");
        jButton2_Home.setForeground(new java.awt.Color(0xdbd8d3)); // Set text color to #dbd8d3
        jButton2_Home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_HomeActionPerformed(evt);
            }
        });
        
        // Right Words
        jPanel2.setBackground(new java.awt.Color(0x4ca06a)); // Panel color
        jLabel1.setFont(new java.awt.Font("Unispace", 1, 14)); // NOI18N
        jLabel1.setText("Right Words:");
        jLabel1.setForeground(new java.awt.Color(0x262a2b)); // Text color

        jLabel_RightWords.setFont(new java.awt.Font("Unispace", 1, 14)); // NOI18N
        jLabel_RightWords.setForeground(new java.awt.Color(0x262a2b)); // Number color
        jLabel_RightWords.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_RightWords.setText(Integer.toString(intRightWords)); // Set ammount of right words
        
        // I have no idea what this does. I just built and sized the GUI using NetBeans Scene Builder
        // I think this is just for spacing the text inside the "Right Words" pane
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_RightWords, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel_RightWords))
                .addContainerGap())
        );


        // Wrong words
        jPanel3.setBackground(new java.awt.Color(250, 117, 117)); // Panel color
        jLabel3.setFont(new java.awt.Font("Unispace", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0x262a2b)); // Text color
        jLabel3.setText("Wrong Words:");

        jLabel_WrongWords.setFont(new java.awt.Font("Unispace", 1, 14)); // NOI18N
        jLabel_WrongWords.setForeground(new java.awt.Color(0x262a2b)); // Number color
        jLabel_WrongWords.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_WrongWords.setText(Integer.toString(intWrongWords)); // Set ammount of wrong words
        
        // I have no idea what this does. I just built and sized the GUI using NetBeans Scene Builder
        // I think this is just for spacing the text inside the "Wrong Words" pane
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_WrongWords, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel_WrongWords))
                .addContainerGap())
        );


        // Vocie Recognition Toggle
        jRadioButton1_VoiceRecognition.setBackground(new java.awt.Color(0x262a2b));
        jRadioButton1_VoiceRecognition.setFont(new java.awt.Font("Unispace", 1, 12)); // NOI18N
        jRadioButton1_VoiceRecognition.setForeground(new java.awt.Color(0xdbd8d3)); // Set text color
        jRadioButton1_VoiceRecognition.setText("Voice Recognition");
        jRadioButton1_VoiceRecognition.setToolTipText("!!ONLY WORKS WITH INTERNET CONNECTION!!\nSelected: Voice Recognition is on.\nDeselected: Voice Recognition is off.\nThis will use your microphone to analyze speech and convert it to text using Google API.");
        jRadioButton1_VoiceRecognition.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton1_VoiceRecognition.setSelected(stateVocieRecognitionToggle); // Set state (selected/deselected). This code calls the 
        jRadioButton1_VoiceRecognition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1_VoiceRecognitionActionPerformed(evt);
            }
        });


        // Add Word Button
        jButton3_AddWord.setBackground(new java.awt.Color(0x1f2223)); // Set panel color
        jButton3_AddWord.setFont(new java.awt.Font("Unispace", 0, 12)); // NOI18N
        jButton3_AddWord.setForeground(new java.awt.Color(0xdbd8d3)); // Set text color
        jButton3_AddWord.setText("Add a Word");
        jButton3_AddWord.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3_AddWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_AddWordActionPerformed(evt);
            }
        });


        // Remove Edit Word Button
        jButton4_RemEditWord.setBackground(new java.awt.Color(0x1f2223)); // Set panel color
        jButton4_RemEditWord.setFont(new java.awt.Font("Unispace", 0, 12)); // NOI18N
        jButton4_RemEditWord.setForeground(new java.awt.Color(0xdbd8d3)); // Set text color
        jButton4_RemEditWord.setText("Remove / Edit a Word");
        jButton4_RemEditWord.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4_RemEditWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4_RemEditWordActionPerformed(evt);
            }
        });


        // Language Select Menu
        jLabel7.setFont(new java.awt.Font("Unispace", 0, 12)); // NOI18N
        jLabel7.setText("Language Select:");
        jLabel7.setForeground(new java.awt.Color(0xdbd8d3)); // Set text color

        // English to German Toggle
        buttonGroup2.add(jRadioButton2_EngToGer);
        jRadioButton2_EngToGer.setFont(new java.awt.Font("Unispace", 0, 12)); // NOI18N
        jRadioButton2_EngToGer.setSelected(true); // set the default state of the toggle. // TODO Save/Read tarnslate mode to/from File @TheOriginalAn3
        jRadioButton2_EngToGer.setText("English -> German");
        jRadioButton2_EngToGer.setBackground(new java.awt.Color(0x262a2b)); // Set background color
        jRadioButton2_EngToGer.setForeground(new java.awt.Color(0xdbd8d3)); // Set text color

        jRadioButton2_EngToGer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2_EngToGerActionPerformed(evt);
            }
        });

        // German to English Toggle
        buttonGroup2.add(jRadioButton3_GerToEng);
        jRadioButton3_GerToEng.setFont(new java.awt.Font("Unispace", 0, 12)); // NOI18N
        jRadioButton2_EngToGer.setSelected(true); // set the default state of the toggle. // TODO Save/Read tarnslate mode to/from File @TheOriginalAn3
        jRadioButton3_GerToEng.setText("German -> English");
        jRadioButton3_GerToEng.setBackground(new java.awt.Color(0x262a2b)); // Set background color
        jRadioButton3_GerToEng.setForeground(new java.awt.Color(0xdbd8d3)); // Set text color
        jRadioButton3_GerToEng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3_EngToGerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3_AddWord, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1_Settings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2_Home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jButton1_Settings, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        // TODO #5 BUG: window resizes with the lenght of the word @TheOriginalAn3
        // Word Display Pane
        jPanel4.setBackground(new java.awt.Color(0x262a2b)); // Change pane color

        // Translate This Label
        jLabel5.setFont(new java.awt.Font("Unispace", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0xdbd8d3)); // Set text color
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Translate this word:");

        // Word To Translate
        jTextPane_ToTranslate.setEditable(false);
        jTextPane_ToTranslate.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        jTextPane_ToTranslate.setForeground(new java.awt.Color(0xdbd8d3)); // Set text color
        jTextPane_ToTranslate.setText("to do sth without knowing what youre doing");
        jTextPane_ToTranslate.setAutoscrolls(false);
        jTextPane_ToTranslate.setBackground(new java.awt.Color(0x1f2223)); // Set background color
        jScrollPane1.setViewportView(jTextPane_ToTranslate);

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
        jPanel5.setBackground(new java.awt.Color(0x262a2b));

        // Translation Text
        jLabel2.setFont(new java.awt.Font("Unispace", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0xdbd8d3));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Translation:");

        // Translation Input Text Field
        jTextField1.setFont(new java.awt.Font("Unispace", 0, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0xdbd8d3)); // Set text color
        jTextField1.setBackground(new java.awt.Color(0x1f2223));
        jTextField1.setText("Translation");

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();

        // Set visible
        this.setVisible(true);
    }// </editor-fold>                        

    // Getters
    public int getIntRightWords() {
        return intRightWords;
    }
    public int getIntWrongWords() {
        return intWrongWords;
    }
    public boolean getStateVocieRecognitionToggle() {
        stateVocieRecognitionToggle = jRadioButton1_VoiceRecognition.isSelected();
        return stateVocieRecognitionToggle;
    }

    // Setters
    public void setIntRightWords(int intRightWords) {
        this.intRightWords = intRightWords;
        jLabel_RightWords.setText(Integer.toString(intRightWords));
    }
    public void setIntWrongWords(int intWrongWords) {
        this.intWrongWords = intWrongWords;
        jLabel_WrongWords.setText(Integer.toString(intWrongWords));
    }

    // Event Handler Methods
    private void jButton1_SettingsActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.out.println("Settings button clickerd!");
    }                                        

    private void jButton2_HomeActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.out.println("Home button clicked!");
    }                                        

    private void jRadioButton2_EngToGerActionPerformed(java.awt.event.ActionEvent evt) {                                              
        System.out.println("EngToGer selected!");
    }

    private void jRadioButton3_EngToGerActionPerformed(java.awt.event.ActionEvent evt) {                                              
        System.out.println("GerToEng selected!");
    }
 
    private void jRadioButton1_VoiceRecognitionActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Voice Recognition Selected: " + getStateVocieRecognitionToggle());
    }

    private void jButton3_AddWordActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Add Words button clicked!");
    }

    private void jButton4_RemEditWordActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Remove / Edit Word button clicked!");
    }
}
