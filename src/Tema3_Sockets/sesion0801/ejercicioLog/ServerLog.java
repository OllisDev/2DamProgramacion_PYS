package Tema3_Sockets.sesion0801.ejercicioLog;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

                guardarLog(mensaje); // LLamada al metodo guardarLog

                out.println("Echo: " + mensaje);
            }

        } catch (SocketTimeoutException e) {
            System.out.println("Timeout: No se recibió respuesta del cliente en el tiempo esperado.");
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }

    // Metodo para guardar el mensaje en un log mediante el recibo del cliente
    private static void guardarLog(String mensaje) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); // Formatear la fecha de cuando se envia el mensaje
        String logEntry = timestamp + " - " + mensaje; // Variable que contiene el formateo de la fecha y el mensaje

        try (PrintWriter out = new PrintWriter(new FileWriter("log.txt", true))) { // Crear el fichero log.txt con el contenido del mensaje
            out.println(logEntry);
        } catch (IOException e) {
            System.out.println("Error al guardar el log: " + e.getMessage());
        }
    }
}
