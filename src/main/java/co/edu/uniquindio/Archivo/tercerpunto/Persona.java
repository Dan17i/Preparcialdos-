package co.edu.uniquindio.Archivo.tercerpunto;
/**
 * Clase que representa una Persona con nombre, edad y sexo
 */
class Persona {
    String nombre;
    int edad;
    char sexo; // 'M' para masculino, 'F' para femenino

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + ", " + sexo + ")";
    }
}
