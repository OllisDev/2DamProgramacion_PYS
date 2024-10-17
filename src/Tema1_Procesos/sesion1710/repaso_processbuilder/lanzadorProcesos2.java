package Tema1_Procesos.sesion1710.repaso_processbuilder;

import java.io.IOException;

public class lanzadorProcesos2 {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder("C://Riot Games//VALORANT//live//VALORANT.exe");
        try {
            processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
