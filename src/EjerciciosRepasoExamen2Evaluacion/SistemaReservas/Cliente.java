package EjerciciosRepasoExamen2Evaluacion.SistemaReservas;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    private static final String SERVIDOR = "localhost";
    private static final int PUERTO = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVIDOR, PUERTO);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            String respuesta;
            while (true) {
                System.out.println("\nOpciones:");
                System.out.println("1. Ver asientos disponibles");
                System.out.println("2. Reservar un asiento");
                System.out.println("3. Salir");

                System.out.print("Elige una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        salida.println("VER");
                        respuesta = entrada.readLine();
                        System.out.println(respuesta);
                        break;

                    case 2:
                        System.out.print("Ingrese el número de asiento a reservar: ");
                        int asiento = scanner.nextInt();
                        scanner.nextLine();
                        salida.println("RESERVAR " + asiento);
                        respuesta = entrada.readLine();
                        System.out.println(respuesta);
                        break;

                    case 3:
                        System.out.println("Cerrando conexión...");
                        return;

                    default:
                        System.out.println("Opción no válida.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

