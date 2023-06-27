package handlers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SpeechRecognition {
    private static SpeechRecognition instance = null;
    private ProcessBuilder pb;
    private Process p;
    private String transcription;

    // Trick I saw on TikTok (Singleton method to only allow one object of this
    // class to exist)
    private SpeechRecognition() {
        // Normal constructor
    }

    public static SpeechRecognition getInstance() {
        if (instance == null) {
            System.out.println("SpeechRecognition Object not existent...");
            instance = new SpeechRecognition();
        } else {
            System.out.println("SpeechRecognition Object already exists...");
        }
        System.out.println("Returning this instance");
        return instance;
    }
    // This marks the end of the trick I saw on TikTok

    // TODO #19 Create a programm to start the Python Script
    public void startEngRecognizer() {
        // System.out.println("An3");
        try {
            pb = new ProcessBuilder("python", "EngPythonRecognizer.py");
            p = pb.start();
            getStringFromPython();
        } catch (Exception a) {
            // System.out.println("An0");
            a.printStackTrace();
            p.destroy();
        }
        // transcription = getTranscriptionFromPython();
    }

    public void startGerRecognizer() {
        try {
            pb = new ProcessBuilder("python", "GerPythonRecognizer.py");
            p = pb.start();
            getStringFromPython();
        } catch (Exception e) {
            e.printStackTrace();
            p.destroy();
        }
        // transcription = getTranscriptionFromPython();
    }
    private void getStringFromPython() {
        System.out.println("An2");
            Socket socket = new Socket();
            int port = 65432;

            System.out.println("Hingewiesener Port:" + port);
            try (InputStream input = socket.getInputStream()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                transcription = reader.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }
}
