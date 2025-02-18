package EjerciciosRepasoExamen2Evaluacion_Alfonso.EjercicioTipoExamen;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    private static int PUERTO = 12345;
    private static String IP = "localhost";

    public static void main(String[] args) {
        try(Socket socket = new Socket(IP, PUERTO);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in)) {

            System.out.print("Introduce un nombre: ");
            String nombre = sc.nextLine();
            out.println(nombre);

            String respuesta = in.readLine();
            System.out.println("Respuesta del servidor: " + respuesta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
