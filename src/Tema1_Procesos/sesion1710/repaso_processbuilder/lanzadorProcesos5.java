package Tema1_Procesos.sesion1710.repaso_processbuilder;

import java.io.*;
import java.util.Scanner;

public class lanzadorProcesos5 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("python", "C://Users//Iker//Downloads//chatbot.py");
        try {
            Process proceso = pb.start();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(proceso.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

            Scanner scanner = new Scanner(System.in);
            String mensajeUsuario;

            System.out.println("Inicia conversación con el chat bot (escribe 'adiós' para salir):");
            while (true) {
                System.out.print("Tú: ");
                mensajeUsuario = scanner.nextLine();
                writer.write(mensajeUsuario + "\n");
                writer.flush();

                String respuesta = reader.readLine();
                System.out.println("Bot: " + respuesta);

                if (mensajeUsuario.equalsIgnoreCase("adiós")) {
                    break;
                }
            }

            proceso.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
