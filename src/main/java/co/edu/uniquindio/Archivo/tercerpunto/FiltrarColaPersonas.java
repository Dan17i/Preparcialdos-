package co.edu.uniquindio.Archivo.tercerpunto;

import java.util.LinkedList;
import java.util.Queue;

public class FiltrarColaPersonas {
    /**
     * Elimina de la cola a los hombres cuya edad esté entre 30 y 50 años (inclusive)
     * @param colaOriginal la cola original de personas
     * @return una nueva cola con las personas que no fueron eliminadas
     */
    public static Queue<Persona> filtrarCola(Queue<Persona> colaOriginal) {
        Queue<Persona> colaFiltrada = new LinkedList<>();

        // Procesamos cada elemento de la cola original
        while (!colaOriginal.isEmpty()) {
            Persona p = colaOriginal.poll();

            // Verificamos la condición: si NO es hombre entre 30 y 50, lo conservamos
            if (!(p.sexo == 'M' && p.edad >= 30 && p.edad <= 50)) {
                colaFiltrada.offer(p);
            }
        }

        return colaFiltrada;
    }
    /**
     * Método principal para probar el funcionamiento
     */
    public static void main(String[] args) {
        Queue<Persona> cola = new LinkedList<>();
        cola.offer(new Persona("Ana", 25, 'F'));
        cola.offer(new Persona("Luis", 35, 'M'));
        cola.offer(new Persona("Carlos", 50, 'M'));
        cola.offer(new Persona("María", 45, 'F'));
        cola.offer(new Persona("Pedro", 29, 'M'));
        cola.offer(new Persona("Elena", 60, 'F'));

        System.out.println("Cola original:");
        for (Persona p : cola) {
            System.out.println(p);
        }

        Queue<Persona> filtrada = filtrarCola(cola);

        System.out.println("\nCola filtrada (sin hombres de 30 a 50 años):");
        for (Persona p : filtrada) {
            System.out.println(p);
        }
    }
}
