package handlers;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

// 🗣️ Verwendung von Files and Paths (Importe), von Bing AI vorgeschlagen
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Vocab {

    // MyVars Objekt
    private MyVars myVars = MyVars.getInstance();

    // English words
    private String engVocabFile = "English.txt";
    private List<String> engVocabList;

    // German words
    private String gerVocabFile = "German.txt";
    private List<String> gerVocabList;

    // Random vocab
    private String[] vocab = { "engWord", "gerWord" };

    // 🗣️ ArrayList wird verwendet, um ein größenveränderbares "Array" zu erstellen.
    // 🗣️ Wird verwendet, um sicherzustellen, dass keine doppelten Zufallszahlen verwendet werden
    private List<Integer> generatedNumbers = new ArrayList<>();

    // Random number generator
    private Random random = new Random();

    // Randomly generated number
    private int randomListPosition;

    public void addNewWord(String engWord, String gerWord) {

        // 🗣️ Wahrscheinlich nicht notwendig, aber sicherheitshalber hinzugefügt.
        // 🗣️ Aktualisiert die Listen im Speicher mit den Wörtern/Sätzen aus den entsprechenden
        // 🗣️ Dateien.
        readFilesToLists();

        // 🗣️ Neue Wörter werden zu den Listen hinzugefügt
        try {
            engVocabList.add(engWord);
            gerVocabList.add(gerWord);

            // Update English.txt File
            BufferedWriter writerForEng = new BufferedWriter(new FileWriter(engVocabFile));
            for (String vocab : engVocabList) {
                writerForEng.write(vocab);
                writerForEng.newLine();
            }
            writerForEng.close();

            // Update German.txt File
            BufferedWriter writerForGer = new BufferedWriter(new FileWriter(gerVocabFile));
            for (String vocab : gerVocabList) {
                writerForGer.write(vocab);
                writerForGer.newLine();
            }
            writerForGer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 🗣️ Liefert einen String mit dem engVocab an Position 0 und dem gerVocab an Position 1
    public String getRandomVocab() {
        generateRandomNumber();
        vocab[0] = engVocabList.get(randomListPosition);
        vocab[1] = gerVocabList.get(randomListPosition);
        if (myVars.isGerToEngSelected()) {
            return vocab[1];
        } else {
            return vocab[0];
        }
    }

    public String getTranslation() {
        if (myVars.isGerToEngSelected()) {
            return vocab[0];
        } else {
            return vocab[1];
        }
    }

    public void checkTranslation(String inputText) {
        if (myVars.isGerToEngSelected()) {
            if (inputText.equalsIgnoreCase(vocab[0])) {
                myVars.erhoeheRichtigeWorter();
            } else {
                myVars.erhoeheFalscheWorter();
            }

        } else {
            if (inputText.equalsIgnoreCase(vocab[1])) {
                myVars.erhoeheRichtigeWorter();
            } else {
                myVars.erhoeheFalscheWorter();
            }

        }

    }

    // 🗣️ Erzeugt eine Zufallszahl und gibt sie zurück, wenn sie noch nicht verwendet wurde.
    private int generateRandomNumber() {
        if (generatedNumbers.size() == engVocabList.size()) {
            generatedNumbers.clear();
        }

        do {
            randomListPosition = random.nextInt(engVocabList.size());
        } while (generatedNumbers.contains(randomListPosition));

        generatedNumbers.add(randomListPosition);
        return randomListPosition;
    }

    private void readFilesToLists() {
        try {
            System.out.println("Reading Files to Lists...");
            engVocabList = Files.readAllLines(Paths.get(engVocabFile));
            gerVocabList = Files.readAllLines(Paths.get(gerVocabFile));

            // Convert List to Array -> not needed
            // String[] arr = lines.toArray(new String[0]);
        } catch (FileNotFoundException e) {
            System.out.println("Files not found!!!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error reading Files to Lists!");
            e.printStackTrace();
        }
    }

    // Returns an array with all vocabs. Dosnt need to
    public String[][] getAllVocabsAsArray() {
        String[][] vocabsArray = new String[engVocabList.size()][2];

        for (int i = 0; i < engVocabList.size(); i++) {
            vocabsArray[i][0] = engVocabList.get(i);
            vocabsArray[i][1] = gerVocabList.get(i);
        }

        return vocabsArray;
    }

    public void updateVocabs(String[][] updatedVocabsArray) {
        engVocabList.clear();
        gerVocabList.clear();

        try {
            for (int i = 0; i < updatedVocabsArray.length; i++) {
                engVocabList.add(updatedVocabsArray[i][0]);
                gerVocabList.add(updatedVocabsArray[i][1]);
            }

            // Update English.txt File
            BufferedWriter writerForEng = new BufferedWriter(new FileWriter(engVocabFile));
            for (String vocab : engVocabList) {
                if (!vocab.isBlank()) {
                    writerForEng.write(vocab);
                    writerForEng.newLine();
                }
            }
            writerForEng.close();

            // Update German.txt File
            BufferedWriter writerForGer = new BufferedWriter(new FileWriter(gerVocabFile));
            for (String vocab : gerVocabList) {
                if (!vocab.isBlank()) {
                    writerForGer.write(vocab);
                    writerForGer.newLine();
                }
            }
            writerForGer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // // Debug code to see if the lists get updated with the right words
        // System.out.println("00000000000000000 ENG LIST 0000000000000000");
        // for (String item : engVocabList) {
        // System.out.println(item);
        // }
        // System.out.println("000000000000000000000000000000000");

        // System.out.println("**************** GER LIST *****************");
        // for (String item : gerVocabList) {
        // System.out.println(item);
        // }
        // System.out.println("*********************************");
    }

    /*
     * Use the same TikTok trick from MyVars to only allow a single object/instance
     * of this class
     */
    private static Vocab instance = null;

    private Vocab() {
        // Exists only to defeat instantiation.
        readFilesToLists();
    }

    public static Vocab getInstance() {
        if (instance == null) {
            System.out.println("Vocab Object not existent...");
            instance = new Vocab();
        } else {
            System.out.println("Vocab Object already exists...");
        }
        System.out.println("Returning this instance");
        return instance;
    }
    // This marks the end of the trick i saw on TikTok
}
