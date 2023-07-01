package handlers;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Config {

    private MyVars variables;

    private static Config instance = null; // Platzhalter. Reserviert Platz im Speicher für eine Config-Instanz. Nicht unbedingt nötig

    // MyVars liefert eine MyVars-Instanz, falls bereits eine vorhanden ist. MyVars Konstruktor erzeugt eine neue MyVars-Instanz, wenn noch keine existiert.
    // Trick, den ich auf TikTok gesehen habe (Singleton-Methode, um nur ein einziges Objekt dieser Klasse existieren zu lassen).
    private Config() {
        this.variables = MyVars.getInstance();
    }
    
    public static Config getInstance() {
        if(instance == null) {
            System.out.println("Config Object not existent...");
            instance = new Config();
        } else {
            System.out.println("Config Object already exists...");
        }
        System.out.println("Returning this instance");
        return instance;
    }
    // Ende des Tricks, den ich auf TikTok gesehen habe.


/*
     * BITTE BEFOLGEN SIE DIESE REIHE BEIM SPEICHERN ODER LADEN VON VARIABELN:
     * 1. intRightWords
     * 2. intWrongWords
     * 3. isVoiceToggleSelected
     * 4. isGerToEngSelected
     */

    public void save() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("resources/config.txt"));

            // intRightWords
            bw.write(Integer.toString(variables.getIntRightWords()));
            bw.newLine();

            // intWrongWords
            bw.write(Integer.toString(variables.getIntWrongWords()));
            bw.newLine();

            // isVoiceToggleSelected
            bw.write(Boolean.toString(variables.isVoiceToggleSelected()));
            bw.newLine();

            // isGerToEngSelected
            bw.write(Boolean.toString(variables.isGerToEngSelected()));

            bw.close();

            // DEBUG: Print saved variables to console
            System.out.println("Printing Variables after saving...");
            printVars();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("resources/config.txt"));

            // intRightWords
            variables.setIntRightWords(Integer.parseInt(br.readLine()));

            // intWrongWords
            variables.setIntWrongWords(Integer.parseInt(br.readLine()));

            // isVoiceToggleSelected
            variables.setVoiceToggleSelected(Boolean.parseBoolean(br.readLine()));

            // isGerToEngSelected
            variables.setGerToEngSelected(Boolean.parseBoolean(br.readLine()));

            br.close();

            // DEBUG: Print Variables loaded from file to console
            System.out.println("Printing variables loaded into memory from file...");
            printVars();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // DEBUG Methode
    public void printVars() {
        System.out.println("intRightWords: " + variables.getIntRightWords());
        System.out.println("intWrongWords: " + variables.getIntWrongWords());
        System.out.println("isVoiceToggleSelected: " + variables.isVoiceToggleSelected());
        System.out.println("isGerToEngSelected: " + variables.isGerToEngSelected());
        System.out.println("-----------------------------------------------------------");
    }

}
