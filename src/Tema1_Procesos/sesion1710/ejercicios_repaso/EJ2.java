package Tema1_Procesos.sesion1710.ejercicios_repaso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EJ2 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("cmd.exe", "/c","echo Hola mundo");

        try {
            Process p = pb.start();
            BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;

            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }

            int ExitCode = p.waitFor();
            System.out.println("El código de salida es: " + ExitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
