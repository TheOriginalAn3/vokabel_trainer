package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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

public class MyNewGUI extends JFrame {

    // UI Elements:
    private JPanel mainPane;
    private ButtonGroup buttonGroup2;
    private JButton addWordButton;
    private JButton editRemoveWordsButton;
    private JLabel jLabelRightWords;
    private JLabel jLabel_Translation;
    private JLabel jLabelWrongWords;
    private JLabel jLabel_TranslateThis;
    private JLabel jLabel7;
    private JLabel jLabel_RightWordsCount;
    private JLabel jLabel_WrongWordsCount;
    private JPanel jPanelLeftSideMenu;
    private JPanel jPanelRightWords;
    private JPanel jPanelWrongWords;
    private JPanel wordDisplayPane;
    private JPanel wordTranslationPane;
    private JRadioButton voiceRecognitionToggle;
    private JRadioButton engToGerToggle;
    private JRadioButton gerToEngToggle;
    private JScrollPane jScrollPane1_VocabToTranslate;
    private JTextField translationInputField;
    private JTextPane jTextPane_VocabToTranslate;

    // Cursor
    private final Cursor HAND_CURSOR;

    // Font
    private final Font FONT;

    // Input Vocab
    private String inputText;

    // Colors
    private final Color MAIN_COLOR = new java.awt.Color(0x221f3a); // Dark Purple
    private final Color MAIN_TEXT_COLOR = new java.awt.Color(0xcecdd8);
    private final Color SECONDARY_BTN_COLOR = new java.awt.Color(0x1f2223);
    private final Color SECONDARY_COLOR = new java.awt.Color(0x26233e);
    private final Color TERTIARY_COLOR = new java.awt.Color(0x2f2b4c);

    private final int WIDTH = 600;
    private final int HEIGHT = 400;

    private MyVars myVars;
    private Config config;

    public MyNewGUI(MyVars myVars, Config config) {
        this.myVars = myVars;
        this.config = config;
        this.HAND_CURSOR = new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR);
        this.FONT = new java.awt.Font("Unispace", 0, 12);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setFocusable(true);
        this.setTitle("VT 01 by Selin & Andrei");
        this.setResizable(false);
        this.setIconImage(readImage("resources/images/logo_BingImageCreator.png"));
        this.getContentPane().setBackground(MAIN_COLOR);

        initComponents();
    }

    private void initComponents() {
        mainPane = new JPanel();
        buttonGroup2 = new ButtonGroup();
        jPanelLeftSideMenu = new JPanel();
        jPanelRightWords = new JPanel();
        jLabelRightWords = new JLabel();
        jLabel_RightWordsCount = new JLabel();
        jPanelWrongWords = new JPanel();
        jLabelWrongWords = new JLabel();
        jLabel_WrongWordsCount = new JLabel();
        voiceRecognitionToggle = new JRadioButton();
        addWordButton = new JButton();
        editRemoveWordsButton = new JButton();
        engToGerToggle = new JRadioButton();
        gerToEngToggle = new JRadioButton();
        jLabel7 = new JLabel();
        wordDisplayPane = new JPanel();
        jLabel_TranslateThis = new JLabel();
        jScrollPane1_VocabToTranslate = new JScrollPane();
        jTextPane_VocabToTranslate = new JTextPane();
        wordTranslationPane = new JPanel();
        translationInputField = new JTextField();
        jLabel_Translation = new JLabel();

        initMainPane();
        initLeftSideMenu();
        initRightWrongWords();
        initVoiceRecogToggle();
        initButtons();
        initLanguageSelect();
        initVocabPane();

        mainPane.setVisible(true);
        this.setVisible(true);
    }

    private void initMainPane() {
        mainPane.setBackground(MAIN_COLOR);
        mainPane.setSize(WIDTH, HEIGHT);
        mainPane.setLocation(0, 0);

        this.add(mainPane);
    }

    private void initLeftSideMenu() {
        jPanelLeftSideMenu.setBackground(SECONDARY_COLOR);
        jPanelLeftSideMenu.setSize(500, 500);
        jPanelLeftSideMenu.setLocation(10, 10);

        mainPane.add(jPanelLeftSideMenu);
    }

    private void initRightWrongWords() {
        // Right Words
        jPanelRightWords.setBackground(TERTIARY_COLOR); // Panel color
        jPanelRightWords.setSize(10, 10);
        jPanelRightWords.setLocation(25, 25);

        jLabelRightWords.setFont(FONT); // NOI18N
        jLabelRightWords.setText("Right Words:");
        jLabelRightWords.setForeground(MAIN_TEXT_COLOR);// Text color

        jLabel_RightWordsCount.setFont(FONT); // NOI18N
        jLabel_RightWordsCount.setForeground(MAIN_TEXT_COLOR); // Number color
        // jLabelRightWordsCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_RightWordsCount.setText(Integer.toString(myVars.getIntRightWords())); // Set ammount of right words

        mainPane.add(jPanelRightWords);

        // Wrong words
        jPanelWrongWords.setBackground(TERTIARY_COLOR); // Panel color
        jLabelWrongWords.setFont(FONT); // NOI18N
        jLabelWrongWords.setForeground(MAIN_TEXT_COLOR); // Text color
        jLabelWrongWords.setText("Wrong Words:");

        jLabel_WrongWordsCount.setFont(FONT); // NOI18N
        jLabel_WrongWordsCount.setForeground(MAIN_TEXT_COLOR); // Number color
        // jLabelWrongWordsCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_WrongWordsCount.setText(Integer.toString(myVars.getIntWrongWords())); // Set ammount of wrong words
    }

    private void initVoiceRecogToggle() {
        // Vocie Recognition Toggle
        voiceRecognitionToggle.setBackground(SECONDARY_COLOR);
        voiceRecognitionToggle.setFont(FONT); // NOI18N
        voiceRecognitionToggle.setForeground(MAIN_TEXT_COLOR); // Set text color
        voiceRecognitionToggle.setText("Voice Recognition");
        voiceRecognitionToggle.setToolTipText(
                "!!ONLY WORKS WITH INTERNET CONNECTION!! Selected: Voice Recognition is on. Deselected: Voice Recognition is off. This will use your microphone to analyze speech and convert it to text using Google API.");
        voiceRecognitionToggle.setCursor(HAND_CURSOR);
        voiceRecognitionToggle.setSelected(myVars.isVoiceToggleSelected()); // Set state (selected/deselected).
                                                                            // This code calls the
        voiceRecognitionToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voiceRecognitionToggleClicked(evt);
            }
        });
    }

    private void initButtons() {
        // Add Word Button
        addWordButton.setBackground(TERTIARY_COLOR); // Set panel color
        addWordButton.setFont(FONT); // NOI18N
        addWordButton.setForeground(MAIN_TEXT_COLOR); // Set text color
        addWordButton.setText("Add a Word");
        addWordButton.setCursor(HAND_CURSOR);
        addWordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWordButtonClicked(evt);
            }
        });

        // Remove Edit Word Button
        editRemoveWordsButton.setBackground(TERTIARY_COLOR); // Set panel color
        editRemoveWordsButton.setFont(new java.awt.Font("Unispace", 0, 12)); // NOI18N
        editRemoveWordsButton.setForeground(MAIN_TEXT_COLOR); // Set text color
        editRemoveWordsButton.setText("Remove / Edit a Word");
        editRemoveWordsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editRemoveWordsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRemoveWordsButtonClicked(evt);
            }
        });
    }

    private void initLanguageSelect() {
        // Language Select Menu
        jLabel7.setFont(FONT); // NOI18N
        jLabel7.setText("Language Select:");
        jLabel7.setForeground(MAIN_TEXT_COLOR); // Set text color

        // English to German Toggle
        // Group buttons together to only allow one selection at a time
        buttonGroup2.add(engToGerToggle);

        engToGerToggle.setFont(FONT); // NOI18N
        engToGerToggle.setSelected(!myVars.isGerToEngSelected()); // Read the state of the Toggle and set it to its
                                                                  // opposite.
        engToGerToggle.setText("English -> German");
        engToGerToggle.setBackground(SECONDARY_COLOR); // Set background color
        engToGerToggle.setForeground(MAIN_TEXT_COLOR); // Set text color
        engToGerToggle.setCursor(HAND_CURSOR);
        engToGerToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engToGerToggleActionPerformed(evt);
            }
        });

        // German to English Toggle
        buttonGroup2.add(gerToEngToggle);
        gerToEngToggle.setFont(FONT); // NOI18N
        gerToEngToggle.setSelected(myVars.isGerToEngSelected()); // Read the state of the Toggle and set it.
        gerToEngToggle.setText("German -> English");
        gerToEngToggle.setBackground(SECONDARY_COLOR); // Set background color
        gerToEngToggle.setForeground(MAIN_TEXT_COLOR); // Set text color
        gerToEngToggle.setCursor(HAND_CURSOR);
        gerToEngToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerToEngToggleActionPerformed(evt);
            }
        });
    }

    private void initVocabPane() {
        // Word Display Pane
        wordDisplayPane.setBackground(SECONDARY_COLOR);

        // "Translate This" Label
        jLabel_TranslateThis.setFont(FONT); // NOI18N
        jLabel_TranslateThis.setForeground(MAIN_TEXT_COLOR); // Set text color
        // jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_TranslateThis.setText("Translate this word:");

        // Word To Translate
        jTextPane_VocabToTranslate.setEditable(false);
        jTextPane_VocabToTranslate.setFont(FONT); // NOI18N
        jTextPane_VocabToTranslate.setForeground(MAIN_TEXT_COLOR); // Set text color
        jTextPane_VocabToTranslate.setText("to do sth without knowing what youre doing");
        // jTextPane_ToTranslate.setAutoscrolls(true);
        jTextPane_VocabToTranslate.setBackground(SECONDARY_BTN_COLOR); // Set background color
        jScrollPane1_VocabToTranslate.setViewportView(jTextPane_VocabToTranslate);

        /*
         * ---------------------------------------------------------------------------
         */

        // Write Translation Pane
        wordTranslationPane.setBackground(MAIN_COLOR);
        // Translation Text
        jLabel_Translation.setFont(FONT); // NOI18N
        jLabel_Translation.setForeground(MAIN_TEXT_COLOR);
        jLabel_Translation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Translation.setText("Translation:");

        // Translation Input Text Field
        translationInputField.setFont(FONT); // NOI18N
        translationInputField.setForeground(MAIN_TEXT_COLOR); // Set text color
        translationInputField.setBackground(SECONDARY_BTN_COLOR);
        translationInputField.setText("Translation");

        translationInputField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translationInputFieldActionPerformed(evt);
            }
        });
    }

    // Setters
    public void setIntRightWords(int intRightWords) {
        myVars.setIntRightWords(intRightWords);
        config.save();
        jLabel_RightWordsCount.setText(Integer.toString(myVars.getIntRightWords()));
    }

    public void setIntWrongWords(int intWrongWords) {
        myVars.setIntWrongWords(intWrongWords);
        config.save();
        jLabel_WrongWordsCount.setText(Integer.toString(intWrongWords));
    }

    // Event Handlers
    // Each component that does something has its own event handler class
    // TODO #18 Start VoiceRecognition if VoiceRecogToggle is selected
    private void voiceRecognitionToggleClicked(java.awt.event.ActionEvent evt) {
        myVars.setVoiceToggleSelected(!myVars.isVoiceToggleSelected());
        System.out.println("Voice Recognition Selected: " + myVars.isVoiceToggleSelected());
        config.save();
    }

    // TODO #14 Add a way to input new words when "Add Word" is clicked
    private void addWordButtonClicked(java.awt.event.ActionEvent evt) {
        System.out.println("Add Words button clicked!");
    }

    // TODO #15 Add a way to edit or remove (a) specific word when "Remove/Edit
    // Word" is clicked
    private void editRemoveWordsButtonClicked(java.awt.event.ActionEvent evt) {
        System.out.println("Remove / Edit Word button clicked!");
    }

    private void engToGerToggleActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("EngToGer selected!");
        myVars.setGerToEngSelected(false);
        config.save();
    }

    private void gerToEngToggleActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("GerToEng selected!");
        myVars.setGerToEngSelected(true);
        config.save();
    }

    private void translationInputFieldActionPerformed(java.awt.event.ActionEvent evt) {
        inputText = translationInputField.getText();
        System.out.println("Text submited: " + inputText);
        translationInputField.setText(""); // Clear the field after submitting text

    }

    /*
     * Method stolen from a game project im working on
     * Link for the github repo:
     * https://github.com/TheOriginalAn3/Some2DGame/blob/master/src/main/
     * ImageHandler.java
     */
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

}
