public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // Somit kann man nur 1 einziges objekt/instanz davon erstellen
        SpeechRecognition sr = SpeechRecognition.getInstance();

        //English -> Deutsch kommentar unten entfernen
        sr.startEngRecognizer();

        //Deutsch -> English kommentar unten entfernen
        //sr.starGerRecognizer();
    }
}
