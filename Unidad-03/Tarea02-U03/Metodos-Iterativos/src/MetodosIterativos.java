public class MetodosIterativos {

    /**
     * Método de Jacobi (utiliza un vector auxiliar para los nuevos valores).
     */
    public static void resolverJacobi(double[][] A, double[] b, double[] xInicial, double tolerancia, int maxIter) {
        int n = b.length;
        double[] xViejo = xInicial.clone();
        double[] xNuevo = new double[n];
        int iteracion = 0;
        boolean converge = false;

        System.out.println("\n=== MÉTODO DE JACOBI ===");

        while (iteracion < maxIter) {
            iteracion++;
            for (int i = 0; i < n; i++) {
                double suma = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        suma += A[i][j] * xViejo[j];
                    }
                }
                xNuevo[i] = (b[i] - suma) / A[i][i];
            }

            if (calcularErrorMaximo(xViejo, xNuevo) < tolerancia) {
                converge = true;
                break;
            }

            System.arraycopy(xNuevo, 0, xViejo, 0, n);
        }

        imprimirResultados("Jacobi", xNuevo, iteracion, converge);
    }

    /**
     * Método de Gauss-Seidel (emplea actualización inmediata de variables).
     */
    public static void resolverGaussSeidel(double[][] A, double[] b, double[] xInicial, double tolerancia, int maxIter) {
        int n = b.length;
        double[] x = xInicial.clone();
        int iteracion = 0;
        boolean converge = false;

        System.out.println("\n=== MÉTODO DE GAUSS-SEIDEL ===");

        while (iteracion < maxIter) {
            iteracion++;
            double[] xAnterior = x.clone();

            for (int i = 0; i < n; i++) {
                double suma = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        suma += A[i][j] * x[j];
                    }
                }
                x[i] = (b[i] - suma) / A[i][i];
            }

            if (calcularErrorMaximo(xAnterior, x) < tolerancia) {
                converge = true;
                break;
            }
        }

        imprimirResultados("Gauss-Seidel", x, iteracion, converge);
    }

    private static double calcularErrorMaximo(double[] xAnt, double[] xAct) {
        double max = 0.0;
        for (int i = 0; i < xAnt.length; i++) {
            double error = Math.abs(xAct[i] - xAnt[i]);
            if (error > max) {
                max = error;
            }
        }
        return max;
    }

    private static void imprimirResultados(String metodo, double[] sol, int iter, boolean conv) {
        if (conv) {
            System.out.println("¡El método de " + metodo + " convergió con éxito!");
        } else {
            System.out.println("Se alcanzó el límite máximo de iteraciones.");
        }
        System.out.println("Número exacto de iteraciones: " + iter);
        System.out.println("Soluciones obtenidas:");
        for (int i = 0; i < sol.length; i++) {
            System.out.printf("  x%d = %.6f\n", (i + 1), sol[i]);
        }
        System.out.println("--------------------------------------------------");
    }
}