package EjerciciosRepasoExamen2Evaluacion_Alfonso.EjercicioTipoExamen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// ejercicio de examen
// Escribe un servidor que acepte conexiones de múltiples clientes.
// Cada cliente debe enviar su nombre, y el servidor debe responder con un mensaje personalizado (por ejemplo, "Hola, [nombre]").
public class Servidor {
    private static int PUERTO = 12345; // Puerto

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Esperando a que los clientes se conecten en el puerto: " + PUERTO);

            while (true) {
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

                String respuesta = in.readLine();
                System.out.println("Respuesta del cliente: " + respuesta);


                out.println("Hola, " + respuesta);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
