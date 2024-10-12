package Tema1_Procesos.sesion0910.EJ_Examen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio_1_IMJ_procesos {
    public static void main(String[] args) {
        //Instanciación de un objeto ProcessBuilder para crear un proceso y ejecute un echo Hola Mundo mediante linea de comandos (cmd)
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("cmd.exe", "/c", "echo Hola Mundo");
        try {
            Process p = pb.start();
            BufferedReader leer = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;

            while ((line = leer.readLine()) != null) {
                System.out.println(line);
            }

            int ExitCode = p.waitFor();
            System.out.println("Código de salida: " + ExitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
