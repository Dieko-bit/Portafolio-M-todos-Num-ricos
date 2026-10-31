import java.util.Scanner;

public class LectorDatos {

    public static double[][] leerMatriz(int n, Scanner sc) {
        double[][] matriz = new double[n][n];

        System.out.println("Ingrese los coeficientes de la matriz:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                matriz[i][j] = sc.nextDouble();
            }
        }

        return matriz;
    }

    public static double[] leerVector(int n, Scanner sc) {
        double[] vector = new double[n];

        System.out.println("Ingrese los términos independientes:");

        for (int i = 0; i < n; i++) {
            System.out.print("B[" + i + "] = ");
            vector[i] = sc.nextDouble();
        }

        return vector;
    }

    public static void mostrarResultado(double[] X) {
        System.out.println("\nResultados:");

        for (int i = 0; i < X.length; i++) {
            System.out.printf("x%d = %.4f%n", i + 1, X[i]);
        }
    }
}