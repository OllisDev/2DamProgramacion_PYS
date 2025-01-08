package Tema3_Sockets.sesion0512.Cliente_Servidor;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Dirección del servidor
        int port = 12345; // Puerto del ervidor

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Conectado al servidor");
            // Flujos de entrada y salida
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String salida = "";
            while (salida !=  "FIN") {
                // Enviar mensaje al servidor
                // preguntar al usuario que ponga lo que quiere enviar
                Scanner sc = new Scanner(System.in);
                String message = sc.nextLine();
                out.println(message);
                System.out.println("Mensaje enviado: " + message);

                // Leer respuesta del servidor
                String serverResponse = in.readLine();
                System.out.println("Respuesta del servidor: " + serverResponse);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


