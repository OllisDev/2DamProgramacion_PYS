package EjerciciosRepasoExamen2Evaluacion.MensajeFijo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    private static int PUERTO = 12345; // Puerto
    private static String IP = "localhost"; // Direccion ip
    public static void main(String[] args) {
        try (Socket socket = new Socket(IP, PUERTO)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Tuberia de entrada

            String mensaje = in.readLine(); // Leer mensaje del servidor mediante la tubería de entrada
            System.out.println("Mensaje del servidor: " + mensaje); // Mostrar por pantalla el mensaje del servidor

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
