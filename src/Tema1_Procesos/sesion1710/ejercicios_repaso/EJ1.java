package Tema1_Procesos.sesion1710.ejercicios_repaso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EJ1 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("cmd.exe", "/c", "dir");

        try {
            Process p = pb.start();
            BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;

            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }

            int ExitCode = p.waitFor();
            System.out.println("Codigo de salida: " + ExitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
