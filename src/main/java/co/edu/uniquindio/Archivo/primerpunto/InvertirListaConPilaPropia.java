package co.edu.uniquindio.Archivo.primerpunto;

public class InvertirListaConPilaPropia {
    public static void main(String[] args) {

                ListaSimple lista = new ListaSimple();
                lista.agregar("A");
                lista.agregar("B");
                lista.agregar("C");
                lista.agregar("D");
                lista.agregar("E");

                System.out.println("Lista original:");
                lista.mostrar();

                ListaSimple invertida = lista.invertirConPila();

                System.out.println("Lista invertida:");
                invertida.mostrar();


    }
}
