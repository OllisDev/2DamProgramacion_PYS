package EjerciciosRepasoExamen2Evaluacion_Alfonso.TransferenciaArchivos;

// Transferencia de archivos
// Descripción: Crea un servidor que permita a los clientes enviar archivos . El servidor debe recoger los archivos y guardarlos en una carpeta específica.
//
// Requisitos:
//
// El cliente debe enviar el archivo
// El servidor debe descifrar el archivo y guardarlo con un nombre único.


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Servidor {
    private static final int PORT = 5000; // Puerto donde el servidor escuchará conexiones
    private static final String SAVE_DIR = "C:/servidorArchivos/"; // Carpeta donde se guardarán los archivos recibidos

    public static void main(String[] args) {
        // Crear la carpeta si no existe
        File dir = new File(SAVE_DIR);
        if (!dir.exists()) dir.mkdirs();

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Servidor esperando conexiones en el puerto " + PORT + "...");

            while (true) {
                // Aceptar conexión de un cliente
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado: " + socket.getInetAddress());

                // Recibir archivo
                receiveFile(socket);

                // Cerrar la conexión con el cliente
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void receiveFile(Socket socket) {
        try (InputStream is = socket.getInputStream();
             BufferedInputStream bis = new BufferedInputStream(is)) {

            // Generar un nombre único para el archivo recibido
            String fileName = UUID.randomUUID() + ".dat";
            File file = new File(SAVE_DIR + fileName);

            try (FileOutputStream fos = new FileOutputStream(file);
                 BufferedOutputStream bos = new BufferedOutputStream(fos)) {

                byte[] buffer = new byte[4096]; // Buffer para la transferencia de datos
                int bytesRead;

                // Leer los datos recibidos y escribirlos en el archivo
                while ((bytesRead = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, bytesRead);
                }

                System.out.println("Archivo recibido y guardado como: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
