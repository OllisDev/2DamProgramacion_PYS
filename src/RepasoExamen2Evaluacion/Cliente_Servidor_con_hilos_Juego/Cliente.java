package RepasoExamen2Evaluacion.Cliente_Servidor_con_hilos_Juego;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class Cliente {
    private static final String SERVIDOR = "192.168.9.15";
    private static final int PUERTO = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVIDOR, PUERTO);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            String fromServer;
            String fromUser;

            // Leer el mensaje de bienvenida del servidor
            fromServer = in.readLine();
            System.out.println("Servidor: " + fromServer);

            // Bucle principal para adivinar el número
            while (true) {
                // Leer la entrada del usuario
                System.out.print("Ingresa un número: ");
                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    out.println(fromUser); // Enviar el número al servidor
                }

                // Leer la respuesta del servidor
                fromServer = in.readLine();
                System.out.println("Servidor: " + fromServer);

                // Si el servidor dice "Correcto", salir del bucle
                if (fromServer.equals("Correcto. ¡Felicidades!")) {
                    break;
                }
            }

        } catch (UnknownHostException e) {
            System.err.println("No se pudo encontrar el host: " + SERVIDOR);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("No se pudo conectar al servidor: " + SERVIDOR);
            System.exit(1);
        }
    }
}
