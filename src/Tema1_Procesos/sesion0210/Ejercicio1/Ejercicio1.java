package Tema1_Procesos.sesion0210.Ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            String pythonInterpreterPath = "C:\\Python312\\python.exe";
            String pythonScriptPath = "C:/Users/ikerm/Documents/2damprogramacion-master/2damprogramacion/src/PYS/sesion0210/Ejercicio1/Ejercicio1.py";

            ProcessBuilder pb = new ProcessBuilder(pythonInterpreterPath, pythonScriptPath);

            Process process = pb.start();

            BufferedReader escribir = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String linea;
            while ((linea = escribir.readLine()) != null) {
                System.out.println(linea);
            }

            int exitCode = process.waitFor();
            System.out.println("Codigo de salida: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}