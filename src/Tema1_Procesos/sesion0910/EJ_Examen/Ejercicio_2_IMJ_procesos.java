package Tema1_Procesos.sesion0910.EJ_Examen;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio_2_IMJ_procesos {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("cmd.exe", "/c", "dir");
        pb.directory(new File("C://Users//Iker//Documents//2DamProgramacion_DI-master//2damprogramacion_DI"));

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
