package Tema3_Sockets.sesion0512.Cliente_Servidor;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 12345; // Puerto donde el servidor escuchará

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor escuchando en el puerto " + port);

            while (true) {
                // Aceptar conexiones
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

                // Flujos de entrada y salida
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Leer mensaje del cliente
                String clientMessage = in.readLine();
                System.out.println("Mensaje recibido: " + clientMessage);

                // Responder al cliente
                out.println("Mensaje recibido: " + clientMessage);

                // Cerrar la conexión con el cliente
                clientSocket.close();
                System.out.println("Conexión cerrada con el cliente.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

