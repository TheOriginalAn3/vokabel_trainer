package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
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
import javax.swing.SwingConstants;

import handlers.Config;
import handlers.MyVars;
import handlers.SpeechRecognition;
import handlers.Vocab;

public class MyGUI extends JFrame {
    // 🗣️ Variablendeklaration - reserviert Platz im Speicher
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
    private JScrollPane jScrollPane;
    private JTextField jTextField;
    private JTextPane jTextPane_ToTranslate;

    // 🗣️ Zugriff auf Variablen aus der Konfigurationsdatei holen
    private MyVars myVars;
    // 🗣️ Zugriff auf die Speichermethode zum Speichern von Variablenänderungen
    private Config config;
    // 🗣️ Zugriff auf Vocab
    private Vocab vocab;
    // 🗣️ Zugriff auf SpeechRecognition
    private SpeechRecognition speechRecognition;

    // 🗣️ Farbvariablen werden hier einmal definiert, sonst muss jedes Mal, wenn eine
    // 🗣️ Farbe verwendet wird, ein neues Farbobjekt erstellt werden.
    private final Color MAIN_COLOR = new java.awt.Color(0x221f3a);
    private final Color MAIN_TEXT_COLOR = new java.awt.Color(0xcecdd8);
    private final Color SECONDARY_BUTTON_COLOR = new java.awt.Color(0x1f2223);
    private final Color SECONDARY_COLOR = new java.awt.Color(0x26233e);
    private final Color TERTIARY_COLOR = new java.awt.Color(0x2f2b4c);

    // 🗣️ Benutzereingaben von jTextField
    private String inputText;

    // 🗣️ Font-Variablen werden hier einmal definiert, sonst muss jedes Mal, wenn eine
    // 🗣️ Farbe verwendet wird, ein neues Font-Obj erstellt werden.
    private final Font MAIN_FONT = new Font("Unispace", 1, 14);
    private final Font SECONDARY_FONT = new Font("Unispace", 1, 12);

    // 🗣️ Mauszeiger
    private final Cursor HAND_POINTER = new Cursor(Cursor.HAND_CURSOR);

    public MyGUI(MyVars myVars, Config config) {
        vocab = Vocab.getInstance(); // "this." nicht benötigt, da ".getInstance()" benutzt wird.
        this.myVars = myVars;
        this.config = config;
        speechRecognition = SpeechRecognition.getInstance(); // "this." nicht benötigt, da ".getInstance()" benutzt
                                                             // wird.
        initComponents();
    }

    // 🗣️ Methode gestohlen von einem Spielprojekt, an dem ich arbeite.
    // 🗣️ Ganz genau kann ich das nicht mehr erklären da es schon ne weile her war
    // 🗣️ Link für das Github-Repositorium:
    // 🗣️ https://github.com/TheOriginalAn3/Some2DGame/blob/master/src/main/ImageHandler.java
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

    private void initComponents() {
        buttonGroup2 = new ButtonGroup();
        jPanelLeftSideMenu = new JPanel();
        jPanelRightWords = new JPanel();
        jLabelRightWords = new JLabel();
        jLabelRightWordsCount = new JLabel();
        jPanelWrongWords = new JPanel();
        jLabelWrongWords = new JLabel();
        jLabelWrongWordsCount = new JLabel();
        jRadioButton1_VoiceRecognition = new JRadioButton();
        jButton3_AddWord = new JButton();
        jButton4_RemEditWord = new JButton();
        jRadioButton2_EngToGer = new JRadioButton();
        jRadioButton3_GerToEng = new JRadioButton();
        jLabel7 = new JLabel();
        jPanel4 = new JPanel();
        jLabel5 = new JLabel();
        jScrollPane = new JScrollPane();
        jTextPane_ToTranslate = new JTextPane();
        jPanel5 = new JPanel();
        jTextField = new JTextField();
        jLabel2 = new JLabel();

        // Main pannel
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Vocabulary Trainer by Selin and Andrei");
        getContentPane().setBackground(MAIN_COLOR);
        setSize(635, 480);
        setResizable(false);
        setName("GUI");
        setIconImage(readImage("resources/images/logo_BingImageCreator.png"));

        // Left Side Menu
        jPanelLeftSideMenu.setBackground(SECONDARY_COLOR); // Set jPanel1 (Left menu pannel) color to #262a2b

        // Right Words
        jPanelRightWords.setBackground(TERTIARY_COLOR); // Panel color
        jLabelRightWords.setFont(MAIN_FONT);
        jLabelRightWords.setText("Right Words:");
        jLabelRightWords.setForeground(MAIN_TEXT_COLOR); // Text color

        jLabelRightWordsCount.setFont(MAIN_FONT);
        jLabelRightWordsCount.setForeground(MAIN_TEXT_COLOR); // Number color
        jLabelRightWordsCount.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelRightWordsCount.setText(Integer.toString(myVars.getIntRightWords())); // Set ammount of right words

        /*----------------------------------------------------------------------------------------------------------------------------------------*/
        // 🗣️ Ich habe keine Ahnung, was das macht 😅. Ich habe die GUI mithilfe von
        // 🗣️ NetBeans Scene Builder erstellt.
        // 🗣️ Ich denke, dies ist nur für den Abstand des Textes innerhalb des Bereichs
        // 🗣️ "Right Words".
        // 🗣️ Ich denke dies fügt auch die Beschriftungen als untergeordnete Komponenten
        // 🗣️ zum jPanelRightWords hinzu
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanelRightWords);
        jPanelRightWords.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelRightWords)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelRightWordsCount, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelRightWords, javax.swing.GroupLayout.DEFAULT_SIZE, 30,
                                                Short.MAX_VALUE)
                                        .addComponent(jLabelRightWordsCount))
                                .addContainerGap()));
        /*----------------------------------------------------------------------------------------------------------------------------------------*/

        // Wrong words
        jPanelWrongWords.setBackground(TERTIARY_COLOR); // Panel color
        jLabelWrongWords.setFont(MAIN_FONT);
        jLabelWrongWords.setForeground(MAIN_TEXT_COLOR); // Text color
        jLabelWrongWords.setText("Wrong Words:");

        jLabelWrongWordsCount.setFont(MAIN_FONT);
        jLabelWrongWordsCount.setForeground(MAIN_TEXT_COLOR); // Number color
        jLabelWrongWordsCount.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelWrongWordsCount.setText(Integer.toString(myVars.getIntWrongWords())); // Set ammount of wrong words

        /*----------------------------------------------------------------------------------------------------------------------------------------*/
        // 🗣️ Ich habe keine Ahnung, was das macht 😅. Ich habe die GUI mithilfe von
        // 🗣️ NetBeans Scene Builder erstellt.
        // 🗣️ Ich denke, dies ist nur für den Abstand des Textes innerhalb des Bereichs
        // 🗣️ "Wrong Words".
        // 🗣️ Ich denke dies fügt auch die Beschriftungen als untergeordnete Komponenten
        // 🗣️ zum jPanelWrongWords hinzu
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanelWrongWords);
        jPanelWrongWords.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelWrongWords)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelWrongWordsCount, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelWrongWords, javax.swing.GroupLayout.DEFAULT_SIZE, 30,
                                                Short.MAX_VALUE)
                                        .addComponent(jLabelWrongWordsCount))
                                .addContainerGap()));
        /*----------------------------------------------------------------------------------------------------------------------------------------*/

        // Vocie Recognition Toggle
        jRadioButton1_VoiceRecognition.setBackground(SECONDARY_COLOR);
        jRadioButton1_VoiceRecognition.setFont(new java.awt.Font("Unispace", 1, 12));
        jRadioButton1_VoiceRecognition.setForeground(MAIN_TEXT_COLOR); // Set text color
        jRadioButton1_VoiceRecognition.setText("Voice Recognition");
        jRadioButton1_VoiceRecognition.setToolTipText("!!ONLY WORKS WITH INTERNET CONNECTION!!\nSelected: Voice Recognition is on.\nDeselected: Voice Recognition is off.\nThis will use your microphone to analyze speech and convert it to text using Google API.");
        jRadioButton1_VoiceRecognition.setCursor(HAND_POINTER);
        jRadioButton1_VoiceRecognition.setSelected(myVars.isVoiceToggleSelected()); // Set state (selected/deselected).
        jRadioButton1_VoiceRecognition.setBorder(null);
        jRadioButton1_VoiceRecognition.setFocusable(false);
        jRadioButton1_VoiceRecognition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButton1_VoiceRecognitionActionPerformed(evt);
            }
        });

        // Add Word Button
        jButton3_AddWord.setBackground(TERTIARY_COLOR); // Set panel color
        jButton3_AddWord.setFont(new java.awt.Font("Unispace", 0, 12));
        jButton3_AddWord.setForeground(MAIN_TEXT_COLOR); // Set text color
        jButton3_AddWord.setText("Add a Word");
        jButton3_AddWord.setCursor(HAND_POINTER);
        jButton3_AddWord.setFocusable(false);
        jButton3_AddWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3_AddWordActionPerformed(evt);
            }
        });

        // Remove Edit Word Button
        jButton4_RemEditWord.setBackground(TERTIARY_COLOR); // Set panel color
        jButton4_RemEditWord.setFont(new java.awt.Font("Unispace", 0, 12));
        jButton4_RemEditWord.setForeground(MAIN_TEXT_COLOR); // Set text color
        jButton4_RemEditWord.setText("Remove / Edit a Word");
        jButton4_RemEditWord.setCursor(HAND_POINTER);
        jButton4_RemEditWord.setFocusable(false);
        jButton4_RemEditWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4_RemEditWordActionPerformed(evt);
            }
        });

        // Language Select Menu
        jLabel7.setFont(new java.awt.Font("Unispace", 0, 12));
        jLabel7.setText("Language Select:");
        jLabel7.setForeground(MAIN_TEXT_COLOR); // Set text color

        // English to German Toggle
        buttonGroup2.add(jRadioButton2_EngToGer);
        jRadioButton2_EngToGer.setFont(new java.awt.Font("Unispace", 0, 12));
        jRadioButton2_EngToGer.setSelected(!myVars.isGerToEngSelected()); // Read the state of the Toggle and set it to it's opposite.
        jRadioButton2_EngToGer.setText("English -> German");
        jRadioButton2_EngToGer.setBackground(SECONDARY_COLOR); // Set background color
        jRadioButton2_EngToGer.setForeground(MAIN_TEXT_COLOR); // Set text color
        jRadioButton2_EngToGer.setCursor(HAND_POINTER);
        jRadioButton2_EngToGer.setFocusable(false);
        jRadioButton2_EngToGer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButton2_EngToGerActionPerformed(evt);
            }
        });

        // German to English Toggle
        buttonGroup2.add(jRadioButton3_GerToEng);
        jRadioButton3_GerToEng.setFont(new java.awt.Font("Unispace", 0, 12));
        jRadioButton3_GerToEng.setSelected(myVars.isGerToEngSelected()); // Read the state of the Toggle and set it.
        jRadioButton3_GerToEng.setText("German -> English");
        jRadioButton3_GerToEng.setBackground(SECONDARY_COLOR); // Set background color
        jRadioButton3_GerToEng.setForeground(MAIN_TEXT_COLOR); // Set text color
        jRadioButton3_GerToEng.setCursor(HAND_POINTER);
        jRadioButton3_GerToEng.setFocusable(false);
        jRadioButton3_GerToEng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButton3_GerToEngActionPerformed(evt);
            }
        });

        /*----------------------------------------------------------------------------------------------------------------------------------------*/
        // 🗣️ Ich habe keine Ahnung, was das macht 😅. Code hier wurde von NetBeans Scene
        // 🗣️ Builder erstellt als ich die GUI zum ersten Mal Erstellt habe.
        // 🗣️ Ich denke, das legt das Layout für das linke Menüfeld fest.
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanelLeftSideMenu);
        jPanelLeftSideMenu.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton3_AddWord, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanelRightWords, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanelWrongWords, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton4_RemEditWord, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jRadioButton1_VoiceRecognition,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jRadioButton3_GerToEng, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jRadioButton2_EngToGer, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanelRightWords, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanelWrongWords, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton1_VoiceRecognition)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                .addContainerGap()));
        /*----------------------------------------------------------------------------------------------------------------------------------------*/

        // Word Display Pane
        jPanel4.setBackground(MAIN_COLOR); // Change pane color

        // Translate This Label
        jLabel5.setFont(MAIN_FONT);
        jLabel5.setForeground(MAIN_TEXT_COLOR); // Set text color
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setText("Translate this word:");

        // Word To Translate
        jTextPane_ToTranslate.setEditable(false);
        jTextPane_ToTranslate.setFont(MAIN_FONT);
        jTextPane_ToTranslate.setForeground(MAIN_TEXT_COLOR); // Set text color
        showNewVocab();
        jTextPane_ToTranslate.setBackground(SECONDARY_BUTTON_COLOR); // Set background color
        jScrollPane.setViewportView(jTextPane_ToTranslate);
        jScrollPane.setBorder(null); // Removes White Border

        /*----------------------------------------------------------------------------------------------------------------------------------------*/
        // 🗣️ Ich habe keine Ahnung, was das macht 😅. Code hier wurde von NetBeans Scene
        // 🗣️ Builder erstellt als ich die GUI zum ersten Mal Erstellt habe.
        // 🗣️ Ich denke, das legt das Layout für das rechte Feld fest.
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane)
                                        .addComponent(jLabel5))
                                .addContainerGap()));
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 216,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)));
        /*----------------------------------------------------------------------------------------------------------------------------------------*/

        // Write Translation Pane
        jPanel5.setBackground(MAIN_COLOR);

        // Translation Text
        jLabel2.setFont(SECONDARY_FONT);
        jLabel2.setForeground(MAIN_TEXT_COLOR);
        jLabel2.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel2.setText("Translation:");

        // Translation Input Text Field
        jTextField.setFont(SECONDARY_FONT);
        jTextField.setForeground(MAIN_TEXT_COLOR); // Set text color
        jTextField.setBackground(SECONDARY_BUTTON_COLOR);
        jTextField.setText("Translation");
        jTextField.setBorder(null); // Removes White Border
        jTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        /*----------------------------------------------------------------------------------------------------------------------------------------*/
        // 🗣️ Ich habe keine Ahnung, was das macht 😅. Code hier wurde von NetBeans Scene
        // 🗣️ Builder erstellt als ich die GUI zum ersten Mal Erstellt habe.
        // 🗣️ Ich denke, das legt das Layout für die Unterkomponenten des rechtes Feld
        // 🗣️ fest.
        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap()));
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap(7, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelLeftSideMenu, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(52, 52, 52)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addComponent(jPanelLeftSideMenu, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        /*----------------------------------------------------------------------------------------------------------------------------------------*/

         
        /* Automatically resize GUI to fit components. Not necesaraly needed but ill
        leave it in just in case i decide to change the size of something later. */
        pack();

        // 🗣️ Die Benutzeroberfläche in der Mitte des Bildschirms anzeigen
        setLocationRelativeTo(null);

        // 🗣️ Die Benutzeroberfläche anzeigen
        this.setVisible(true);
    }

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
    private void jRadioButton2_EngToGerActionPerformed(ActionEvent evt) {
        System.out.println("EngToGer selected!");
        myVars.setGerToEngSelected(false);
        config.save();
        jTextPane_ToTranslate.setText(vocab.getRandomVocab());
    }

    private void jRadioButton3_GerToEngActionPerformed(ActionEvent evt) {
        System.out.println("GerToEng selected!");
        myVars.setGerToEngSelected(true);
        config.save();
        jTextPane_ToTranslate.setText(vocab.getRandomVocab());
    }

    private void jRadioButton1_VoiceRecognitionActionPerformed(ActionEvent evt) {
        myVars.setVoiceToggleSelected(!myVars.isVoiceToggleSelected());
        // System.out.println("Voice Recognition Selected: " + myVars.isVoiceToggleSelected());
        // System.out.println(speechRecognition.getP()); // DEBUG Print - Check to see if Py program stopped
        if (myVars.isVoiceToggleSelected()) {
            if (myVars.isGerToEngSelected()) {
                inputText = speechRecognition.startEngRecognizer();
                // 🎸 Nächste if ist nicht unbedingt nötig aber ist gut zu haben - Andrei
                // if (hasSpeechRecognitionSucceded()) von Andrei vor abgabe noch dazu gemacht - Andrei
                if (hasSpeechRecognitionSucceded()) {
                    if (inputText.toLowerCase().contains(vocab.getTranslation().toLowerCase())) {
                        myVars.erhoeheRichtigeWorter();
                    } else {
                        myVars.erhoeheFalscheWorter();
                    }
                }
            } else {
                inputText = speechRecognition.startGerRecognizer();
                // 🎸 Nächste if ist nicht unbedingt nötig aber ist gut zu haben - Andrei
                // if (hasSpeechRecognitionSucceded()) von Andrei vor abgabe noch dazu gemacht - Andrei
                if (hasSpeechRecognitionSucceded()) {
                    if (inputText.toLowerCase().contains(vocab.getTranslation().toLowerCase())) {
                        myVars.erhoeheRichtigeWorter();
                    } else {
                        myVars.erhoeheFalscheWorter();
                    }
                }
            }
        }

        // 🗣️ Verhindert, dass man 2 Mal auf den Kippschalter klicken muss, um den
        // 🗣️ Spracherkennungsvorgang erneut zu starten. Dies setzt den Toggle-Status
        // 🗣️ zurück auf "nicht markiert".
        /* OLD CODE */
        // if (myVars.isVoiceToggleSelected()) {
        // jRadioButton1_VoiceRecognition.doClick();
        // }
        myVars.setVoiceToggleSelected(false);
        jRadioButton1_VoiceRecognition.setSelected(false);

        updateLabels();
        showNewVocab();
        config.save();
    }

    private void jButton3_AddWordActionPerformed(ActionEvent evt) {
        System.out.println("Add Words button clicked12!");
        // 🗣️ Show UI
        @SuppressWarnings("unused")
        AddWordsUI addWordsUI = new AddWordsUI();
    }

    private void jButton4_RemEditWordActionPerformed(ActionEvent evt) {
        System.out.println("Remove / Edit Word button clicked!");
        // 🗣️ Show UI
        @SuppressWarnings("unused")
        EditRemoveWordsUI editRemoveWordsUI = new EditRemoveWordsUI();
    }

    // 🗣️ Benutzereingabe
    private void jTextField1ActionPerformed(ActionEvent evt) {
        inputText = jTextField.getText();
        System.out.println("Text submited: " + inputText);
        jTextField.setText("");
        vocab.checkTranslation(inputText);
        updateLabels();
        showNewVocab();
        config.save();
    }

    private void showNewVocab() {
        jTextPane_ToTranslate.setText(vocab.getRandomVocab());
    }

    private void updateLabels() {
        jLabelRightWordsCount.setText(String.valueOf(myVars.getIntRightWords()));
        jLabelWrongWordsCount.setText(String.valueOf(myVars.getIntWrongWords()));
    }

    private boolean hasSpeechRecognitionSucceded() {
        if (inputText.equals("Google Speech Recognition could not understand audio")) {
            System.out.println("Google Speech Recognition could not understand audio");
            return false;
        } else if (inputText.equals("Could not request results from Google Speech Recognition service")) {
            System.out.println("Could not request results from Google Speech Recognition service");
            return false;
        } else
            return true;
    }
}
