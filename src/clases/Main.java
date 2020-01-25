package clases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    //BUSCA DE MANERA RECURSIVA TODOS LOS FICHEROS .TXT DE UNA RUTA INCLUYENDO SUS DIRECTORIOS INTERNOS
    private static void obtenerFicherosFileRecursivos(String rutaInicial,List<File> tFicheros){

        File f = new File(rutaInicial);
        File[] tArchivos = f.listFiles();

        for (int i=0;i<tArchivos.length;i++){
            if(tArchivos[i].isFile()){
                String nombreArchivo = tArchivos[i].getName();

                String[] partesNombreArchivo = nombreArchivo.split("\\.");

                if(partesNombreArchivo[1].equals("txt")){
                    tFicheros.add(tArchivos[i]);
                }
            }

            if(tArchivos[i].isDirectory()){
                rutaInicial  = tArchivos[i].getAbsolutePath();
                obtenerFicherosFileRecursivos(rutaInicial,tFicheros);
            }
        }
    }

    public static void main(String[] args) throws IOException{

        String rutaInicial = "C:\\Users\\IVAN\\Desktop\\DATOS";
        List<File> tFicheros = new ArrayList<>();

        obtenerFicherosFileRecursivos(rutaInicial,tFicheros);

        for (File f:
             tFicheros) {

            String[] argumentos = {"notepad",f.getAbsolutePath()};

            ProcessBuilder pb = new ProcessBuilder(argumentos);
            Process p = pb.start();
        }
    }
}
