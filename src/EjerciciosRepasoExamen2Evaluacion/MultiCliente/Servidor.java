package EjerciciosRepasoExamen2Evaluacion.MultiCliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// Ejercicio 1: Chat multiclientes
// Descripción
// El servidor permite que varios clientes se conecten y envíen mensajes.
// Cada cliente es manejado en un hilo independiente.
public class Servidor {
    private static int PUERTO = 12345; // Puerto

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Esperando a que un cliente se conecte al servido en el puerto = " + PUERTO);

            while(true) {
                Socket socketClient = serverSocket.accept(); // Esperar a que los clientes se conecten al servidor
                System.out.println("Cliente conectado: " + socketClient.getInetAddress());
                new Thread(new ManejadorClientes(socketClient)).start(); // Iniciar multihilo para manejar varios clientes
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Clase que permite manejar y controlar los clientes mediante hilos independientes
    private static class ManejadorClientes implements Runnable {
        private Socket clientSocket;

        public ManejadorClientes(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // Tuberia de entrada
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) { // Tuberia de salida
                String mensajeCliente;
                while ((mensajeCliente = in.readLine()) != null) { // Leer mensaje del cliente mediante la tuberia de entrada
                    System.out.println("Cliente: " + mensajeCliente); // Mostrar mensaje del cliente

                    // Verificar si el mensaje del cliente pone salir y se desconecte del servidor
                    if (mensajeCliente.equalsIgnoreCase("salir")) {
                        break;
                    }

                    out.println("Servidor: Mensaje recibido"); // Devolver mensaje mediante un mensaje que ya lo ha recibido a traves de la tuberia de salida
                }
                System.out.println("Cliente desconectado"); // Mostrar mensaje de que el cliente se ha desconectado
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
