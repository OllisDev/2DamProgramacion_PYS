package Tema1_Procesos.sesion2509;

import java.io.IOException;

import static sun.font.FontUtilities.isWindows;

public class ModificarComando {
    public static void main(String[] args) throws IOException {
        String command = "java -jar install.jar -install";
        ProcessBuilder pbuilder = new ProcessBuilder(command.split("\s"));
        if (isWindows) {
            pbuilder.command().add(0, "cmd");
            pbuilder.command().add(1, "/c");
            pbuilder.command().add("c:/temp");
        } else {
            pbuilder.command().add(0, "sh");
            pbuilder.command().add(1, "-c");
            pbuilder.command().add("/tmp");
        }
        pbuilder.start();
    }
}
