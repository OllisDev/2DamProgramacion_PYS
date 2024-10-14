package Tema1_Procesos.sesion1410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EJ2_EjerciciosRepaso {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("cmd.exe", "/c", "echo Hola, soy Iker");

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
