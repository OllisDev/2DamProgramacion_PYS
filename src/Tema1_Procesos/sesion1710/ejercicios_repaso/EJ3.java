package Tema1_Procesos.sesion1710.ejercicios_repaso;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class EJ3 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("cmd.exe", "/c", "echo Hola, soy Iker");
        pb.redirectOutput(new File("C://Users//Iker//Desktop//Fecha.txt"));

        try {
            Process p = pb.start();
            BufferedReader leer = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;

            while((line = leer.readLine()) != null) {
                System.out.println(line);
            }

            int ExitCode = p.waitFor();
            System.out.println("Código de salida: " + ExitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
