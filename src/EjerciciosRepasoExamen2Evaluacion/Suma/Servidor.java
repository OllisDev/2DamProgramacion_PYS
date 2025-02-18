package EjerciciosRepasoExamen2Evaluacion.Suma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// Ejercicio 2: Servidor de Suma
// Descripción: Un servidor recibe dos números de un cliente y devuelve la suma.
//
// Servidor
// Recibe dos números como entrada de un cliente.
// Calcula la suma y la envía de vuelta.
// Cliente
// Envía dos números al servidor.
// Recibe la suma y la muestra en consola.

public class Servidor {
    private static int PUERTO = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Esperando a que los clientes se conecten al servidor: " + PUERTO);

            while(true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clientSocket.getInetAddress());
                new Thread(new ManejadorClientes(clientSocket)).start();
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ManejadorClientes implements Runnable {
        Socket clientSocket;

        public ManejadorClientes(Socket socket) {
            this.clientSocket = socket;
        }



        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                while (true) {

                    int numero1 = Integer.parseInt(in.readLine());
                    int numero2 = Integer.parseInt(in.readLine());

                    if (numero1 == 0 && numero2 == 0) {
                        System.out.println("Cliente desconectado");
                        break;
                    }

                    int resultado = numero1 + numero2;

                    out.println("La suma es: " + resultado);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
