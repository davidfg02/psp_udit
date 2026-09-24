package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- INICIANDO UDITVERSUM ---");
        //MALA PRÁCTICA: Toda la lógica de negocio tirada al Main, es decir, los diamantes <> obligan a que la lista solo acepte episodios
        ArrayList<Episodio> catalogo = new ArrayList<>();
        catalogo.add(new Episodio("Diseño 3D - Intro", 45));
        catalogo.add(new Episodio("Animación", 60));
        catalogo.add(new Episodio("Texturas", 50));

        // 2. MEDICION DE TIEMPO
        //Usamos long porque los ms son desde 1970 forman un numero tan gigantesco, que no cabe en la memoria int
        long inicio = System.currentTimeMillis();
        //El bucle FOR-EACH "Por cada episodio dentro del catalogo"
        for (Episodio ep : catalogo) {
            ep.procesar();//Aquí ocurre el bloqueo de 2s
        }
        long fin = System.currentTimeMillis();

        //RESULTADO: Restamos fin menos inicioy dividimos entre 1000 para que salga en (s)
        long totalSegundo = (fin - inicio) / 1000;
        System.out.println("Tiempo total = " + totalSegundo + " segundos de bloqueo");
    }
}