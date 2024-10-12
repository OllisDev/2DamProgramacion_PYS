package Tema1_Procesos.sesion0910.EJ_Examen;

import java.io.IOException;

public class Ejercicio_3_IMJ_procesos {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("calc.exe");

        Process p = pb.start();
        System.out.println("El proceso ha comenzado y ha terminado");

    }
}
