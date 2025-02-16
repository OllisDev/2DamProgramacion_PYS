package EjerciciosRepasoExamen2Evaluacion.EnviarMensaje;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// Ejercicio 2: Cliente envía un mensaje y el servidor responde
// Descripción
// El cliente envía un mensaje al servidor.
// El servidor recibe el mensaje y responde con un mensaje de confirmación.
public class Servidor {
    private static int PUERTO = 12345; // Puerto

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Esperando a que el cliente se conecte al servidor en el puerto: " + PUERTO);
            Socket socket = serverSocket.accept(); // Espera a que el cliente se conecte
            System.out.println("Cliente conectado");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Tuberia de entrada
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Tuberia de salida

            String mensajeRecibido = in.readLine(); // Leer mensaje del cliente
            System.out.println("Mensaje recibido del cliente: " + mensajeRecibido);

            out.println("Mensaje recibido correctamente: " + mensajeRecibido); // Responder al cliente

            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
