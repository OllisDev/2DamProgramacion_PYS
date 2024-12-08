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
            String salida = "";
            do {
                System.out.println("Escribe un mensaje o finaliza la conversación poniendo FIN: ");
                Scanner sc = new Scanner(System.in);
                salida = sc.nextLine();
                out.println(salida);
                System.out.println("Mensaje enviado: " + salida);

                if (!salida.equals("FIN")) {
                    String respuestaServidor = in.readLine();
                    System.out.println("Respuesta del servidor: " + respuestaServidor);
                }
            } while (!salida.equals("FIN"));

            System.out.println("Desconexión del servidor...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
