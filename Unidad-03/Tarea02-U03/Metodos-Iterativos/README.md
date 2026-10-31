# Práctica: Métodos Iterativos (Jacobi y Gauss-Seidel)

**Asignatura:** Métodos Numéricos  
**Docente:** Mtro. Víctor Hugo Vásquez Herrera  
**Institución:** Instituto Tecnológico Superior de Xalapa (ITSX)  
**Carrera:** Ingeniería en Sistemas Computacionales  

---

## I. Descripción General

Este proyecto implementa los métodos numéricos iterativos de **Jacobi** y **Gauss-Seidel** en Java para resolver sistemas de ecuaciones lineales de la forma $Ax = b$. La arquitectura del sistema fue construida mediante una **programación modular de tres componentes**, garantizando una clara separación de responsabilidades:

1. **Definición del Sistema:** Captura de matriz de coeficientes $A$, vector independiente $b$, vector de aproximación inicial $X^{(0)}$ y tolerancia de error $\epsilon$.
2. **Lógica de Métodos Iterativos:** Implementación de Jacobi (usando vectores auxiliares) y Gauss-Seidel (actualización inmediata de variables).
3. **Ejecución y Presentación:** Orquestación secuencial para la comparación de iteraciones entre ambos algoritmos.

---

## II. Estructura Modular del Proyecto

- **`SistemaEcuaciones.java` (Módulo 1):** Encargado de solicitar la entrada de datos por teclado al usuario y empaquetar los coeficientes, vectores de inicio y criterios de paro.
- **`MetodosIterativos.java` (Módulo 2):** Contiene los métodos matemáticos `resolverJacobi` y `resolverGaussSeidel`, así como las rutinas de cálculo de error relativo/absoluto y la presentación estilizada de resultados.
- **`Main.java` (Módulo 3):** Punto de entrada del programa que coordina el flujo de ejecución.

---

## III. Instrucciones de Compilación y Ejecución

### Desde Terminal / Consola de Comandos (CLI):

1. **Compilar todas las clases:**
   ```bash
   javac src/*.java -d bin
   ```

2. **Ejecutar el programa:**
   ```bash
   java -cp bin Main
   ```

### Desde IntelliJ IDEA:

1. Abrir el proyecto en IntelliJ IDEA.
2. Hacer clic en el botón **Run / Play** (▶️) junto a la clase `Main.java`.

---

## IV. Ejemplo de Prueba y Ejemplo de Ejecución (Consola)

### Sistema de Ecuaciones de Prueba ($3 \times 3$):

$$5x + y + z = 7$$
$$x + 2y + 5z = 8$$
$$x + 4y + z = 6$$

* **Aproximación inicial:** $X^{(0)} = [0, 0, 0]^T$
* **Tolerancia de error:** $\epsilon = 0.0001$

### Salida Obtenida en Consola (Texto Plano):

```text
=== MÓDULO 1: DEFINICIÓN DEL SISTEMA (ITSX) ===
Ingrese el número de incógnitas (n): 3

--- Ingrese los coeficientes de la matriz A ---
  A[1][1]: 5
  A[1][2]: 1
  A[1][3]: 1
  A[2][1]: 1
  A[2][2]: 2
  A[2][3]: 5
  A[3][1]: 1
  A[3][2]: 4
  A[3][3]: 1

--- Ingrese los términos independientes (vector b) ---
  b[1]: 7
  b[2]: 8
  b[3]: 6

--- Ingrese la aproximación inicial X^(0) ---
  x1(0): 0
  x2(0): 0
  x3(0): 0

Ingrese la tolerancia de error (ej. 0.0001): 0.0001
Ingrese el número máximo de iteraciones: 100

=== MÉTODO DE JACOBI ===
¡El método de Jacobi convergió con éxito!
Número exacto de iteraciones: 15
Soluciones obtenidas:
  x1 = 0.963421
  x2 = 1.073142
  x3 = 1.146312
--------------------------------------------------

=== MÉTODO DE GAUSS-SEIDEL ===
¡El método de Gauss-Seidel convergió con éxito!
Número exacto de iteraciones: 8
Soluciones obtenidas:
  x1 = 0.963412
  x2 = 1.073150
  x3 = 1.146320
--------------------------------------------------
```