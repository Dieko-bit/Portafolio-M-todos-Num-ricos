# Práctica: Método de Gauss-Jordan
**Asignatura:** Métodos Numéricos  
**Docente:** Mtro. Víctor Hugo Vásquez Herrera  
**Institución:** Instituto Tecnológico Superior de Xalapa (ITSX)  
**Carrera:** Ingeniería en Sistemas Computacionales  

---

## I. Descripción General

Este proyecto implementa el método numérico de **Gauss-Jordan** en Java para la resolución de sistemas de ecuaciones lineales. La implementación hace uso explícito del **principio de reutilización de software** y **programación modular**, invocando la fase de eliminación hacia adelante (triangulación superior) construida previamente en el módulo `Gauss.eliminacionGaussiana` (importado mediante la librería `EliminacionGaussiana.jar`).

Posteriormente, el algoritmo normaliza los pivotes de la diagonal principal a 1 y ejecuta el barrido de coeficientes superiores hasta transformar la matriz aumentada en una matriz identidad, permitiendo la lectura directa del vector de soluciones sin requerir la fase de sustitución regresiva.

---

## II. Estructura Modular del Proyecto

La solución se dividió en componentes independientes de acuerdo con las buenas prácticas de diseño:

- **`EliminacionGaussiana.jar` (Módulo Externo Reutilizado):**  
  Contiene la clase `Gauss` y su método `eliminacionGaussiana(double[][] matriz)`, encargado de la pivoteación parcial y la transformación de la matriz aumentada a su forma triangular superior.
- **`GaussJordan.java`:**  
  Clase modular que reutiliza la triangulación superior del paquete `Gauss`, realiza la normalización de renglones y ejecuta la eliminación hacia atrás para anular los coeficientes superiores. Además, incluye la extracción directa de soluciones.
- **`Consola.java`:**  
  Módulo encargado exclusivamente del manejo de entradas e interacción con el usuario mediante la consola (lectura dinámica de datos).
- **`Main.java`:**  
  Clase principal que coordina el flujo de datos: orquesta la captura de la matriz, invoca la resolución matemática por Gauss-Jordan e imprime los estados de la matriz y el vector resultado.

---

## III. Instrucciones de Compilación y Ejecución

### Desde Terminal / Consola de Comandos (CLI):

1. **Compilar las clases asociando la librería JAR externa:**
   ```bash
   javac -cp "lib/EliminacionGaussiana.jar;." src/*.java -d bin
   ```

2. **Ejecutar el programa:**
   ```bash
   java -cp "lib/EliminacionGaussiana.jar;bin" Main
   ```

*(Nota: En sistemas operativos basados en Linux/macOS, sustituya el punto y coma `;` por dos puntos `:` en el classpath).*

### Desde IntelliJ IDEA:

1. Abrir el proyecto en IntelliJ IDEA.
2. Asegurarse de que el archivo `EliminacionGaussiana.jar` ubicado en la carpeta `lib` esté agregado como librería (`Right-click en lib > Add as Library...`).
3. Ejecutar la clase `Main.java` haciendo clic en el botón **Run / Play** (▶️).

---

## IV. Ejemplo de Prueba y Ejemplo de Ejecución (Consola)

### Sistema de Ecuaciones de Prueba ($3 \times 3$):

$$2x_1 + x_2 - x_3 = 8$$
$$-3x_1 - x_2 + 2x_3 = -11$$
$$-2x_1 + x_2 + 2x_3 = -3$$

### Salida Obtenida en Consola (Texto Plano):

```text
=== MÉTODO DE GAUSS-JORDAN (ITSX) ===
Ingrese el número de incógnitas (n): 3

Ingrese los coeficientes de la matriz aumentada:
--- Ecuación 1 ---
  Coeficiente x1: 2
  Coeficiente x2: 1
  Coeficiente x3: -1
  Término independiente (b_1): 8
--- Ecuación 2 ---
  Coeficiente x1: -3
  Coeficiente x2: -1
  Coeficiente x3: 2
  Término independiente (b_2): -11
--- Ecuación 3 ---
  Coeficiente x1: -2
  Coeficiente x2: 1
  Coeficiente x3: 2
  Término independiente (b_3): -3

=== MATRIZ ORIGINAL AUMENTADA ===
  2.0000   1.0000  -1.0000 |   8.0000
 -3.0000  -1.0000   2.0000 | -11.0000
 -2.0000   1.0000   2.0000 |  -3.0000

=== MATRIZ REDUCIDA (MATRIZ IDENTIDAD) ===
  1.0000   0.0000   0.0000 |   2.0000
  0.0000   1.0000   0.0000 |   3.0000
  0.0000   0.0000   1.0000 |  -1.0000

=== VECTOR DE SOLUCIONES (LECTURA DIRECTA) ===
x1 = 2.0000
x2 = 3.0000
x3 = -1.0000
```