public class MyVars {
    private int intRightWords;
    private int intWrongWords;
    private boolean isVoiceToggleSelected;

    private static MyVars instance = null;

    // Trick I saw on TikTok (Singleton method to only allow one object of this class to exist)
    private MyVars() {
        // Exists only to defeat instantiation.
    }
    public static MyVars getInstance() {
        if(instance == null) {
            instance = new MyVars();
        } else {
            System.out.println("MyVars Object already exists!!!");
        }
        return instance;
    }
    // This marks the end of the trick i saw on TikTok


    public void setIntRightWords(int intRightWords) {
        this.intRightWords = intRightWords;
    }

    public void setIntWrongWords(int intWrongWords) {
        this.intWrongWords = intWrongWords;
    }

    public void setVoiceToggleSelected(boolean isVoiceToggleSelected) {
        this.isVoiceToggleSelected = isVoiceToggleSelected;
    }

    public int getIntRightWords() {
        return intRightWords;
    }

    public int getIntWrongWords() {
        return intWrongWords;
    }

    public boolean isVoiceToggleSelected() {
        return isVoiceToggleSelected;
    }

}
