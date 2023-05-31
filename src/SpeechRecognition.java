import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpeechRecognition {
    private static SpeechRecognition instance = null;
    private ProcessBuilder pb;
    private Process p;
    private String transcription;

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
            transcription = getTranscriptionFromPython();
        }

    public void startGerRecognizer() {
        try {
            pb = new ProcessBuilder("python", "GerPythonRecognizer.py");
            p = pb.start();
        } catch (IOException e) {
            e.printStackTrace();
            p.destroy();
        }
        transcription = getTranscriptionFromPython();
    }

    // TODO Change this to IPC using sockets
    private String getTranscriptionFromPython() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while (!p.isAlive() || in.ready()) {
                transcription = in.readLine();
                if (transcription != null && (!transcription.equalsIgnoreCase("Google Speech Recognition could not understand audio")) || (!transcription.equalsIgnoreCase("Could not request results from Google Speech Recognition service"))) {
                    System.out.println("Transcription: " + transcription);
                    System.out.println("Returning Transcription...");
                } else if (transcription.equalsIgnoreCase("Google Speech Recognition could not understand audio")) {
                    System.out.println(transcription);
                } else if (transcription.equalsIgnoreCase("Could not request results from Google Speech Recognition service")) {
                    System.out.println(transcription);
                } else {
                    System.out.println("Unexpected Problem hass occured with the Recognizer!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (transcription != null) {
            return transcription; 
        } else {
            return "error";
        }
        
    }

    public String getTranscription() {
        return transcription;
    }
}
