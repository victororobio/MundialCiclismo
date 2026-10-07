/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import javax.swing.SwingUtilities;
import vista.VistaMundial;

// clase principal que lanza la aplicacion
public class Principal {
    public static void main(String[] args) {
        // ejecuta la vista en el hilo de eventos de swing
        SwingUtilities.invokeLater(() -> {
            new VistaMundial().setVisible(true);
        });
    }
}