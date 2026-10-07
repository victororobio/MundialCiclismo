/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

// clase competidor que hereda de atleta e implementa la interfaz
public class Competidor extends Atleta implements IGestionRanking {
    // atributos propios del competidor
    private int rankingMundial;
    private double estatura;
    private double peso;
    private int puntos;

    // constructor que llama al constructor de la superclase
    public Competidor(String nombre, int edad, String pais,
                      int rankingMundial, double estatura, double peso) {
        super(nombre, edad, pais);
        this.rankingMundial = rankingMundial;
        this.estatura = estatura;
        this.peso = peso;
        this.puntos = 0;
    }

    // getters y setters
    public int getRankingMundial() { return rankingMundial; }
    public void setRankingMundial(int rankingMundial) { this.rankingMundial = rankingMundial; }
    public double getEstatura() { return estatura; }
    public void setEstatura(double estatura) { this.estatura = estatura; }
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
    public int getPuntos() { return puntos; }

    // metodo sobrecargado 1: solo suma puntos
    @Override
    public void actualizarRanking(int puntosObtenidos) {
        this.puntos += puntosObtenidos;
        // si supera 100 puntos mejora dos posiciones, si no una
        if (this.puntos > 100) {
            this.rankingMundial -= 2;
        } else {
            this.rankingMundial -= 1;
        }
        // evita que el ranking quede en cero o negativo
        if (this.rankingMundial < 1) {
            this.rankingMundial = 1;
        }
    }

    // metodo sobrecargado 2: tiene en cuenta si gano medalla
    @Override
    public void actualizarRanking(int puntosObtenidos, boolean ganoMedalla) {
        // estructura condicional anidada
        if (ganoMedalla) {
            if (puntosObtenidos > 50) {
                this.puntos += puntosObtenidos + 20;
                this.rankingMundial -= 5;
            } else {
                this.puntos += puntosObtenidos + 10;
                this.rankingMundial -= 3;
            }
        } else {
            // si no gano medalla usa el metodo sobrecargado simple
            actualizarRanking(puntosObtenidos);
        }
        // evita ranking negativo
        if (this.rankingMundial < 1) {
            this.rankingMundial = 1;
        }
    }

    // implementa el metodo de la interfaz
    @Override
    public String obtenerDatos() {
        return super.toString() 
            + " / Ranking: " + rankingMundial 
            + " / Estatura: " + estatura + " m" 
            + " / Peso: " + peso + " kg" 
            + " / Puntos: " + puntos;
    }
}
