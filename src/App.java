public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        //testGUI myGUI = new GUI(600, 400, "Vocabulary App by Selin and Andrei");
        MyGUI myGUI = new MyGUI();

        
        //Test
        System.out.println("Voice Recognition active: " + myGUI.isSelected_jRadioButton1_VoiceRecognition());
    }
}
