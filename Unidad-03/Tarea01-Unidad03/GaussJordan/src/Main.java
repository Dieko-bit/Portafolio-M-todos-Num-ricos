public class Main {
    public static void main(String[] args) {
        // 1. Lectura de datos por teclado una sola vez
        double[][] matriz = Consola.leerMatrizAumentada();

        System.out.println("\n=== MATRIZ ORIGINAL AUMENTADA ===");
        imprimirMatriz(matriz);

        // 2. Aplicar el método de Gauss-Jordan (que internamente reutiliza Gauss)
        GaussJordan.resolver(matriz);

        System.out.println("\n=== MATRIZ REDUCIDA (MATRIZ IDENTIDAD) ===");
        imprimirMatriz(matriz);

        // 3. Obtener el vector de soluciones de forma directa
        double[] soluciones = GaussJordan.obtenerSoluciones(matriz);

        System.out.println("\n=== VECTOR DE SOLUCIONES (LECTURA DIRECTA) ===");
        for (int i = 0; i < soluciones.length; i++) {
            System.out.printf("x%d = %.4f\n", (i + 1), soluciones[i]);
        }
    }

    public static void imprimirMatriz(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (j == matriz[i].length - 1) {
                    System.out.printf("| %8.4f", matriz[i][j]);
                } else {
                    System.out.printf("%8.4f ", matriz[i][j]);
                }
            }
            System.out.println();
        }
    }
}