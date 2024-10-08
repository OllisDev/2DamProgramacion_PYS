package Tema1_Procesos.sesion2609;

public class ProccesHandle {
    public static void main(String[] args) {
        ProcessHandle processHandle = ProcessHandle.current();
        ProcessHandle.Info processInfo = processHandle.info();

        System.out.println("PID: " + processHandle.pid());
        System.out.println("Arguments: " + processInfo.arguments());
        System.out.println("Command: " + processInfo.command());
        System.out.println("Instant: " + processInfo.startInstant());
        System.out.println("Total CPU duration: " + processInfo.totalCpuDuration());
        System.out.println("User: " + processInfo.user());
    }

}
