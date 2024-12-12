package Tema3_Sockets.sesion0712.Chat_Cliente_Servidor;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class ServidorChat {
    public static void main(String[] args) {
        int port = 1234;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor escuchando en el puerto: " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado " + clientSocket.getInetAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientMessage = in.readLine();
                System.out.println("Mensaje recibido: " + clientMessage);

                out.println("Mensaje recibido: " + clientMessage);

                Scanner sc = new Scanner(System.in);
                String respuesta = sc.nextLine();
                System.out.println("Servidor: " + respuesta);

                out.close();
                System.out.println("Conexión cerrada con el cliente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
