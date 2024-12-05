package Tema3_Sockets.sesion0512.Servidor_Multihilo;

import java.io.*;
import java.net.*;

public class Server2 {

    public void connect() {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println ("Servidor está arracando en el puerto: 1234");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado" + clientSocket.getInetAddress());
                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void handleClient(Socket socket) {
        try {
            BufferedReader entradaDatos = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salidaDatos = new PrintWriter(socket.getOutputStream());
            String message = "";
            while ((message = entradaDatos.readLine()) != null) {
                System.out.println(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
