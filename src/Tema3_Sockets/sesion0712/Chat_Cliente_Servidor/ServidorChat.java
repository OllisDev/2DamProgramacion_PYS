package Tema3_Sockets.sesion0712.Chat_Cliente_Servidor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServidorChat {
    public static void main(String[] args) {
        int port = 12345; // Puerto donde el servidor escuchará

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor escuchando en el puerto " + port);

            while (true) {
                // Aceptar conexiones
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clientSocket.getInetAddress());
                new Thread(new conexionCliente(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Clase para manejar la conexion de múltiples clientes que se conectan al servidor mediante la creacion de un hilo separado
class conexionCliente implements Runnable {
    private final Socket socketCliente;

    // Constructor
    public conexionCliente(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }

    @Override
    public void run() {
        // Flujos de entrada y salida
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            PrintWriter out = new PrintWriter(socketCliente.getOutputStream(), true)
            ) {
            // Leer mensaje del cliente
            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Mensaje recibido: " + clientMessage);

                if (clientMessage.equals("FIN")) {
                    System.out.println("El cliente solicitó terminar la conexión");
                    break;
                }

                // Responder al cliente
                out.println("Mensaje recibido: " + clientMessage);
            }



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Cerrar la conexión con el cliente
                socketCliente.close();
                System.out.println("Conexión cerrada con el cliente.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
