package Tema1_Procesos.sesion2011;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContadorLineas {

    // Constructor
    public ContadorLineas() {

    }

    public static void lanzarProceso() {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "find /c /v \"\" C://Users//Iker//Documents//2DamProgramacion_PYS-master//2DamProgramacion_PYS//src//Tema1_Procesos//sesion2011//calculadora.java"); // Crear proceso para leer las lineas del archivo de manera que llamamos al cmd para lanzar el comando
        try {
            Process p = pb.start();
            BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea = "";
            while((linea = bf.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ContadorLineas.lanzarProceso(); // Instanciación de la clase ContadorLineas para lanzar el proceso
    }
}
