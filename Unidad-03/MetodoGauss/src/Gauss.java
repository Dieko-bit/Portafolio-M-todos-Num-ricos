public class Gauss {

        int n = B.length;

        // Eliminación hacia adelante
        for (int k = 0; k < n - 1; k++) {

            // Verifica pivote
            if (A[k][k] == 0) {
                throw new ArithmeticException("División entre cero. Pivote nulo.");
            }

            for (int i = k + 1; i < n; i++) {
                double factor = A[i][k] / A[k][k];

                for (int j = k; j < n; j++) {
                    A[i][j] = A[i][j] - factor * A[k][j];
                }

                B[i] = B[i] - factor * B[k];
            }
        }

        // Sustitución hacia atrás
        double[] X = new double[n];

        for (int i = n - 1; i >= 0; i--) {
            double suma = 0;

            for (int j = i + 1; j < n; j++) {
                suma += A[i][j] * X[j];
            }

            X[i] = (B[i] - suma) / A[i][i];
        }

        return X;
    }
}