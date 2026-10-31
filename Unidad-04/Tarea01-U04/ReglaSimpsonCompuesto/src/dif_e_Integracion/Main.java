package dif_e_Integracion;

public class Main {
    public static void main(String[] args) {
        double a = 0.0;          // Límite inferior
        double b = 2.0;          // Límite superior
        double tolerancia = 0.0001; // Tolerancia establecida

        System.out.println("==================================================");
        System.out.println("  ANÁLISIS COMPARATIVO: TRAPECIO VS SIMPSON 1/3");
        System.out.println("==================================================");
        System.out.printf("Intervalo de integración: [%.1f, %.1f]\n", a, b);
        System.out.println("Tolerancia objetivo: " + tolerancia);
        System.out.println("Función evaluada: f(x) = x^2\n");

        // --- 1. Ejecución del Método del Trapecio Compuesto ---
        double resultadoTrapecio = TrapecioCompuesto.integrarConTolerancia(a, b, tolerancia);
        int nTrapecio = TrapecioCompuesto.obtenerNfinal(a, b, tolerancia);

        System.out.println("[MÉTODO DEL TRAPECIO COMPUESTO]");
        System.out.printf("  - Valor de la integral: %.8f\n", resultadoTrapecio);
        System.out.println("  - Subintervalos requeridos (n): " + nTrapecio);
        System.out.println("--------------------------------------------------");

        // --- 2. Ejecución del Método de Simpson 1/3 Compuesto ---
        double resultadoSimpson = SimpsonCompuesto.integrarConTolerancia(a, b, tolerancia);

        int nSimpson = 2;
        double integAnt = SimpsonCompuesto.calcularSimpson(a, b, nSimpson);
        double err = 999.0;
        while (err > tolerancia) {
            nSimpson *= 2;
            double integNue = SimpsonCompuesto.calcularSimpson(a, b, nSimpson);
            err = Math.abs(integNue - integAnt);
            integAnt = integNue;
        }

        System.out.println("[MÉTODO DE SIMPSON 1/3 COMPUESTO]");
        System.out.printf("  - Valor de la integral: %.8f\n", resultadoSimpson);
        System.out.println("  - Subintervalos requeridos (n): " + nSimpson);
        System.out.println("==================================================");
        System.out.println("CONCLUSIÓN TÉCNICA:");
        System.out.println("Simpson 1/3 Compuesto alcanza la convergencia con un");
        System.out.println("número drásticamente menor de subintervalos (n) debido");
        System.out.println("a su aproximación mediante arcos de parábola de mayor orden.");
    }
}