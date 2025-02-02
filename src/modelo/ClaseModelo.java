package modelo;

public class ClaseModelo {
    private int filas;
    private int columnas;
    private int[][] matriz;

    // Constructor que recibe filas y columnas
    public ClaseModelo(int filas, int columnas) {
        if (filas <= 0 || columnas <= 0) {
            throw new IllegalArgumentException("Las filas y columnas deben ser positivas");
        }
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new int[filas][columnas]; // Crear la matriz
    }

    // Método para llenar la matriz (por ejemplo, con valores aleatorios)
    public void generarMatriz() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = (int) (Math.random() * 10); // Asignar valores aleatorios (solo ejemplo)
            }
        }
    }

    // Getter para la matriz
    public int[][] getMatriz() {
        return matriz;
    }

    // Método para obtener el tamaño de la matriz
    public String obtenerTamaño() {
        return "Filas: " + filas + ", Columnas: " + columnas;
    }
    
}


/*
    public void establecerObstaculo(int fila, int columna) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            matriz[fila][columna] = -1;  // Usamos -1 para representar un obstáculo
        }
    }
*/