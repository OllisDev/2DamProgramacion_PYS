package Tema1_Procesos.sesion2111.Ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

/*
Ejercicio 3: Ejecutar y detener un proceso
Escribe un programa que:

Ejecute un proceso que se quede en ejecución durante un tiempo indefinido (por ejemplo, ping en Windows o top en Linux).
Espere 10 segundos y luego termine el proceso automáticamente desde el programa en Java.
 */
public class EJ3 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "ping google.com");
        try {
            Process p = pb.start();
            BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }
            if (p.waitFor(10, TimeUnit.SECONDS)) {
                System.out.println("El proceso ha terminado");
            } else {
                System.out.println("El proceso ha tardado demasiado en terminar");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
