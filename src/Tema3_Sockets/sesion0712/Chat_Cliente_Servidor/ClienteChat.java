package Tema3_Sockets.sesion0712.Chat_Cliente_Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteChat {
    public static void main(String[] args) {

            String serverAddress = "192.168.0.23"; // Dirección del servidor
            int port = 12345; // Puerto del ervidor

            try (Socket socket = new Socket(serverAddress, port)) {
                System.out.println("Conectado al servidor");
                // Flujos de entrada y salida
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                String salida = "";
                Scanner sc = new Scanner(System.in);
                while (salida !=  "FIN") {
                    // Enviar mensaje al servidor
                    // preguntar al usuario que ponga lo que quiere enviar
                    String message = sc.nextLine();
                    out.println(message);
                    System.out.println("Mensaje enviado: " + message);

                    // Leer respuesta del servidor
                    String serverResponse = in.readLine();
                    System.out.println("Respuesta del servidor: " + serverResponse);

                    String serverMessage = in.readLine();
                    System.out.println("Mensaje recibido: " + serverMessage);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

