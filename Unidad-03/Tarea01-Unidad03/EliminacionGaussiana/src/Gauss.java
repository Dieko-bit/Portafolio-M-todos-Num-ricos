public class Gauss {

    /**
     * Aplica la triangulación superior sobre una matriz aumentada.
     * Modifica la matriz directamente mediante paso de referencia en memoria RAM.
     *
     * @param matriz Matriz aumentada [n][n+1]
     */
    public static void eliminacionGaussiana(double[][] matriz) {
        int n = matriz.length;

        for (int i = 0; i < n; i++) {
            // Pivoteo parcial para mayor estabilidad numérica
            int maxFila = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(matriz[k][i]) > Math.abs(matriz[maxFila][i])) {
                    maxFila = k;
                }
            }

            // Intercambiar filas
            double[] temp = matriz[i];
            matriz[i] = matriz[maxFila];
            matriz[maxFila] = temp;

            // Verificar si el pivote es cercano a cero
            if (Math.abs(matriz[i][i]) < 1e-11) {
                continue;
            }

            // Triangulación superior (hacer ceros debajo del pivote)
            for (int k = i + 1; k < n; k++) {
                double factor = matriz[k][i] / matriz[i][i];
                for (int j = i; j <= n; j++) {
                    matriz[k][j] -= factor * matriz[i][j];
                }
            }
        }
    }

    /**
     * Método opcional de sustitución regresiva por si deseas probar
     * esta práctica de forma individual antes de pasar a Gauss-Jordan.
     */
    public static double[] sustitucionRegresiva(double[][] matriz) {
        int n = matriz.length;
        double[] x = new double[n];

        for (int i = n - 1; i >= 0; i--) {
            double suma = 0;
            for (int j = i + 1; j < n; j++) {
                suma += matriz[i][j] * x[j];
            }
            x[i] = (matriz[i][n] - suma) / matriz[i][i];
        }
        return x;
    }
}