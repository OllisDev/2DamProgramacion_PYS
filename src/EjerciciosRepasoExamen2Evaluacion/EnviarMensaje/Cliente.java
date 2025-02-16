package EjerciciosRepasoExamen2Evaluacion.EnviarMensaje;

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
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in)) {

            System.out.print("Introduce un mensaje para enviar al servidor:");
            String mensaje = sc.nextLine();

            out.println(mensaje); // Enviar el mensaje al servidor mediante la tuberia de salida

            String respuesta = in.readLine(); // Leer mensaje del servidor mediante la tuberia de entrada
            System.out.println("Respuesta del servidor: " + respuesta); // Mostrar la respuesta del servidor


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
