package Tema1_Procesos.sesion2111.Ejercicios;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EJ1 {
    public static void main(String[] args) {
        System.out.println("Introduce la ruta del programa o comando que desee ejecutar:");
        Scanner sc = new Scanner(System.in);
        String proceso = sc.nextLine();
        lanzarProceso(proceso);
    }

    private static void lanzarProceso(String proceso) {

        ProcessBuilder pb;

        if (esComandoDeCMD(proceso)) {
            pb = new ProcessBuilder("cmd.exe", "/c", proceso);
        } else {
            pb = new ProcessBuilder(proceso.split(" "));
        }
        try {
            Process p = pb.start();
            BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea;
            while((linea = bf.readLine()) != null) {
                System.out.println(linea);
            }

            int exitCode = p.waitFor();
            if (exitCode == 0) {
                System.out.println("El proceso terminó correctamente");
            } else {
                System.out.println("El proceso terminó con errores");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static boolean esComandoDeCMD(String entrada) {
        // Lista básica de comandos internos de CMD
        String[] comandosCMD = {"dir", "ipconfig", "ping", "cd", "cls", "exit", "echo", "del", "copy"};
        String primerPalabra = entrada.split(" ")[0]; // Extraer el primer elemento
        for (String comando : comandosCMD) {
            if (comando.equalsIgnoreCase(primerPalabra)) {
                return true;
            }
        }
        return false;
    }
}
