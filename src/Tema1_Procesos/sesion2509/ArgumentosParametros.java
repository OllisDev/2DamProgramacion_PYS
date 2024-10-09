package Tema1_Procesos.sesion2509;

public class ArgumentosParametros {
    public static void main(String[] args) {
        // Diferentes formas de pasar el comando a los constructores de ProcessBuilder
// 1ª forma: usando una cadena. Falla con parámetros
        String command1 = "notepad.exe prueba1.txt";
        ProcessBuilder pb = new ProcessBuilder(command1);

// 2ª forma: usando un array de cadenas. Funciona con parámetros
        String[] command2 = {"cmd", "/c", "dir", "/o"};
        ProcessBuilder pb2 = new ProcessBuilder(command2);

// 3ª forma: usando una cadena y dividiéndola para convertirla en una lista
        String command3 = "c:/windows/system32/shutdown -s -t 0";
        ProcessBuilder pb3 = new ProcessBuilder(command3.split("\s"));
    }
}
