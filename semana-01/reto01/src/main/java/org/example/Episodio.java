package org.example;

public class Episodio {
    //ATRIBUTOS: Variables privadas por seguridad
    //Solo esta clase puede modificar directamente
    private String titulo;
    private int duracion;

    //CONSTRUCTORES: El molde que ejecuta al hacer un new Episodio
    public Episodio(String titulo, int duracion)
    {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    //METODO: La acción que simula la carga lenta dels ervidor
    public void procesar(){
        System.out.println("Iniciando procesamiento de: " + this.titulo + "...");
        //El bloque try-catch es obligatorio en java al pausar el hilo
        //Evita que el programa explote (crash) si el SO interrumpe la pausa
        try{
            //Pausamos la ejecucion en 2000ms (2s)
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println("Error al procesar episodio");
        }
        System.out.println("Completado: "+ this.titulo);
    }
}
