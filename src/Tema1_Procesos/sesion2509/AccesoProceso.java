package Tema1_Procesos.sesion2509;

import java.util.concurrent.TimeUnit;

public class AccesoProceso {
    public static void main(String[] args) throws Exception {

        ProcessBuilder pb = new ProcessBuilder("C:/Program Files (x86)/Notepad++/notepad++.exe");
        // Effectively launch the process
        Process p = pb.start();
        // Check is process is alive or not
        boolean alive = p.isAlive();
        // Wait for the process to end for 10 seconds.
        if (p.waitFor(10, TimeUnit.SECONDS)) {
            System.out.println("Process has finished");
        } else {
            System.out.println("Timeout. Process hasn't finished");
        }
        // Force process termination.
        p.destroy();
        // Check again if process remains alive
        alive = p.isAlive();
        // Get the process exit value
        int status = p.exitValue();
    }
}
