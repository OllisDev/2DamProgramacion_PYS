package Tema1_Procesos.sesion2011;

public class calculadora {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("calc.exe");
        try {
            pb.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
