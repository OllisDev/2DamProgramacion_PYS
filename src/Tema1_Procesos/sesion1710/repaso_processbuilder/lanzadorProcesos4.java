package Tema1_Procesos.sesion1710.repaso_processbuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class lanzadorProcesos4 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("python", "C://Users//Iker//Downloads//generador.py");
        try {
            Process proceso = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String numeroGenerado = reader.readLine();
            int numeroSecreto = Integer.parseInt(numeroGenerado);

            Scanner scanner = new Scanner(System.in);
            int intento = 0;
            System.out.println("Adivina el número entre 1 y 100:");

            while (intento != numeroSecreto) {
                intento = scanner.nextInt();
                if (intento < numeroSecreto) {
                    System.out.println("El número es mayor.");
                } else if (intento > numeroSecreto) {
                    System.out.println("El número es menor.");
                } else {
                    System.out.println("¡Felicidades! Has adivinado el número.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
