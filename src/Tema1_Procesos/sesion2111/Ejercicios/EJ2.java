package Tema1_Procesos.sesion2111.Ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Ejercicio 2: Leer la salida de un proceso
Escribe un programa que ejecute un comando de consola, por ejemplo, ipconfig (en Windows) o ifconfig (en Linux), y capture su salida estándar.
El programa debe mostrar la salida línea por línea en la consola de Java.
 */
public class EJ2 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "ipconfig");
        try {
            Process p = pb.start();
            BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea = "";
            while ((linea = bf.readLine()) != null) {
                System.out.println(linea);
            }

            int exitCode = p.waitFor();

            if (exitCode == 0) {
                System.out.println("El proceso ha terminado exitosamente");
            } else {
                System.out.println("El proceso terminó con errores");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
