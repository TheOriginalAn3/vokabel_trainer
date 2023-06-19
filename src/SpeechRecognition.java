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
            System.out.println("An2");
            Socket socket = new Socket();
            int port = 1303;

            System.out.println("Hingewiesener Port:" + port);

            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);

            String receivedString = new String(buffer, 0, bytesRead);
            System.out.println("Von PYthon geschickt:" + receivedString);

            socket.close();
        } catch (IOException e) {
            // System.out.println("An1");
            e.printStackTrace();
            p.destroy();
        } catch (Exception a) {
            // System.out.println("An0");
            a.printStackTrace();
        }
        // transcription = getTranscriptionFromPython();
    }

    public void startGerRecognizer() {
        try {
            pb = new ProcessBuilder("python", "GerPythonRecognizer.py");
            p = pb.start();
        } catch (IOException e) {
            e.printStackTrace();
            p.destroy();
        }
        // transcription = getTranscriptionFromPython();
    }
}
