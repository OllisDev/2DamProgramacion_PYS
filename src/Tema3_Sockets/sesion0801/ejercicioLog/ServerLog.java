package Tema3_Sockets.sesion0801.ejercicioLog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ServerLog {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Servidor en espera de conexión...");
            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado.");

            socket.setSoTimeout(5000); // Timeout de 5 segundos

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String mensaje;
            while ((mensaje = in.readLine()) != null) {
                System.out.println("Mensaje recibido: " + mensaje);
                out.println("Echo: " + mensaje);
            }

        } catch (SocketTimeoutException e) {
            System.out.println("Timeout: No se recibió respuesta del cliente en el tiempo esperado.");
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
