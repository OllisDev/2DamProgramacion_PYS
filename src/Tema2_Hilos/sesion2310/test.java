package Tema2_Hilos.sesion2310;

public class test {
    public static void main(String[] args) {
        hilosmask_Runnable minihilomask1 = new hilosmask_Runnable("Tesla");
        hilosmask_Runnable minihilomask2 = new hilosmask_Runnable("X");
        minihilomask1.ejecutarHilo();
        minihilomask2.ejecutarHilo();

    }
}
