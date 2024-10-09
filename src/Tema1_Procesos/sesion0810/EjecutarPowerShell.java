package Tema1_Procesos.sesion0810;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class EjecutarPowerShell {
    public static void main(String[] args) {
        try {
            // Comando para ejecutar el script de PowerShell
            String command = "powershell.exe -ExecutionPolicy Bypass -File C:\\Users\\Iker\\Documents\\procesos.ps1";

            // Crear el proceso para ejecutar el comando
            Process powerShellProcess = Runtime.getRuntime().exec(command);

            // Leer la salida del comando
            BufferedReader reader = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));

            // Crear archivo para almacenar la salida
            File file = new File("C:\\Users\\Iker\\Documents\\salida.txt");
            FileWriter writer = new FileWriter(file);

            String line;
            while ((line = reader.readLine()) != null) {
                // Escribir cada línea de la salida en el archivo
                writer.write(line + System.lineSeparator());
            }

            // Cerrar el archivo y el lector
            writer.close();
            reader.close();

            // Esperar a que el proceso termine
            int exitCode = powerShellProcess.waitFor();
            System.out.println("El proceso ha terminado con el código: " + exitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
