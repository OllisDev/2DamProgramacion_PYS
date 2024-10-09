package Tema1_Procesos.sesion2509;

import java.io.IOException;

public class ConfiguracionProceso {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "DIR");
        Process p = pb.start();
    }
}
