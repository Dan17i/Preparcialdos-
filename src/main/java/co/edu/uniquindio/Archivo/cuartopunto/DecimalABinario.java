package co.edu.uniquindio.Archivo.cuartopunto;
import java.util.Stack;

public class DecimalABinario {
    /**
     * Convierte un número decimal positivo a binario usando una pila.
     * @param numero el número decimal a convertir
     * @return el número binario representado como un entero
     */
    public static int convertirABinario(int numero) {
        if (numero == 0) return 0;

        Stack<Integer> pila = new Stack<>();

        // Dividimos sucesivamente entre 2 y guardamos el residuo en la pila
        while (numero > 0) {
            int residuo = numero % 2;
            pila.push(residuo);
            numero = numero / 2;
        }

        // Armamos el número binario desde la pila
        int binario = 0;
        while (!pila.isEmpty()) {
            binario = binario * 10 + pila.pop(); // Construimos el número como entero
        }

        return binario;
    }

    public static void main(String[] args) {
        int numero = 61;
        int binario = convertirABinario(numero);

        System.out.println(numero + "(10) = " + binario + "(2)");
    }
}

