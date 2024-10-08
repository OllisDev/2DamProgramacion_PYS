package Tema1_Procesos.sesion2609;

import java.io.IOException;

public class Command {
    public static void main(String[] args) {
        EjecutarNotepad();




    }

    private static void EjecutarNotepad() {
        try {
            ProcessBuilder pb = new ProcessBuilder("Notepad.exe");
            Process p = pb.start();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }




}
