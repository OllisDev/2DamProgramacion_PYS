package Tema1_Procesos.sesion2609;

import java.io.IOException;

public class Lanzador2 {

    public static void ejecutar(String Ruta) {
        ProcessBuilder pb;
        try {
            pb = new ProcessBuilder("Java", "C:\\Users\\Alumno214\\IdeaProjects\\2damprogramacion-master\\src\\PYS\\Practicas\\Practica_ProcessBuilder//Lanzador.java");
            pb.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String ruta = "";
        Lanzador2 l = new Lanzador2();
        l.ejecutar(ruta);
    }
}
