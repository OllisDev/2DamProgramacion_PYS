package Tema1_Procesos.sesion2609;

public class Lanzador {

    public static void ejecutar(String Ruta) {
        ProcessBuilder pb; //Clase que nos permite crear procesos del SO
        try {
            pb = new ProcessBuilder(Ruta);
            pb.start(); //Inicializar los procesos
            Process p = pb.start(); //Mostrar los procesos
            System.out.println((p.pid())); //Imprimir por pantalla el PID de ambos procesos
            p.destroy();
        } catch (Exception e) {
            e.printStackTrace(); //Sacar toda la traza del error
        }
    }

    public static void main(String[] args) {
        String Ruta = "C://Windows//System32//notepad.exe";
        Lanzador l1 = new Lanzador();
        Lanzador l2 = new Lanzador();
        l1.ejecutar(Ruta);
        l2.ejecutar(Ruta);
    }
}
