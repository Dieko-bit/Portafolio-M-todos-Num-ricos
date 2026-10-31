public class GaussJordan {

    /**
     * Resuelve el sistema aplicando Gauss-Jordan.
     * Reutiliza la triangulación superior del módulo Gauss e implementa
     * la normalización y el barrido superior.
     *
     * @param matriz Matriz aumentada [n][n+1]
     */
    public static void resolver(double[][] matriz) {
        int n = matriz.length;

        // 1. Reutilizamos la eliminación gaussiana (triangulación superior)
        // Nota: Asegúrate de importar la librería o clase Gauss del JAR vinculado.
        Gauss.eliminacionGaussiana(matriz);

        // 2. Normalización y barrido superior (Gauss-Jordan)
        for (int i = n - 1; i >= 0; i--) {
            double pivote = matriz[i][i];

            // Evitar divisiones por cero accidentales
            if (Math.abs(pivote) > 1e-11) {
                // Normalizar la fila actual para convertir el pivote en 1
                for (int j = 0; j <= n; j++) {
                    matriz[i][j] /= pivote;
                }
            }

            // Anular los coeficientes superiores en las filas anteriores
            for (int k = i - 1; k >= 0; k--) {
                double factor = matriz[k][i];
                for (int j = 0; j <= n; j++) {
                    matriz[k][j] -= factor * matriz[i][j];
                }
            }
        }
    }

    /**
     * Extrae las soluciones directamente de la última columna de la matriz identidad.
     */
    public static double[] obtenerSoluciones(double[][] matriz) {
        int n = matriz.length;
        double[] soluciones = new double[n];
        for (int i = 0; i < n; i++) {
            soluciones[i] = matriz[i][n];
        }
        return soluciones;
    }
}