import java.io.IOException;

public class SpeechRecognition {
    private static SpeechRecognition instance = null;
    private ProcessBuilder pb;
    private Process p;

    // Trick I saw on TikTok (Singleton method to only allow one object of this class to exist)
    private SpeechRecognition() {
        // Normal constructor
    }

    public static SpeechRecognition getInstance() {
        if(instance == null) {
            System.out.println("SpeechRecognition Object not existent...");
            instance = new SpeechRecognition();
        } else {
            System.out.println("SpeechRecognition Object already exists...");
        }
        System.out.println("Returning this instance");
        return instance;
    }
    // This marks the end of the trick I saw on TikTok


    public void startEngRecognizer() {
            try {
                pb = new ProcessBuilder("python", "EngPythonRecognizer.py");
                p = pb.start();
            } catch (IOException e) {
                e.printStackTrace();
                p.destroy();
            }
        }

    public void startGerRecognizer() {
        try {
            pb = new ProcessBuilder("python", "GerPythonRecognizer.py");
            p = pb.start();
        } catch (IOException e) {
            e.printStackTrace();
            p.destroy();
        }
    }

}
