package Tema1_Procesos.sesion2709;

public class ProcessBuilderExample3 {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb1 = new ProcessBuilder("ping", "google.com");
            ProcessBuilder pb2 = new ProcessBuilder("ping", "yahoo.com");

            Process p1 = pb1.start();
            Process p2 = pb2.start();

            // Esperar a que ambos procesos terminen
            p1.waitFor();
            p2.waitFor();

            System.out.println("Ambos procesos han terminado.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
