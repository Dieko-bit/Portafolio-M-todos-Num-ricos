public class Main {
    public static void main(String[] args) {
        // 1. Lectura de datos por teclado (Módulo Consola)
        DatosSistema datos = Consola.leerDatosSistema();

        // 2. Ejecución del Método de Jacobi
        MetodosIterativos.resolverJacobi(datos.A, datos.b, datos.xInicial, datos.tolerancia, datos.maxIter);

        // 3. Ejecución del Método de Gauss-Seidel
        MetodosIterativos.resolverGaussSeidel(datos.A, datos.b, datos.xInicial, datos.tolerancia, datos.maxIter);
    }
}