package controlador;

import modelo.ClaseModelo;
import vista.ClaseVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClaseControlador {
    private ClaseVista vista;
    private ClaseModelo modelo;

    public ClaseControlador(ClaseVista vista) {
        this.vista = vista;
        this.modelo = null; // No hay modelo inicializado
    }

    // Acción cuando se presiona el botón "CREAR MATRIZ PRINCIPAL"
    public ActionListener crearMatrizAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int filas = vista.obtenerFilas();  // Obtener filas desde la Vista
                    int columnas = vista.obtenerColumnas();  // Obtener columnas desde la Vista
                    modelo = new ClaseModelo(filas, columnas);  // Crear el modelo con las dimensiones

                    modelo.generarMatriz();  // Llenar la matriz en el Modelo

                    vista.mostrarMatriz(modelo.getMatriz());  // Mostrar la matriz generada en la Vista
                } catch (NumberFormatException ex) {
                    vista.mostrarError("Por favor ingrese valores válidos para filas y columnas.");
                } catch (IllegalArgumentException ex) {
                    vista.mostrarError(ex.getMessage());
                }
            }
        };
    }
}
