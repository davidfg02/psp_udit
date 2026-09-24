package org.example;

import java.io.IOException;

public class LanzadorVideo {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "start", "https://www.youtube.com/watch?v=LXb3EKWsInQ");
        try {
            Process process = processBuilder.start();
            System.out.println("Proceso en ejecucion. PID: " + process.pid());

        } catch (IOException e) {
            System.out.println("Error: el sistema operativo no encuentra el programa");
        }
        System.out.println("¡Video lanzado con éxito!");
    }
}