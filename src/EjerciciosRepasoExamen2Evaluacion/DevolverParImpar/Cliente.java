package EjerciciosRepasoExamen2Evaluacion.DevolverParImpar;

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

            // Introducir numero por pantalla
            System.out.print("Introduce un número entero: ");
            int numero = sc.nextInt();

            out.println(numero); // Enviar el numero introducido por pantalla al servidor mediante la tuberia de salida

            String respuesta = in.readLine(); // Leer respuesta del servidor mediante la tuberia de entrada
            System.out.println("Respuesta del servidor: " + respuesta); // Mostrar respuesta del servidor
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
