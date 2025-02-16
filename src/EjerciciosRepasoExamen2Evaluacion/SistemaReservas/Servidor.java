package EjerciciosRepasoExamen2Evaluacion.SistemaReservas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

// Sistema de reservas
//Descripción: Crea un servidor que permita a los clientes reservar asientos en un teatro. El servidor debe mantener un registro de los asientos disponibles y reservados.
//
//Requisitos:
//
//Los clientes deben poder ver los asientos disponibles y reservar uno.
//El servidor debe validar que el asiento esté disponible antes de reservarlo.
//El servidor debe actualizar la lista de asientos en tiempo real.

public class Servidor {
    private static final int PUERTO = 12345;
    private static Map<Integer, Boolean> asientos = new HashMap<>();

    public static void main(String[] args) {
        // Inicializar los asientos (10 asientos, todos disponibles)
        for (int i = 1; i <= 10; i++) {
            asientos.put(i, true);
        }

        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Servidor iniciado en el puerto " + PUERTO);

            while (true) {
                Socket cliente = serverSocket.accept();
                new Thread(new ManejadorCliente(cliente)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ManejadorCliente implements Runnable {
        private Socket socket;

        public ManejadorCliente(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (
                    BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            ) {
                String opcion;
                while ((opcion = entrada.readLine()) != null) {
                    if (opcion.equals("VER")) {
                        salida.println(getAsientosDisponibles());
                    } else if (opcion.startsWith("RESERVAR")) {
                        String[] partes = opcion.split(" ");
                        if (partes.length == 2) {
                            int asiento = Integer.parseInt(partes[1]);
                            if (asientos.containsKey(asiento) && asientos.get(asiento)) {
                                asientos.put(asiento, false);
                                salida.println("Asiento " + asiento + " reservado con éxito.");
                            } else {
                                salida.println("Asiento no disponible.");
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String getAsientosDisponibles() {
            StringBuilder sb = new StringBuilder("Asientos disponibles: ");
            for (Map.Entry<Integer, Boolean> entry : asientos.entrySet()) {
                if (entry.getValue()) {
                    sb.append(entry.getKey()).append(" ");
                }
            }
            return sb.toString();
        }
    }
}
