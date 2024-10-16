package Tema1_Procesos.sesion1610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejemploInyeccion {
    public static void main(String[] args) throws IOException, IOException {
        // Supongamos que este argumento proviene de una entrada del usuario
        String userInput = args[0];
        userInput = userInput.replace("&",""); //Para poder evitar que se nos ejecutase un comando podemos utilizar la funcion replace para poder reemplazar el & por un espacio en blanco para poder evitar que ejecute el comando mkdir

        // Vulnerable: el input del usuario se concatena directamente en el comando
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "echo " + userInput);
        processBuilder.start();
        try {
            // Inicia el proceso
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            // Imprime cada línea de la salida
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }


            // Espera a que el proceso termine
            int exitCode = process.waitFor();
            System.out.println("Notepad cerrado con código de salida: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

