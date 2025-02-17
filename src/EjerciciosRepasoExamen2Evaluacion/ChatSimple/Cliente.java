package EjerciciosRepasoExamen2Evaluacion.ChatSimple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    private static int PUERTO = 12345; // Puerto
    private static String IP = "localhost"; // Direccion IP

    public static void main(String[] args) {
        try (Socket socket = new Socket(IP, PUERTO);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Tuberia de entrada
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Tuberia de salida
             Scanner sc = new Scanner(System.in)) {
            String mensaje;

            // Bucle  enviar y recibir mensajes hasta que el cliente ponga salir y salga del bucle y finaliza el chat
        do {
            System.out.print("Tu: ");
            mensaje = sc.nextLine(); // Introducir un mensaje por pantalla

            out.println(mensaje); // Enviar mensaje al servidor mediante la tuberia de salida

            String respuesta = in.readLine(); // Leer mensaje del servidor
            System.out.println(respuesta); // Mostrar mensaje del servidor

        } while (!mensaje.equalsIgnoreCase("salir"));

            System.out.println("Chat finalizado");

        } catch (IOException e) {
            e.printStackTrace();
        }
     }
}
