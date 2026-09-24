package org.example;

import java.io.IOException;

public class LanzadorProcesos {
    public static void main(String[] args) {
        System.out.println("Solicitando al SO la creacion de un proceso nativo ...");

        //1. ProcessBuilder: es el puente entre Java y el SO
        //Preparamos el comando en Windows, notepad.exe (es el bloc de notas)

        ProcessBuilder pb = new ProcessBuilder("notepad.exe");
        try {
            //2. start() es el gatillo. Pide al planificador del SO que cree el proceso
            Process process = pb.start();
            System.out.println("Proceso en ejecucion. PID: " + process.pid());
            //3. waitfor() pausa a nuestro hilo en Java hasta que el usuario cierre el bloc de notas
            int salida = process.waitFor();
            //0 significa cierre limpio. Cualquier otro número indica error o cierre forzoso
            System.out.println("El proceso externo finalizó con codigo: " + salida);
        }catch(IOException e){
            System.out.println("Error: el sistema operativo no encuentra el programa");
        }catch(InterruptedException e){
            System.out.println("Error: el proceso fue interrumpido bruscamente");
        }
    }
}
