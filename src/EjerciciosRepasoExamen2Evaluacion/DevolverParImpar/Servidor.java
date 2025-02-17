package EjerciciosRepasoExamen2Evaluacion.DevolverParImpar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// Ejercicio 5: Cliente envía un número y el servidor responde si es par o impar
// Descripción
// El cliente envía un número al servidor.
// El servidor responde si el número es par o impar.

public class Servidor {
    private static int PUERTO = 12345; // Puerto

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Esperando a que el cliente se conecte al servidor en el puerto: " + PUERTO);

            Socket socket = serverSocket.accept(); // Esperar a que cliente se conecte al servidor
            System.out.println("Cliente conectado");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Tuberia de entrada
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Tuberia de salida

            int numero = Integer.parseInt(in.readLine()); // Parseamos el numero a entero para poder leer el numero recibido por el cliente mediante la tuberia de entrada
            System.out.println("Numero recibido por el cliente: " + numero); // Mostrar numero del cliente

            // Verificar si el numero es par o impar
            if (numero%2 == 0) {
                out.println("El numero " + numero + " es par"); // Devolver el numero al cliente si es par mediante la tuberia de salida
            } else {
                out.println("El numero " + numero + " es impar"); // Devolver el numero al cliente si es impar mediante la tuberia de salida
            }

            socket.close(); // Cerrar conexión del servidor
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
