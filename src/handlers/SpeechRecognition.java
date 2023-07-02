package handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SpeechRecognition {
    private static SpeechRecognition instance = null;
    private ProcessBuilder pb;
    private Process p;
    private String stringFromPython;

    // 🗣️ Trick, den ich auf TikTok gesehen habe (Singleton-Methode, um nur ein einziges Objekt dieser Klasse existieren zu lassen).
    private SpeechRecognition() {
        
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
    // 🗣️ Ende des Tricks, den ich auf TikTok gesehen habe.

    // Nur Python Skript starten
    // public void startEngRecognizer() {
    //     System.out.println("Starting English Recognizer");
    //     try {
    //         pb = new ProcessBuilder("python", "EngPythonRecognizer.py");
    //         p = pb.start();
    //     } catch (Exception a) {
    //         a.printStackTrace();
    //         p.destroy();
    //     }
    // }

    // public void startGerRecognizer() {
    //     System.out.println("Starting German Recognizer");
    //     try {
    //         pb = new ProcessBuilder("python", "GerPythonRecognizer.py");
    //         p = pb.start();
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         p.destroy();
    //     }
    // }

    public String startEngRecognizer() {
        System.out.println("Starting English Recognizer");
        // start new process
        try {
            pb = new ProcessBuilder("python", "resources/EngPythonRecognizer.py");
            p = pb.start();
            getStringFromPython();
        } catch (Exception a) {
            a.printStackTrace();
            p.destroy();
        }
        return stringFromPython;
    }

    public String startGerRecognizer() {
        System.out.println("Starting German Recognizer");
        // start new process
        try {
            pb = new ProcessBuilder("python", "resources/GerPythonRecognizer.py");
            p = pb.start();
            getStringFromPython();
        } catch (Exception e) {
            e.printStackTrace();
            p.destroy();
        }
        return stringFromPython;
    }

    private String getStringFromPython() {
        int port = 65432;
        Socket socket;
        try {
            Thread.sleep(1000); // Socket verbindung ist zu schnell 😊
            socket = new Socket("localhost", port);
            System.out.println("Hingewiesener Port:" + port);

            //PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Java -> Python
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //out.println("Hello from Java!"); // Java -> Python
            stringFromPython = in.readLine();
            System.out.println("From Python: " + stringFromPython);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        return stringFromPython;
    }

    // DEBUG Methode
    public Process getP() {
        return p;
    }
}
