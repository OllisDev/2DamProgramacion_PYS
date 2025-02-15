package EjerciciosRepasoExamen2Evaluacion.SistemaReservas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// Sistema de reservas
//Descripción: Crea un servidor que permita a los clientes reservar asientos en un teatro. El servidor debe mantener un registro de los asientos disponibles y reservados.
//
//Requisitos:
//
//Los clientes deben poder ver los asientos disponibles y reservar uno.
//El servidor debe validar que el asiento esté disponible antes de reservarlo.
//El servidor debe actualizar la lista de asientos en tiempo real.
public class Servidor {
    private static int asientosDisponibles = 25;
    public static void main(String[] args) {
        final int PUERTO = 12345;

        try (ServerSocket serverSocket = new ServerSocket(PUERTO)){
            System.out.println("Sistema de reservas iniciado en el puerto " + PUERTO);

            while(true) {
                Socket clientSocket = serverSocket.accept();
                new Thread (new ManejadorClientes(clientSocket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static class ManejadorClientes implements Runnable {
        private Socket clientSocket;

        public ManejadorClientes(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {

        }
    }


}
