public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // Generates myVars object/instance. Only one can exist at a time.
        MyVars myVars = MyVars.getInstance();

        // Config constructor automatically calls MyVars constructor and creates MyVars object/instance if one dosn't already exist.
        Config config = Config.getInstance();

        // Load variables into memory
        config.load();

        //testGUI myGUI = new GUI(600, 400, "Vocabulary App by Selin and Andrei");
        MyGUI myGUI = new MyGUI(myVars, config); //Create GUI

        
        //Test
        System.out.println("Voice Recognition active: " + myVars.isVoiceToggleSelected());
    }
}
