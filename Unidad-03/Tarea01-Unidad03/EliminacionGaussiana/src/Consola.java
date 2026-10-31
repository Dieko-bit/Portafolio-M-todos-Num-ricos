import java.util.Scanner;

/**
 * Clase Consola
 * Se encarga de la interacción con el usuario mediante la entrada por teclado.
 */
public class Consola {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Solicita al usuario el tamaño y los coeficientes de la matriz aumentada.
     *
     * @return Una matriz aumentada [n][n+1] con los valores ingresados por el usuario.
     */
    public static double[][] leerMatrizAumentada() {
        System.out.println("=== CONFIGURACIÓN DEL SISTEMA DE ECUACIONES ===");
        System.out.print("Ingrese el número de incógnitas (n): ");
        int n = scanner.nextInt();

        // La matriz aumentada tiene n filas y n + 1 columnas (incluyendo términos independientes)
        double[][] matriz = new double[n][n + 1];

        System.out.println("\nIngrese los coeficientes de la matriz aumentada:");
        for (int i = 0; i < n; i++) {
            System.out.println("--- Ecuación " + (i + 1) + " ---");
            for (int j = 0; j <= n; j++) {
                if (j < n) {
                    System.out.print("  Coeficiente x" + (j + 1) + ": ");
                } else {
                    System.out.print("  Término independiente (b_" + (i + 1) + "): ");
                }
                matriz[i][j] = scanner.nextDouble();
            }
        }
        return matriz;
    }
}