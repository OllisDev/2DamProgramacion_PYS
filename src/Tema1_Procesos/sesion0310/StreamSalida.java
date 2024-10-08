package Tema1_Procesos.sesion0310;

import java.io.*;
import java.nio.file.Path;

public class StreamSalida {
        public static void main (String[] args) {

            File f = new File ("C:\\Users\\Iker\\Downloads\\hola.txt");
            try {
                FileInputStream fis = new FileInputStream(f);

                // Reads the first byte
                int i = fis.read();

                while(i != -1) {
                    System.out.print((char)i);
                    // Reads next byte from the file
                    i = fis.read();
                }
                fis.close();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
}



