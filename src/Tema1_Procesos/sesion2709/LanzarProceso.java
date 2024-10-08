package Tema1_Procesos.sesion2709;

import java.io.File;
import java.io.IOException;

public class LanzarProceso {
    public static void main(String[] args) throws IOException {
        String[] command = {"cmd", "/c", "dir", "o"};
        ProcessBuilder pb = new ProcessBuilder(command);

        pb.redirectInput(new File("output.txt"));
        pb.redirectErrorStream(true);
        //Process process = ProcessBuilder.start();

        ProcessBuilder pb1 = new ProcessBuilder("echo", "Hola");
        Process p1 = pb1.start();

        ProcessBuilder pb2 = new ProcessBuilder("grep", "Hola");
        pb2.redirectInput();
        Process p2 = pb2.start();

    }
}
