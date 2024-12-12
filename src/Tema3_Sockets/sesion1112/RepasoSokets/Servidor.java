package Tema3_Sockets.sesion1112.RepasoSokets;

import java.io.*;   // Importar clases para la entrada y salida de datos
import java.net.*;  // Importar clases para trabajar con sockets y redes

public class Servidor {
    public static void main(String[] args) {
        int port = 5000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            // PISTA: Crea un servidor que escuche en un puerto (por ejemplo, 5000)
            System.out.println("Servidor escuchando en el puerto 5000...");

            while (true) {
                // PISTA: Aceptar la conexión de un cliente usando el objeto ServerSocket
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado");

                // PISTA: Crear un flujo de entrada para recibir datos del cliente
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // PISTA: Crear un flujo de salida para enviar datos al cliente
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                // PISTA: Leer un mensaje del cliente utilizando el flujo de entrada
                String clientMessage = in.readLine();
                System.out.println("Mensaje recibido: " + clientMessage);

                // PISTA: Imprimir el mensaje recibido en la consola
                out.println("Mensaje recibido: " + clientMessage);
                // PISTA: Responder al cliente enviando un mensaje a través del flujo de salida
                clientSocket.close();
                System.out.println("Conexión cerrada con el cliente");
            }
        } catch (IOException e) {
            // PISTA: Manejar posibles errores de entrada/salida
            e.printStackTrace();
        }
    }
}
