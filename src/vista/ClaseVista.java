package vista;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClaseVista {

    private JPanel panelMatrizDinamica;
    private JFrame miVentana;

    // Hacer que estos campos sean atributos de la clase
    private JTextField matrizFila;
    private JTextField matrizColumna;

    public ClaseVista() {
        // Crear el JFrame
        miVentana = new JFrame("LABERINTO");
        miVentana.setSize(1000, 600);
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miVentana.setLocationRelativeTo(null);

        // Crear los paneles
        JPanel miPanel = new JPanel(); // Panel para los botones
        JPanel miPanelMatriz = new JPanel(); // Panel para los controles de la matriz
        panelMatrizDinamica = new JPanel(); // Panel para la matriz (se llenará dinámicamente)
        panelMatrizDinamica.setLayout(new GridLayout(0, 1)); // Usar GridLayout para la matriz

        // Crear los botones
        JButton btnSelecObstaculos = new JButton("SELECCIONAR OBSTACULOS");
        JButton btnElegirBusqueda = new JButton("ELEGIR BUSQUEDA");
        JButton btnEjecutarBusqueda = new JButton("EJECUTAR");
        JButton btnVisualizarResultados = new JButton("VISUALIZAR RESULTADOS");
        JButton btnInicioYfinal = new JButton("INICIO & FINAL");
        JButton btnReiniciarTodo = new JButton("REINICIAR TODO");
        JButton btnMatrizPrincipal = new JButton("CREAR MATRIZ PRINCIPAL");

        // Crear los JTextField para la matriz (ahora como atributos)
        matrizFila = new JTextField(10);
        matrizColumna = new JTextField(10);

        // Crear los JLabel
        JLabel fila = new JLabel("Fila");
        JLabel columna = new JLabel("Columna");

        // Crear el JPopupMenu y los JMenuItem
        JPopupMenu menu = new JPopupMenu();
        JMenuItem item1 = new JMenuItem("Método recursivo simple");
        JMenuItem item2 = new JMenuItem("Método con programación dinámica (cache).");
        JMenuItem item3 = new JMenuItem("BFS (Breadth-First Search)");
        JMenuItem item4 = new JMenuItem("DFS (Depth-First Search)");

        // Agregar los elementos al menú
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);

        // Acción del botón para mostrar el menú
        btnElegirBusqueda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.show(btnElegirBusqueda, 0, btnElegirBusqueda.getHeight());
            }
        });

        // Acción del botón para crear la matriz
        btnMatrizPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int filas = Integer.parseInt(matrizFila.getText());
                    int columnas = Integer.parseInt(matrizColumna.getText());

                    if (filas <= 0 || columnas <= 0) {
                        JOptionPane.showMessageDialog(miVentana, "Por favor ingrese valores positivos para filas y columnas.");
                        return;
                    }

                    // Limpiar el panel de la matriz antes de crear la nueva
                    panelMatrizDinamica.removeAll();
                    panelMatrizDinamica.setLayout(new GridLayout(filas, columnas, 1, 1)); // Espacio entre celdas

                    // Crear la matriz con cuadrados
                    for (int i = 0; i < filas; i++) {
                        for (int j = 0; j < columnas; j++) {
                            JPanel cuadrado = new JPanel() {
                                @Override
                                protected void paintComponent(Graphics g) {
                                    super.paintComponent(g);
                                    g.setColor(Color.BLACK);
                                    g.drawRect(0, 0, getWidth() - 1, getHeight() - 1); // Dibujar el cuadrado
                                }
                            };
                            cuadrado.setBackground(Color.WHITE);
                            panelMatrizDinamica.add(cuadrado);
                        }
                    }

                    // Actualizar la interfaz para reflejar los cambios
                    panelMatrizDinamica.revalidate();
                    panelMatrizDinamica.repaint();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(miVentana, "Por favor ingrese valores válidos para filas y columnas.");
                }
            }
        });

        // Agregar los componentes al panel de matriz
        miPanelMatriz.add(fila);
        miPanelMatriz.add(matrizFila);
        miPanelMatriz.add(columna);
        miPanelMatriz.add(matrizColumna);
        miPanelMatriz.add(btnMatrizPrincipal);

        // Agregar los botones al panel principal
        miPanel.add(btnSelecObstaculos);
        miPanel.add(btnElegirBusqueda);
        miPanel.add(btnInicioYfinal);
        miPanel.add(btnVisualizarResultados);
        miPanel.add(btnReiniciarTodo);
        miPanel.add(btnEjecutarBusqueda);        

        // Configuración de la ventana
        miVentana.setLayout(new BorderLayout());
        miVentana.add(miPanelMatriz, BorderLayout.NORTH); // Controles en la parte superior
        miVentana.add(miPanel, BorderLayout.SOUTH); // Botones en la parte inferior
        miVentana.add(new JScrollPane(panelMatrizDinamica), BorderLayout.CENTER); // Matriz en el centro con scroll

        // Hacer la ventana visible
        miVentana.setVisible(true);
    }

    // Métodos que te permitirán acceder a los valores de las filas y columnas desde el controlador
    public int obtenerFilas() {
        return Integer.parseInt(matrizFila.getText());
    }

    public int obtenerColumnas() {
        return Integer.parseInt(matrizColumna.getText());
    }

    // Método para mostrar la matriz generada en la vista
    public void mostrarMatriz(int[][] matriz) {
        panelMatrizDinamica.removeAll();
        int filas = matriz.length;
        int columnas = matriz[0].length;
        panelMatrizDinamica.setLayout(new GridLayout(filas, columnas));

        // Crear la matriz en la vista
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                JPanel cuadrado = new JPanel();
                cuadrado.setBackground(Color.black);
                cuadrado.add(new JLabel(String.valueOf(matriz[i][j])));
                panelMatrizDinamica.add(cuadrado);
            }
        }
        panelMatrizDinamica.revalidate();
        panelMatrizDinamica.repaint();
    }

    // Método para mostrar mensajes de error
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}





