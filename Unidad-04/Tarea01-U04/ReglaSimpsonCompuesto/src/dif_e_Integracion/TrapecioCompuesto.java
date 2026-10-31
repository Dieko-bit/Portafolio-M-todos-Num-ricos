package dif_e_Integracion;

public class TrapecioCompuesto {

    public static double calcularH(double a, double b, int n) {
        return (b - a) / n;
    }

    public static double funcion(double x) {
        // Funcion de prueba: f(x) = x^2 (puedes cambiarla según tu ejercicio)
        return x * x;
    }

    public static double calcularTrapecio(double a, double b, int n) {
        double h = calcularH(a, b, n);
        double suma = 0.5 * (funcion(a) + funcion(b));
        for (int k = 1; k < n; k++) {
            suma += funcion(a + k * h);
        }
        return h * suma;
    }

    public static double integrarConTolerancia(double a, double b, double tolerancia) {
        int n = 2;
        double integralAnterior = calcularTrapecio(a, b, n);
        double errorAbsoluto = 999.0;

        while (errorAbsoluto > tolerancia) {
            n *= 2;
            double integralNueva = calcularTrapecio(a, b, n);
            errorAbsoluto = Math.abs(integralNueva - integralAnterior);
            integralAnterior = integralNueva;
        }
        return integralAnterior;
    }

    // Metodo auxiliar para obtener el número exacto de subintervalos (n) requeridos
    public static int obtenerNfinal(double a, double b, double tolerancia) {
        int n = 2;
        double integralAnterior = calcularTrapecio(a, b, n);
        double errorAbsoluto = 999.0;

        while (errorAbsoluto > tolerancia) {
            n *= 2;
            double integralNueva = calcularTrapecio(a, b, n);
            errorAbsoluto = Math.abs(integralNueva - integralAnterior);
            integralAnterior = integralNueva;
        }
        return n;
    }
}