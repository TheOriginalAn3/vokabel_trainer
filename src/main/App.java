package main;

import handlers.Config;
import handlers.MyVars;
import ui.MyGUI;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // 🗣️ Erzeugt eine myVars-Instanz. Es kann jeweils nur eine existieren.
        MyVars myVars = MyVars.getInstance();

        // 🗣️ Der Config-Konstruktor ruft automatisch den MyVars-Konstruktor auf und erzeugt eine MyVars Instanz, wenn nicht bereits eine existiert.
        Config config = Config.getInstance();

        // 🗣️ Laden von Variablen (aus der Konfigurationsdatei) in den RAM
        config.load();

        // 🗣️ GUI erstellen
        @SuppressWarnings("unused")
        MyGUI myGUI = new MyGUI(myVars, config); // Create GUI
    }
}
