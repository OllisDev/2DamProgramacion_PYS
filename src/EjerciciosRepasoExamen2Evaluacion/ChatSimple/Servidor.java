package EjerciciosRepasoExamen2Evaluacion.ChatSimple;
// Ejercicio 6: Chat simple entre cliente y servidor
// Descripción
// Permite al cliente y al servidor enviarse mensajes hasta que uno escriba "salir".

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    private static int PUERTO = 12345; // Puerto

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Esperando a que el cliente se conecte al servidor: " + PUERTO);

            Socket socket = serverSocket.accept(); // Esperar a que el cliente se conecte al servidor
            System.out.println("Cliente conectado");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Tuberia de entrada
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Tuberia de salida
            
            String mensaje;

            // Bucle de enviar y recibir mensajes hasta que el servidor ponga salir y salga del bucle y finaliza el chat
            do {
                mensaje = in.readLine(); // Leer mensaje del cliente mediante la tuberia de entrada
                System.out.println("Cliente: " + mensaje); // Mostrar mensaje del cliente

                Scanner sc = new Scanner(System.in);
                if (!mensaje.equalsIgnoreCase("salir")) {
                    System.out.print("Tu: ");
                    String mensajeServidor = sc.nextLine(); // Introducir por pantalla un mensaje
                    out.println("Servidor: " + mensaje); // Devolver o enviar mensaje al cliente mediante la tuberia de salida
                }

            } while (!mensaje.equalsIgnoreCase("salir"));

            System.out.println("Chat finalizado");

            socket.close(); // Cerrar conexión del servidor
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
