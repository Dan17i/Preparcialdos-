package co.edu.uniquindio.Archivo.primerpunto;

import java.util.Stack;
/**
 * Clase que representa una Lista Simple con operaciones básicas
 */
class ListaSimple {
    /**
     * Nodo de la lista
     */
    static class Nodo {
        String valor;
        Nodo siguiente;

        Nodo(String valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    private Nodo cabeza;
    /**
     * Agrega un elemento al final de la lista
     * @param valor el valor a agregar
     */
    public void agregar(String valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }
    /**
     * Muestra los elementos de la lista
     */
    public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
    /**
     * Invierte la lista actual usando una pila y retorna la nueva lista
     * @return una nueva ListaSimple con los elementos invertidos
     */
    public ListaSimple invertirConPila() {
        Stack<String> pila = new Stack<>();
        Nodo actual = cabeza;

        // Apilar todos los valores de la lista
        while (actual != null) {
            pila.push(actual.valor);
            actual = actual.siguiente;
        }

        // Crear nueva lista con elementos desapilados
        ListaSimple invertida = new ListaSimple();
        while (!pila.isEmpty()) {
            invertida.agregar(pila.pop());
        }

        return invertida;
    }
}

