import java.util.Scanner;

public class Consola {
    private static final Scanner scanner = new Scanner(System.in);

    public static double[][] leerMatrizAumentada() {
        System.out.println("=== MÉTODO DE GAUSS-JORDAN (ITSX) ===");
        System.out.print("Ingrese el número de incógnitas (n): ");
        int n = scanner.nextInt();

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