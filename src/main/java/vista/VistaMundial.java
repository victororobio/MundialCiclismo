/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorMundial;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// ventana principal del sistema usando swing
public class VistaMundial extends JFrame {
    // la vista conoce al controlador, no al modelo
    private ControladorMundial controlador;
    private JTextArea areaReporte;

    public VistaMundial() {
        // crea el controlador
        this.controlador = new ControladorMundial();
        initComponents();
    }

    // construye la interfaz grafica
    private void initComponents() {
        setTitle("Mundial de Ciclismo de Pista - Cali");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // panel con los botones a la izquierda
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnCrearEquipo = new JButton("Crear Equipo");
        JButton btnRegistrarCompetidor = new JButton("Registrar Competidor");
        JButton btnActualizarRanking = new JButton("Actualizar Ranking");
        JButton btnMostrarReporte = new JButton("Mostrar Reporte");

        panelBotones.add(btnCrearEquipo);
        panelBotones.add(btnRegistrarCompetidor);
        panelBotones.add(btnActualizarRanking);
        panelBotones.add(btnMostrarReporte);

        // area de texto para el reporte
        areaReporte = new JTextArea();
        areaReporte.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaReporte);

        add(panelBotones, BorderLayout.WEST);
        add(scroll, BorderLayout.CENTER);

        // accion del boton crear equipo
        btnCrearEquipo.addActionListener(e -> crearEquipo());

        // accion del boton registrar competidor
        btnRegistrarCompetidor.addActionListener(e -> registrarCompetidor());

        // accion del boton actualizar ranking
        btnActualizarRanking.addActionListener(e -> actualizarRanking());

        // accion del boton mostrar reporte
        btnMostrarReporte.addActionListener(e -> mostrarReporte());
    }

    // pide los datos al usuario y llama al controlador
    private void crearEquipo() {
        try {
            String nombre = JOptionPane.showInputDialog(this, "Nombre del equipo:");
            String pais = JOptionPane.showInputDialog(this, "Pais del equipo:");
            boolean ok = controlador.crearEquipo(nombre, pais);
            if (ok) {
                JOptionPane.showMessageDialog(this, "Equipo creado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Datos invalidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // pide los datos y registra un competidor a traves del controlador
    private void registrarCompetidor() {
        try {
            String nombreEquipo = JOptionPane.showInputDialog(this, "Nombre del equipo:");
            String nombre = JOptionPane.showInputDialog(this, "Nombre del competidor:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog(this, "Edad:"));
            String pais = JOptionPane.showInputDialog(this, "Pais:");
            int ranking = Integer.parseInt(JOptionPane.showInputDialog(this, "Ranking mundial:"));
            double estatura = Double.parseDouble(JOptionPane.showInputDialog(this, "Estatura (m):"));
            double peso = Double.parseDouble(JOptionPane.showInputDialog(this, "Peso (kg):"));

            // llama al controlador que es quien invoca al modelo
            boolean ok = controlador.registrarCompetidor(nombreEquipo, nombre, edad, pais, ranking, estatura, peso);
            if (ok) {
                JOptionPane.showMessageDialog(this, "Competidor registrado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "El equipo no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            // error cuando el usuario escribe letras donde van numeros
            JOptionPane.showMessageDialog(this, "Debe ingresar valores numericos validos.",
                    "Error de formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // actualiza el ranking del competidor a traves del controlador
    private void actualizarRanking() {
        try {
            String nombre = JOptionPane.showInputDialog(this, "Nombre del competidor:");
            int puntos = Integer.parseInt(JOptionPane.showInputDialog(this, "Puntos obtenidos:"));
            int opcion = JOptionPane.showConfirmDialog(this, "Gano medalla?", "Medalla", JOptionPane.YES_NO_OPTION);
            boolean ganoMedalla = (opcion == JOptionPane.YES_OPTION);

            boolean ok = controlador.actualizarRanking(nombre, puntos, ganoMedalla);
            if (ok) {
                JOptionPane.showMessageDialog(this, "Ranking actualizado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "El competidor no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un numero valido.",
                    "Error de formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // muestra el reporte que devuelve el controlador
    private void mostrarReporte() {
        areaReporte.setText(controlador.obtenerReporte());
    }
}