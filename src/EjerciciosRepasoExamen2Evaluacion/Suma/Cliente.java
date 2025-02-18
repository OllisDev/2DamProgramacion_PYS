package EjerciciosRepasoExamen2Evaluacion.Suma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static int PUERTO = 12345;
    public static String IP = "localhost";

    public static void main(String[] args) {
        try (Socket socket = new Socket(IP, PUERTO);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner sc = new Scanner(System.in)) {

            while (true) {
                System.out.print("Introduce un número: ");
                int numero1 = sc.nextInt();
                System.out.print("Introduce otro número: ");
                int numero2 = sc.nextInt();

                out.println(numero1);
                out.println(numero2);


                String respuesta = in.readLine();
                if (respuesta == null) {
                    System.out.println("Servidor desconectado");
                    break;
                }

                System.out.println("La suma realizada por el servidor: " + respuesta);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
