package Tema1_Procesos.sesion2709;

    import java.util.Optional;
    public class ejemplo1 {
        public static void main (String [] args) {
            try {
                ProcessBuilder pb = new ProcessBuilder("notepad.exe");
                Process p = pb.start();


                Optional<ProcessHandle> p2= ProcessHandle.of(p.pid());
                ProcessHandle ph = p2.orElseThrow();
                ProcessHandle.Info processInfo = ph.info();

                System.out.println("PID: " + ph.pid());
                System.out.println("Arguments: " + processInfo.arguments());
                System.out.println("Command: " + processInfo.command());
                System.out.println("Instant: " + processInfo.startInstant());
                System.out.println("Total CPU duration: " + processInfo.totalCpuDuration());
                System.out.println("User: " + processInfo.user());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

