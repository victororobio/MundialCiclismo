/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

// clase base que representa a un atleta generico
public class Atleta {
    // atributos protegidos para que las subclases los hereden
    protected String nombre;
    protected int edad;
    protected String pais;

    // constructor de la clase atleta
    public Atleta(String nombre, int edad, String pais) {
        this.nombre = nombre;
        this.edad = edad;
        this.pais = pais;
    }

    // getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    // sobrescribo toString para mostrar los datos basicos
    @Override
    public String toString() {
        return "Nombre: " + nombre + " / Edad: " + edad + " / Pais: " + pais;
    }
}