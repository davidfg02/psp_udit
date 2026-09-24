package org.example;

import java.util.ArrayList;

public class Plataforma {
    //Atributo privado: Una lista elástica que crecerá según añadas videos
    private ArrayList<Episodio> catalogo;

    public Plataforma(){
        //MUY IMPORTANTE. Si no inicializamos la lista connew, Java lanzará un error NullPointerException al intentar usarla
        this.catalogo = new ArrayList<>();
    }
    //METODO AGREGAR: Exigimos que el parametro sea estrictamente de tipo Episodio
    //la 'e' es solo una variable temporal para usarla en la línea de abajo
    public void agregarEpisodio(Episodio e){
        this.catalogo.add(e);
    }
    //METODO PROCESAR:
    public void procesarCatalogo(){

        for (Episodio episodio : this.catalogo){
            episodio.procesar();
        }
    }
}
