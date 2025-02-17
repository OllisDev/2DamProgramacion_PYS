package EjerciciosRepasoExamen2Evaluacion.DevolverSuma;

// Ejercicio 3: Cliente envía números y el servidor devuelve la suma
// Descripción
// El cliente envía dos números.
// El servidor los suma y devuelve el resultado.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private static int PUERTO = 12345; // Puerto
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Esperando a que el cliente se conecte al servidor en el puerto: " + 12345);

            Socket socket = serverSocket.accept(); // Esperando a que el cliente se conecte al servidor
            System.out.println("Cliente conectado");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Tubería de entrada
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Tubería de salida

            // Parseamos la lectura de los numeros a un entero mediante la tubería de entrada
            int numero1 = Integer.parseInt(in.readLine());
            int numero2 = Integer.parseInt(in.readLine());
            int resultado = numero1 + numero2;

            out.println("La suma es: " + resultado); // Mostrar la suma

            socket.close(); // Cerrar servidor

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
