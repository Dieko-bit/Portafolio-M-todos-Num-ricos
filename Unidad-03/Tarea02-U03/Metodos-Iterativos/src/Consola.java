import java.util.Scanner;

public class Consola {
    private static final Scanner scanner = new Scanner(System.in);

    public static DatosSistema leerDatosSistema() {
        System.out.println("=== CONFIGURACIÓN DE MÉTODOS ITERATIVOS (ITSX) ===");
        System.out.print("Ingrese el número de incógnitas (n): ");
        int n = scanner.nextInt();

        double[][] A = new double[n][n];
        double[] b = new double[n];
        double[] xInicial = new double[n];

        System.out.println("\n--- Ingrese los coeficientes de la matriz A ---");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("  A[" + (i + 1) + "][" + (j + 1) + "]: ");
                A[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("\n--- Ingrese los términos independientes (vector b) ---");
        for (int i = 0; i < n; i++) {
            System.out.print("  b[" + (i + 1) + "]: ");
            b[i] = scanner.nextDouble();
        }

        System.out.println("\n--- Ingrese la aproximación inicial X^(0) ---");
        for (int i = 0; i < n; i++) {
            System.out.print("  x" + (i + 1) + "(0): ");
            xInicial[i] = scanner.nextDouble();
        }

        System.out.print("\nIngrese la tolerancia de error (ej. 0.0001): ");
        double tolerancia = scanner.nextDouble();

        System.out.print("Ingrese el número máximo de iteraciones: ");
        int maxIter = scanner.nextInt();

        return new DatosSistema(A, b, xInicial, tolerancia, maxIter);
    }
}

/**
 * Clase auxiliar para empaquetar los datos leídos del sistema.
 */
class DatosSistema {
    double[][] A;
    double[] b;
    double[] xInicial;
    double tolerancia;
    int maxIter;

    public DatosSistema(double[][] A, double[] b, double[] xInicial, double tolerancia, int maxIter) {
        this.A = A;
        this.b = b;
        this.xInicial = xInicial;
        this.tolerancia = tolerancia;
        this.maxIter = maxIter;
    }
}