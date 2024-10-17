package Tema1_Procesos.sesion1710.repaso_processbuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lanzadorProcesos {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", " echo Hola mundo!"); //Instanciación de un ProcessBuilder
        try {
            Process p = pb.start();
            BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;

            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }
            int ExitCode = p.waitFor();
            System.out.println("Código de salida: " + ExitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
