package Tema1_Procesos.sesion0910.EJ_Examen;

import java.io.File;
import java.io.IOException;

public class Ejercicio_4_IMJ_procesos {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("cmd.exe", "/c", "date fecha.txt");
        pb.redirectOutput(new File("C:/Users/Iker/Desktop/fecha.txt"));

        Process p = pb.start();
    }
}
