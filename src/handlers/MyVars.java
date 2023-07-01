package handlers;
public class MyVars {
    private int intRightWords;
    private int intWrongWords;
    private boolean isVoiceToggleSelected;
    private boolean isGerToEngSelected;

    private static MyVars instance = null; // 🗣️ Platzhalter. Reserviert Platz im Speicher für diese MyVars-Instanz. Nicht unbedingt nötig

    // 🗣️ Trick, den ich auf TikTok gesehen habe (Singleton-Methode, um nur ein einziges Objekt dieser Klasse existieren zu lassen).
    private MyVars() {
        
    }
    
    public static MyVars getInstance() {
        if(instance == null) {
            System.out.println("MyVars Object not existent...");
            instance = new MyVars();
        } else {
            System.out.println("MyVars Object already exists...");
        }
        System.out.println("Returning this instance");
        return instance;
    }
    // 🗣️ Ende des Tricks, den ich auf TikTok gesehen habe.


    // Setters
    public void setIntRightWords(int intRightWords) {
        this.intRightWords = intRightWords;
    }

    public void setIntWrongWords(int intWrongWords) {
        this.intWrongWords = intWrongWords;
    }

    public void setVoiceToggleSelected(boolean isVoiceToggleSelected) {
        this.isVoiceToggleSelected = isVoiceToggleSelected;
    }

    public void setGerToEngSelected(boolean isGerToEngSelected) {
        this.isGerToEngSelected = isGerToEngSelected;
    }
    
    // Getters
    public int getIntRightWords() {
        return intRightWords;
    }

    public int getIntWrongWords() {
        return intWrongWords;
    }

    public boolean isVoiceToggleSelected() {
        return isVoiceToggleSelected;
    }

    public boolean isGerToEngSelected() {
        return isGerToEngSelected;
    }

    // Methoden
    public void erhoeheRichtigeWorter(){
        intRightWords++;
    }
    public void erhoeheFalscheWorter(){
        intWrongWords++;
    }
}
