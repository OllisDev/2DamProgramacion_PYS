package Tema3_Sockets.sesion1112.RepasoSokets;

import java.io.*;   // Importar clases para entrada y salida de datos
import java.net.*;  // Importar clases para trabajar con sockets y redes
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        // Usa la dirección IP del servidor ("127.0.0.1" para localhost) y el puerto (5000).
        String ip = "localhost";
        int port = 5000;
        // PISTA: Crear un socket para conectarse al servidor.
        try (Socket socket = new Socket(ip, port)) {
            // PISTA: Crear un flujo de entrada para recibir datos del servidor
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // PISTA: Crear un flujo de salida para enviar datos al servidor
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // PISTA: Enviar un mensaje al servidor utilizando el flujo de salida
            String salida = "Hola";
                out.println(salida);
                System.out.println("Mensaje enviado: " + salida);

            // PISTA: Leer la respuesta del servidor usando el flujo de entrada
            String serverResponse = in.readLine();

            // PISTA: Imprimir la respuesta del servidor en la consola
            System.out.println("Respuesta del servidor: " + serverResponse);

        } catch (IOException e) {
            // PISTA: Manejar posibles errores de entrada/salida
            e.printStackTrace();
        }
    }
}

