package EjerciciosRepasoExamen2Evaluacion.MensajeFijo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// Ejercicio 1: Servidor que responde con un mensaje fijo
// Descripción
// Un servidor escucha en un puerto y cuando un cliente se conecta, le envía un mensaje fijo.
// El cliente se conecta y recibe el mensaje.
public class Servidor {
    private static int PUERTO = 12345; // Puerto

    public static void main(String[] args) {

       try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
           System.out.println("Esperando a que el cliente se conecte en el puerto: " + PUERTO);

           Socket socket = serverSocket.accept(); // Esperar a que el cliente entre al servidor
           System.out.println("Cliente conectado");

           PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Tuberia de salida

           out.println("Hola cliente"); // Escribir mensaje al cliente

           socket.close();
       } catch(IOException e) {
           e.printStackTrace();
       }
    }
}

