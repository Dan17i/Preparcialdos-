package co.edu.uniquindio.Archivo.quintopunto;
import java.util.Stack;

public class BalanceoSimbolos {
    /**
     * Verifica si una cadena tiene paréntesis, corchetes y llaves balanceados.
     * @param expresion Cadena con los símbolos
     * @return true si está balanceada, false si no lo está
     */
    public static boolean estaBalanceada(String expresion) {
        Stack<Character> pila = new Stack<>();

        for (char c : expresion.toCharArray()) {
            // Si es símbolo de apertura, lo apilamos
            if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
            }

            // Si es símbolo de cierre, verificamos
            else if (c == ')' || c == ']' || c == '}') {
                if (pila.isEmpty()) {
                    return false; // cierre sin apertura
                }
                char top = pila.pop();
                if (!esPar(top, c)) {
                    return false; // los símbolos no coinciden
                }
            }
        }

        // Si la pila queda vacía, está balanceado
        return pila.isEmpty();
    }
    /**
     * Verifica si el par de símbolos coincide
     * @param apertura símbolo de apertura
     * @param cierre símbolo de cierre
     * @return true si hacen par correcto
     */
    private static boolean esPar(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
                (apertura == '[' && cierre == ']') ||
                (apertura == '{' && cierre == '}');
    }

    public static void main(String[] args) {
        String ejemplo1 = "(6-7)/4]";
        String ejemplo2 = "[(1+2)*4]+5";

        System.out.println(ejemplo1 + " → " + estaBalanceada(ejemplo1)); // false
        System.out.println(ejemplo2 + " → " + estaBalanceada(ejemplo2)); // true
    }
}

