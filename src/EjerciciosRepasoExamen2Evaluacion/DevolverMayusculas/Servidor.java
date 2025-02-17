package EjerciciosRepasoExamen2Evaluacion.DevolverMayusculas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// Ejercicio 4: Cliente envía una palabra y el servidor la devuelve en mayúsculas
// Descripción
// El cliente envía una palabra o frase.
// El servidor la recibe y la devuelve en mayúsculas.
public class Servidor {
    private static int PUERTO = 12345; // Puerto
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Esperando a que el cliente se conecte al servidor en el puerto: " + PUERTO);

            Socket socket = serverSocket.accept(); // Esperando a que el cliente se conecte al servidor
            System.out.println("Cliente conectado");
            
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Tuberia de entrada
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Tuberia de salida

            String palabraRecibida = in.readLine(); // Leer la palabra recibida por el cliente mediante la tuberia de entrada
            System.out.println("Palabra recibida del cliente: " + palabraRecibida); // Mostrar palabra del cliente

            out.println("Palabra en mayusculas: " + palabraRecibida.toUpperCase()); // Devolver palabra en mayúsculas al cliente mediante la tuberia de salida

            socket.close(); // Cerrar conexión del servidor
        } catch (IOException e) {
            e.printStackTrace();
        }
     }
}
