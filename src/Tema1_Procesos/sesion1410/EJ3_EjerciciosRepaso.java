package Tema1_Procesos.sesion1410;

import java.io.*;

public class EJ3_EjerciciosRepaso {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb1 = new ProcessBuilder();
            pb1.command("cmd.exe", "/c", "echo Este es el primer proceso");
            Process p1 = pb1.start();


            ProcessBuilder pb2 = new ProcessBuilder();
            pb2.command("cmd.exe", "/c", "echo Este es el segundo proceso");
            Process p2 = pb2.start();

            BufferedReader leer1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
            BufferedWriter escribir2 = new BufferedWriter(new OutputStreamWriter(p2.getOutputStream()));

            String line;

            while((line = leer1.readLine()) != null) {
                escribir2.write(line + "/n");
                escribir2.flush();

            }
            escribir2.close();

            BufferedReader leer2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));

            while ((line = leer2.readLine()) != null) {
                System.out.println("Salida final: " + line);
            }

            p1.waitFor();
            p2.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
