package Tema3_Sockets.sesion0712.Chat_Cliente_Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteChat {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Dirección del servidor
        int port = 12345; // Puerto del ervidor

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Conectado al servidor");

            // Flujos de entrada y salida
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);
            String mensaje;

            do {
                System.out.println("Tu: ");
                mensaje = sc.nextLine();
                out.println(mensaje);

            } while (!mensaje.equals("FIN")); // Bucle de mandar mensajes al servidor hasta que ponemos FIN y sale del bucle y se desconecta del servidor el cliente.

            System.out.println("Desconexión del servidor...");
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
