package EjerciciosRepasoExamen2Evaluacion.DevolverMayusculas;

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

            // Introducir por pantalla una palabra
            System.out.print("Introduce una palabra: ");
            String palabra = sc.nextLine();

            out.println(palabra); // Enviar la palabra introducida por pantalla al servidor mediante la tuberia de salida

            String palabraRecibida = in.readLine(); // Leer la palabra recibida en mayusculas del servidor mediante la tuberia de entrada
            System.out.println("Palabra en mayúscula recibida por el servidor: " + palabraRecibida); // Mostrar palabra en mayusculas

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
