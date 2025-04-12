package co.edu.uniquindio.Archivo.segundopunto;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Clase con métodos para trabajar con pilas y colas
 */
public class PilaAColaPrimos {
    /**
     * Verifica si un número es primo
     * @param n número a verificar
     * @return true si es primo, false en caso contrario
     */
    private static boolean esPrimo(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
    /**
     * Extrae los números primos de la pila y los coloca en una cola
     * @param pila pila de enteros positivos
     * @return una cola con los elementos primos de la pila
     */
    public static Queue<Integer> extraerPrimos(Stack<Integer> pila) {
        Stack<Integer> temporal = new Stack<>();
        Queue<Integer> colaPrimos = new LinkedList<>();

        // Extraemos elementos de la pila original
        while (!pila.isEmpty()) {
            int valor = pila.pop();

            // Si es primo, lo agregamos a la cola
            if (esPrimo(valor)) {
                colaPrimos.offer(valor);
            }

            // Guardamos el valor para restaurar la pila después (opcional)
            temporal.push(valor);
        }

        // Restauramos la pila original (opcional, para no perder sus elementos)
        while (!temporal.isEmpty()) {
            pila.push(temporal.pop());
        }

        return colaPrimos;
    }
    /**
     * Método principal para probar el comportamiento
     */
    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<>();
        pila.push(10);
        pila.push(3);
        pila.push(5);
        pila.push(8);
        pila.push(7);
        pila.push(15);

        System.out.println("Pila original: " + pila);

        Queue<Integer> colaPrimos = extraerPrimos(pila);

        System.out.println("Cola con números primos: " + colaPrimos);
        System.out.println("Pila después del proceso (restaurada): " + pila);
    }
}
