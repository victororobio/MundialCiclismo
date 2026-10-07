/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Competencia;
import modelo.Competidor;
import modelo.Equipo;

// controlador que conecta la vista con el modelo
public class ControladorMundial {
    // el controlador mantiene la referencia al modelo
    private Competencia competencia;

    public ControladorMundial() {
        // crea el objeto del modelo
        this.competencia = new Competencia("Mundial de Ciclismo de Pista - Cali");
    }

    // crea un equipo y lo agrega a la competencia
    public boolean crearEquipo(String nombre, String pais) {
        // valida los datos recibidos desde la vista
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        if (pais == null || pais.trim().isEmpty()) {
            return false;
        }
        // crea el objeto del modelo
        Equipo equipo = new Equipo(nombre.trim(), pais.trim());
        // invoca el metodo de negocio del modelo
        competencia.agregarEquipo(equipo);
        return true;
    }

    // crea un competidor y lo agrega al equipo indicado
    public boolean registrarCompetidor(String nombreEquipo, String nombre, int edad,
                                       String pais, int ranking, double estatura, double peso) {
        // busca el equipo en el modelo
        Equipo equipo = competencia.buscarEquipo(nombreEquipo);
        if (equipo == null) {
            return false;
        }
        // crea el objeto del modelo
        Competidor competidor = new Competidor(nombre, edad, pais, ranking, estatura, peso);
        // invoca el metodo de negocio del modelo
        equipo.agregarCompetidor(competidor);
        return true;
    }

    // busca un competidor por nombre en toda la competencia
    private Competidor buscarCompetidor(String nombre) {
        for (Equipo e : competencia.getEquipos()) {
            for (Competidor c : e.getCompetidores()) {
                if (c.getNombre().equalsIgnoreCase(nombre)) {
                    return c;
                }
            }
        }
        return null;
    }

    // invoca el metodo de negocio del modelo para actualizar el ranking
    public boolean actualizarRanking(String nombreCompetidor, int puntos, boolean ganoMedalla) {
        // busca el competidor en el modelo
        Competidor competidor = buscarCompetidor(nombreCompetidor);
        if (competidor == null) {
            return false;
        }
        // invoca el metodo de negocio del modelo (polimorfismo por sobrecarga)
        if (ganoMedalla) {
            competidor.actualizarRanking(puntos, true);
        } else {
            competidor.actualizarRanking(puntos);
        }
        return true;
    }

    // obtiene el reporte desde el modelo
    public String obtenerReporte() {
        return competencia.generarReporte();
    }
}