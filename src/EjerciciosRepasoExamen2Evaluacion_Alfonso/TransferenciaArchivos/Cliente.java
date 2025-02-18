package EjerciciosRepasoExamen2Evaluacion_Alfonso.TransferenciaArchivos;

import java.io.*;
import java.net.Socket;

public class Cliente {
    private static final String SERVER_ADDRESS = "localhost"; // Dirección del servidor
    private static final int SERVER_PORT = 5000; // Puerto del servidor

    public static void main(String[] args) {
        String filePath = "C:/clienteArchivos/prueba.txt"; // Ruta del archivo que se enviará
        sendFile(filePath);
    }

    private static void sendFile(String filePath) {
        File file = new File(filePath);

        // Verificar si el archivo existe antes de enviarlo
        if (!file.exists()) {
            System.out.println("El archivo no existe.");
            return;
        }

        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             FileInputStream fis = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(fis);
             OutputStream os = socket.getOutputStream();
             BufferedOutputStream bos = new BufferedOutputStream(os)) {

            byte[] buffer = new byte[4096]; // Buffer para la transferencia de datos
            int bytesRead;

            // Leer los datos del archivo y enviarlos al servidor
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            System.out.println("Archivo enviado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
