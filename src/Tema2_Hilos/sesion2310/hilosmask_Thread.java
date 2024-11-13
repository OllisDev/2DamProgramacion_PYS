package Tema2_Hilos.sesion2310;

public class hilosmask_Thread extends Thread {
    public hilosmask_Thread(String name) {
        super(name);
    }

    public void run() {
        for(int i = 0; i <= 30; i++) {
            System.out.println(this.getName() + " el contador " + i);
            try {
                sleep((long) Math.random());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        hilosmask_Thread minihilosmask1 = new hilosmask_Thread("tesla");
        hilosmask_Thread minihilosmask2 = new hilosmask_Thread("X");
        minihilosmask1.setPriority(Thread.MIN_PRIORITY);
        minihilosmask2.setPriority(Thread.MAX_PRIORITY);
        minihilosmask1.start();
        minihilosmask2.start();
    }
}
