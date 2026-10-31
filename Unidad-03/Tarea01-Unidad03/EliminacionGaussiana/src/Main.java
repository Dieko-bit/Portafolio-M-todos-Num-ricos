public class Main {
    public static void main(String[] args) {
        // 1. Leer la matriz por teclado usando el módulo Consola
        double[][] matriz = Consola.leerMatrizAumentada();

        System.out.println("\n=== MATRIZ ORIGINAL INGRESADA ===");
        imprimir(matriz);

        // 2. Ejecutar eliminación gaussiana (Triangulación superior)
        Gauss.eliminacionGaussiana(matriz);

        System.out.println("\n=== MATRIZ TRIANGULAR SUPERIOR ===");
        imprimir(matriz);

        // 3. Obtener soluciones mediante sustitución regresiva
        double[] soluciones = Gauss.sustitucionRegresiva(matriz);

        System.out.println("\n=== SOLUCIONES DEL SISTEMA ===");
        for (int i = 0; i < soluciones.length; i++) {
            System.out.printf("x%d = %.4f\n", (i + 1), soluciones[i]);
        }
    }

    public static void imprimir(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (j == m[i].length - 1) {
                    System.out.printf("| %8.4f", m[i][j]);
                } else {
                    System.out.printf("%8.4f ", m[i][j]);
                }
            }
            System.out.println();
        }
    }
}