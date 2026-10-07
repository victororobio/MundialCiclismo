/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

// interfaz que define las operaciones de gestion de ranking
public interface IGestionRanking {
    void actualizarRanking(int puntosObtenidos);
    void actualizarRanking(int puntosObtenidos, boolean ganoMedalla);
    String obtenerDatos();
}
