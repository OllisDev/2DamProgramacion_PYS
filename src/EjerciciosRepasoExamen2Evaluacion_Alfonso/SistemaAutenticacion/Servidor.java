package EjerciciosRepasoExamen2Evaluacion_Alfonso.SistemaAutenticacion;

// Sistema de autenticación
// Descripción: Desarrolla un servidor que requiera autenticación para permitir el acceso a los clientes. El servidor debe verificar un nombre de usuario y contraseña antes de permitir la conexión.
//
// Requisitos:
//
// El servidor debe tener una lista de usuarios y contraseñas válidas.
// Si el cliente falla en la autenticación, el servidor debe cerrar la conexión.
// Solo los clientes autenticados pueden enviar y recibir mensajes.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Servidor {
    private static int PUERTO = 12345;
    private static String[] usuariosValidos = {"Iker", "Alfonso", "Dario"};
    private static String[] contrasenasValidas = {"123456", "123456789", "987654321"};

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Esperando a que los clientes se conecten al servidor: " + PUERTO);

            while (true) {
                Socket clientSocket = serverSocket.accept();
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

                Scanner sc = new Scanner(System.in);
                System.out.print("Introduce un nombre de usuario: ");
                String nombre = sc.nextLine();
                System.out.print("Introduce una contraseña: ");
                String contrasena = sc.nextLine();

                if (!verificarNombreContrasena(nombre, contrasena)) {
                    System.out.println("No puedes acceder al servidor");
                    return;
                }

                out.println("Cliente conectado.");

                String mensajeCliente;
                while((mensajeCliente = in.readLine()) != null) {
                    System.out.println(clientSocket.getInetAddress() + ": " +  mensajeCliente);

                    if (mensajeCliente.equalsIgnoreCase("salir")) {
                        break;
                    }

                    out.println("Servidor: Mensaje recibido.");
                }

                System.out.println("Cliente desconectado");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean verificarNombreContrasena(String usuario, String contrasena) {
        for (int i = 0; i< usuariosValidos.length; i++) {
            if (usuariosValidos[i].equals(usuario) && contrasenasValidas[i].equals(contrasena)) {
                return true;
            }
        }
        return false;
    }
}
