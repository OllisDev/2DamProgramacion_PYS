package EjerciciosRepasoExamen2Evaluacion.DevolverSuma;

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

            // Introducimos por pantalla ambos numeros
            System.out.print("Introduce un numeros entero: ");
            int numero1 = sc.nextInt();
            System.out.print("Introduce otro numero entero: ");
            int numero2 = sc.nextInt();

            // Enviamos ambos números al servidor mediante la tuberia de salida
            out.println(numero1);
            out.println(numero2);

            // Leemos la devolución de la suma del servidor mediante la tuberia de entrada
            String respuesta = in.readLine();
            System.out.println("Suma realizada por el Servidor: " + respuesta); // Mostrar la suma realizada por el servidor

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
