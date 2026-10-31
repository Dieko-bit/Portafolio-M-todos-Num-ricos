import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el número de incógnitas: ");
        int n = sc.nextInt();

        double[][] A = LectorDatos.leerMatriz(n, sc);
        double[] B = LectorDatos.leerVector(n, sc);

        double[] solucion = Gauss.resolver(A, B);

        LectorDatos.mostrarResultado(solucion);

        sc.close();
    }
}