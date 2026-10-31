package dif_e_Integracion;

public class SimpsonCompuesto {

    public static double calcularSimpson(double a, double b, int n) {
        // Asegurar que n sea par (requisito geométrico de Simpson 1/3)
        if (n % 2 != 0) {
            n++;
        }

        double h = TrapecioCompuesto.calcularH(a, b, n);
        double sumaImpares = 0.0;
        double sumaPares = 0.0;

        for (int k = 1; k < n; k++) {
            double xk = a + k * h;

            // TODO resuelto: Condición y acumulación según Simpson 1/3
            if (k % 2 != 0) {
                sumaImpares += TrapecioCompuesto.funcion(xk); // Coeficiente 4
            } else {
                sumaPares += TrapecioCompuesto.funcion(xk);   // Coeficiente 2
            }
        }

        double sumaTotal = TrapecioCompuesto.funcion(a)
                + 4.0 * sumaImpares
                + 2.0 * sumaPares
                + TrapecioCompuesto.funcion(b);

        return (h / 3.0) * sumaTotal;
    }

    public static double integrarConTolerancia(double a, double b, double tolerancia) {
        int n = 2; // Debe iniciar en un número par
        double integralAnterior = calcularSimpson(a, b, n);
        double errorAbsoluto = 999.0;

        while (errorAbsoluto > tolerancia) {
            n *= 2; // Duplicar subintervalos manteniendo la paridad
            double integralNueva = calcularSimpson(a, b, n);
            errorAbsoluto = Math.abs(integralNueva - integralAnterior);
            integralAnterior = integralNueva;
        }
        return integralAnterior;
    }
}