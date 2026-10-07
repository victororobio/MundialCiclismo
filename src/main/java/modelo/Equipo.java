/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

// clase que representa un equipo con varios competidores
public class Equipo {
    private String nombre;
    private String pais;
    private List<Competidor> competidores;

    // constructor inicializa la lista vacia
    public Equipo(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
        this.competidores = new ArrayList<>();
    }

    // getters
    public String getNombre() { return nombre; }
    public String getPais() { return pais; }
    public List<Competidor> getCompetidores() { return competidores; }

    // agrega un competidor a la lista del equipo
    public void agregarCompetidor(Competidor c) {
        competidores.add(c);
    }

    // devuelve los datos del equipo con sus competidores
    public String obtenerDatosEquipo() {
     StringBuilder sb = new StringBuilder();
     sb.append("Equipo: ").append(nombre).append(" - Pais: ").append(pais).append("\n");
        for (Competidor c : competidores) {
        sb.append("   ").append(c.obtenerDatos()).append("\n");
    }
    return sb.toString();
    }
}