package EjerciciosRepasoExamen2Evaluacion.MultiCliente;

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
            while (true) {
                System.out.print("Tu: ");
                mensaje = sc.nextLine(); // Introducir un mensaje por pantalla
                out.println(mensaje); // Enviar mensaje introducido por pantalla al servidor mediante la tuberia de salida

                // Verificar si el mensaje pone salir y el cliente se desconecte del servidor
                if (mensaje.equalsIgnoreCase("salir")) {
                    break;
                }

                String respuesta = in.readLine(); // Leer mensaje del servidor mediante la tuberia de entrada
                System.out.println(respuesta); // Mostrar mensaje del servidor
            }
            System.out.println("Desconectado del servidor"); // Mostrar mensaje de que el cliente se ha desconectado del servidor
        } catch(IOException e ) {
            e.printStackTrace();
        }
    }
}
