package Tema3_Sockets.sesion0801.ejercicioLog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ClienteLog {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            socket.setSoTimeout(5000); // Timeout de 5 segundos

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Hola, servidor!");
            System.out.println("Esperando respuesta del servidor...");
            System.out.println("Respuesta del servidor: " + in.readLine());

        } catch (SocketTimeoutException e) {
            System.out.println("Timeout: No se recibió respuesta del servidor en el tiempo esperado.");
        } catch (IOException e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}
