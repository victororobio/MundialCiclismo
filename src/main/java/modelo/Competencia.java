/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

// clase que representa la competencia con todos los equipos
public class Competencia {
    private String nombreEvento;
    private List<Equipo> equipos;

    public Competencia(String nombreEvento) {
        this.nombreEvento = nombreEvento;
        this.equipos = new ArrayList<>();
    }

    // getters
    public String getNombreEvento() { return nombreEvento; }
    public List<Equipo> getEquipos() { return equipos; }

    // agrega un equipo a la competencia
    public void agregarEquipo(Equipo e) {
        equipos.add(e);
    }

    // busca un equipo por su nombre sin importar mayusculas
    public Equipo buscarEquipo(String nombre) {
        for (Equipo e : equipos) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        return null;
    }

    // genera el reporte general de la competencia
    public String generarReporte() {
    StringBuilder sb = new StringBuilder();
    sb.append("MUNDIAL DE CICLISMO DE PISTA")
      .append("Evento: ").append(nombreEvento).append("\n\n");
      
    for (Equipo e : equipos) {
        sb.append(e.obtenerDatosEquipo()).append("\n");
    }
    return sb.toString();
}
}
