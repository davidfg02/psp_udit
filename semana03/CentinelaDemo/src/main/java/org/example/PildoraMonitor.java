package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PildoraMonitor {

    public static void main(String[] args) {
        System.out.println("==MONITOR UDIFLIX==");
        System.out.println("Comprobando servicios...");

        //TRY-CATCH
        //Lanzar un programa externo o esperar a que termine puede fallar
        //try = intenta hacer esto
        //catch = si algo sale mal, haz esto otro

        try {
            //PASO 1: PREPARAR EL PROCESO (todavia no se ejecuta)
            //ProcessBuilder es el "encargado" que prepara la orden que daremos al sistema operativo
            //Es como rellenar un formulario
            //"ping" -> programa que queremos ejecutar
            //"-n" -> es la opcion de Windows numero de intentos (SOLO VALE EN WINDOWS)
            //"1" -> haz solo 1 intento
            //"127.0.0.1" -> es a quien hacemos ping : nuestro propio ordenador (siempre responde, simula un servicio ACTIVO)
            ProcessBuilder pb = new ProcessBuilder(
                    "ping", "-n", "1", "127.0.0.x"
            );

            //PASO 2: UNIR LOS DOS CANALES DE SALIDA
            //_Todo programa tiene dos canales por los que "habla"
            //- salida normal (lo que funciona bien)
            //- salida de error (los mensajes de fallo)
            //Con redirectErrorStream(true) lo juntamos todo en uno solo
            //Así, leyendo un unico canal, vemos _todo lo que el provceso diga, sea un resultado normal o un error
            pb.redirectErrorStream(true);

            //PASO 3: LANZAR EL PROCESO
            //start() es el boton de "enviar". Ahora si el SO crea un programa nuevo (ping) que corre por su cuenta
            //con su propia memoria, separado de nuestro programa de java
            //Process es el objeto con el que controlamos el programa

            Process proceso = pb.start();

            //PASO 4: MOSTRAR EL PID
            //PID -> Process Identifier (es el DNI del proceso)

            System.out.println("PID= " + proceso.pid());

            //PASO 5: PREPARAR LA LECTURA DE LO QUE DICE EL PROCESO
            //El proceso ping escribe su propia consola que java no ve, para escucharlo nos "conectamos" a su salida con un String
            //proceso.getInputString() -> la "tuberia" por la que sale el texto del proceso (en bytes)
            //new InputStreamReader(...) -> traduce esos bytes a letra
            //new BufferReader(...) -> nos deja leer linea a linea
            BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            //variable donde guardaremos cada linea que vayamos leyendo
            //Todavía está vacía
            String linea;

            //PASO 6: LEER _TODO LO QUE EL PROCESO VA ESCRIBIENDO
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
            //PASO 7: ESPERAR A QUE EL PROCESO TERMINE
            //waitFor() ees lo que nos garantiza el código de salida
            int codigo = proceso.waitFor();

            //PASO 8: INTERPRETAR EL RESULTADO
            if (codigo == 0) {
                System.out.println("Estado: SERVICIO ACTIVO");
            } else {
                System.out.println("Estado: SERVICIO ERROR");
            }
        } catch (IOException e) {
            System.out.println("No se pudo lanzar el proceso");
        } catch (InterruptedException e) {
            System.out.println("La ejecución fue interrumpida");
        }
    }
}