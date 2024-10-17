package Tema1_Procesos.sesion1710.repaso_processbuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lanzadorProcesos3 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "find /c /v \"\" C://Users//Iker//Documents//2DamProgramacion_PYS-master//2DamProgramacion_PYS//src//Tema1_Procesos//sesion1710//repaso_processbuilder//lanzadorProcesos3.java");
        try {
            Process p = pb.start();
            BufferedReader leer = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;

            while ((line = leer.readLine()) != null) {
                System.out.println(line);
            }

            int ExitCode = p.waitFor();
            System.out.println("Codigo de salida: " + ExitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
