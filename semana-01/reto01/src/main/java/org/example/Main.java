package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- INICIANDO UDITVERSUM ---");
        //MALA PRÁCTICA: Toda la lógica de negocio tirada al Main, es decir, los diamantes <> obligan a que la lista solo acepte episodios
        Plataforma plataforma = new Plataforma();
        plataforma.agregarEpisodio(new Episodio("Diseño 3D", 46));
        plataforma.agregarEpisodio(new Episodio("Animacion", 60));
        plataforma.agregarEpisodio(new Episodio("Programacion", 82));
        plataforma.agregarEpisodio(new Episodio("ASIR", 64));
        plataforma.agregarEpisodio(new Episodio("Diseño 3D - Fin", 46));

        // 2. MEDICION DE TIEMPO
        //Usamos long porque los ms son desde 1970 forman un numero tan gigantesco, que no cabe en la memoria int
        long inicio = System.currentTimeMillis();
        //El bucle FOR-EACH "Por cada episodio dentro del catalogo"
        plataforma.procesarCatalogo();
        long fin = System.currentTimeMillis();
        //RESULTADO: Restamos fin menos inicioy dividimos entre 1000 para que salga en (s)
        long totalSegundo = (fin - inicio) / 1000;
        System.out.println("Tiempo total = " + totalSegundo + " segundos de bloqueo");
    }
}