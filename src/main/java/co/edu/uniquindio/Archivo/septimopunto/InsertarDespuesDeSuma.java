package co.edu.uniquindio.Archivo.septimopunto;

public class InsertarDespuesDeSuma {

    static class Nodo {
        int valor;
        Nodo siguiente;

        Nodo(int valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    // Método principal que inicia el proceso de inserción
    public static void insertarDos(Nodo cabeza) {
        if (cabeza == null) return;

        // Calcular la suma total de la lista
        int sumaTotal = calcularSuma(cabeza);

        // Imprimir la suma total para verificación
        System.out.println("Suma total de la lista: " + sumaTotal);

        // Insertar el 2 después de los nodos que sean iguales a la suma
        insertarDosRecursivo(cabeza, sumaTotal, 0);
    }

    // Método que calcula la suma de todos los nodos
    private static int calcularSuma(Nodo nodo) {
        int suma = 0;
        while (nodo != null) {
            suma += nodo.valor;
            nodo = nodo.siguiente;
        }
        return suma;
    }

    // Método recursivo para insertar el valor 2 después del nodo que tiene valor igual a la suma
    private static void insertarDosRecursivo(Nodo nodo, int sumaTotal, int sumaAcumulada) {
        if (nodo == null) return;

        // Verificar si la suma acumulada es igual al valor del nodo
        if (sumaAcumulada == nodo.valor) {
            Nodo nuevo = new Nodo(2);
            nuevo.siguiente = nodo.siguiente;
            nodo.siguiente = nuevo;
            System.out.println("Se insertó un 2 después del nodo con valor " + nodo.valor);
        }

        // Llamada recursiva para el siguiente nodo
        insertarDosRecursivo(nodo.siguiente, sumaTotal, sumaAcumulada + nodo.valor);
    }

    // Método para imprimir la lista
    public static void imprimirLista(Nodo cabeza) {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Caso donde NO se debe insertar el 2 (suma = 22)
        Nodo cabeza1 = new Nodo(1);
        cabeza1.siguiente = new Nodo(3);
        cabeza1.siguiente.siguiente = new Nodo(6); // Suma = 12
        cabeza1.siguiente.siguiente.siguiente = new Nodo(12);

        System.out.println("Lista original (suma = 22):");
        imprimirLista(cabeza1);

        insertarDos(cabeza1);

        System.out.println("Lista después de intentar insertar 2:");
        imprimirLista(cabeza1);

        // Caso donde SÍ se debe insertar el 2 (suma = 12)
        Nodo cabeza2 = new Nodo(1);
        cabeza2.siguiente = new Nodo(2);
        cabeza2.siguiente.siguiente = new Nodo(3);
        cabeza2.siguiente.siguiente.siguiente = new Nodo(8); // Suma = 12
        cabeza2.siguiente.siguiente.siguiente.siguiente = new Nodo(12);

        System.out.println("\nLista original (suma = 12):");
        imprimirLista(cabeza2);

        insertarDos(cabeza2);

        System.out.println("Lista después de insertar 2:");
        imprimirLista(cabeza2);
    }
}
