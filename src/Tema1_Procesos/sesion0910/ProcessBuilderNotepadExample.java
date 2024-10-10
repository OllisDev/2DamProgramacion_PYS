package Tema1_Procesos.sesion0910;

import java.io.IOException;

public class ProcessBuilderNotepadExample {
    public static void main(String[] args) {
        // Crea el proceso para abrir Notepad
        ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe");

        try {
            // Inicia el proceso
            Process process = processBuilder.start();

            // Espera a que el proceso termine
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Notepad cerrado con código de salida: " + exitCode);

                ProcessBuilder processBuilder2 = new ProcessBuilder("notepad.exe");
                Process process2 = processBuilder2.start();
                exitCode = process2.waitFor();
            }


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

