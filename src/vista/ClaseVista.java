package vista;

import java.awt.*;
import javax.swing.*;

public class ClaseVista {

    private JFrame miVentana;

    // Paneles
    private JPanel panelMatrizDinamica;
    private JPanel miPanel;
    private JPanel miPanelMatriz;

    // Botones
    private JButton btnSelecObstaculos;
    private JButton btnElegirBusqueda;
    private JButton btnEjecutarBusqueda;
    private JButton btnVisualizarResultados;
    private JButton btnInicioYfinal;
    private JButton btnReiniciarTodo;
    private JButton btnMatrizPrincipal;

    // Campos de texto
    private JTextField matrizFila;
    private JTextField matrizColumna;

    // Etiquetas
    private JLabel fila;
    private JLabel columna;

    // Menú y elementos del menú
    private JPopupMenu menu;
    private JMenuItem item1;
    private JMenuItem item2;
    private JMenuItem item3;
    private JMenuItem item4;

    public ClaseVista() {
        // Crear el JFrame
        miVentana = new JFrame("Laberinto");
        miVentana.setSize(650, 750);
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miVentana.setLocationRelativeTo(null);

        // Inicializar paneles
        miPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        miPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        miPanel.setBackground(new Color(45, 45, 45));

        miPanelMatriz = new JPanel(new GridLayout(1, 5, 10, 10));
        miPanelMatriz.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        miPanelMatriz.setBackground(Color.DARK_GRAY);

        panelMatrizDinamica = new JPanel();
        panelMatrizDinamica.setLayout(new GridLayout(1, 1));

        // Inicializar botones
        btnSelecObstaculos = new JButton("Seleccionar Obstaculos");
        btnSelecObstaculos.setBackground(new Color(70, 130, 180));
        btnSelecObstaculos.setForeground(Color.WHITE);

        btnElegirBusqueda = new JButton("Elegir Busqueda");
        btnElegirBusqueda.setBackground(new Color(34, 139, 34));
        btnElegirBusqueda.setForeground(Color.WHITE);

        btnEjecutarBusqueda = new JButton("Ejecutar");
        btnEjecutarBusqueda.setBackground(new Color(220, 20, 60));
        btnEjecutarBusqueda.setForeground(Color.WHITE);

        btnVisualizarResultados = new JButton("Visualizar Resultados");
        btnVisualizarResultados.setBackground(new Color(255, 140, 0));
        btnVisualizarResultados.setForeground(Color.WHITE);

        btnInicioYfinal = new JButton("Inicio & Final");
        btnInicioYfinal.setBackground(new Color(255, 69, 0));
        btnInicioYfinal.setForeground(Color.WHITE);

        btnReiniciarTodo = new JButton("Reiniciar Todo");
        btnReiniciarTodo.setBackground(new Color(220, 20, 60));
        btnReiniciarTodo.setForeground(Color.WHITE);

        btnMatrizPrincipal = new JButton("Crear Matriz");
        btnMatrizPrincipal.setBackground(new Color(34, 139, 34));
        btnMatrizPrincipal.setForeground(Color.WHITE);

        // Inicializar campos de texto
        matrizFila = new JTextField("");
        matrizColumna = new JTextField("");

        // Inicializar etiquetas
        fila = new JLabel("            Fila");
        fila.setForeground(Color.WHITE);
        columna = new JLabel("         Columna");
        columna.setForeground(Color.WHITE);

        // Inicializar menú y elementos
        menu = new JPopupMenu();
        item1 = new JMenuItem("Método recursivo simple");
        item2 = new JMenuItem("Método con programación dinámica (cache).");
        item3 = new JMenuItem("BFS (Breadth-First Search)");
        item4 = new JMenuItem("DFS (Depth-First Search)");

        // Agregar elementos al menú
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);

        // Acción del botón para mostrar el menú
        btnElegirBusqueda.addActionListener(e -> menu.show(btnElegirBusqueda, 0, btnElegirBusqueda.getHeight()));

        // Acción del botón para crear la matriz
        btnMatrizPrincipal.addActionListener(e -> {
            try {
                int filas = Integer.parseInt(matrizFila.getText());
                int columnas = Integer.parseInt(matrizColumna.getText());

                if (filas <= 0 || columnas <= 0) {
                    JOptionPane.showMessageDialog(miVentana, "Por favor ingrese valores positivos para filas y columnas.");
                    return;
                }

                panelMatrizDinamica.removeAll();
                panelMatrizDinamica.setLayout(new GridLayout(filas, columnas, 1, 1));

                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        JPanel cuadrado = new JPanel() {
                            @Override
                            protected void paintComponent(Graphics g) {
                                super.paintComponent(g);
                                g.setColor(Color.BLACK);
                                g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
                            }
                        };
                        cuadrado.setBackground(Color.WHITE);
                        panelMatrizDinamica.add(cuadrado);
                    }
                }

                panelMatrizDinamica.revalidate();
                panelMatrizDinamica.repaint();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(miVentana, "Por favor ingrese valores válidos para filas y columnas.");
            }
        });

        miPanelMatriz.add(fila);
        miPanelMatriz.add(matrizFila);
        miPanelMatriz.add(columna);
        miPanelMatriz.add(matrizColumna);
        miPanelMatriz.add(btnMatrizPrincipal);

        miPanel.add(btnSelecObstaculos);
        miPanel.add(btnElegirBusqueda);
        miPanel.add(btnInicioYfinal);
        miPanel.add(btnVisualizarResultados);
        miPanel.add(btnReiniciarTodo);
        miPanel.add(btnEjecutarBusqueda);

        miVentana.setLayout(new BorderLayout());
        miVentana.add(miPanelMatriz, BorderLayout.NORTH);
        miVentana.add(miPanel, BorderLayout.SOUTH);
        miVentana.add(new JScrollPane(panelMatrizDinamica), BorderLayout.CENTER);

        miVentana.setVisible(true);
    }
}