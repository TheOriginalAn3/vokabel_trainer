import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
// Use of Files and Paths imports suggested by Bing AI
import java.util.Random;

public class Vocab {
    // English words
    private String engVocabFile = "English.txt";
    private List<String> engVocabList;

    // German words
    private String gerVocabFile = "German.txt";
    private List<String> gerVocabList;

    // Random vocab
    private String[] vocab = { "engWord", "gerWord" };

    // ArrayList is used to create a resizable array.
    // Used to make sure no dupplicate random numbers are used
    private List<Integer> generatedNumbers = new ArrayList<>();
    // Random number generator
    private Random random = new Random();
    // Randomly generated number
    private int randomListPosition;

    public void addNewWord(String engWord, String gerWord) {

        // Probably not necessary but added just to be safe.
        // Updates the Lists in memory with the words/sentences from the corresponding
        // files.
        readFilesToLists();

        // New Words get added to the Lists
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

    
    // Returns an array with the engVocab in pos 0 and gerVocab in pos 1
    public String[] getRandomVocab() {
        generateRandomNumber();
        vocab[0] = engVocabList.get(randomListPosition);
        vocab[1] = gerVocabList.get(randomListPosition);
        return vocab;
    }

    // Generates a random number and returns it, if it hasnt been used before.
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
            System.out.println("MyVars Object not existent...");
            instance = new Vocab();
        } else {
            System.out.println("MyVars Object already exists...");
        }
        System.out.println("Returning this instance");
        return instance;
    }
    // This marks the end of the trick i saw on TikTok
}
