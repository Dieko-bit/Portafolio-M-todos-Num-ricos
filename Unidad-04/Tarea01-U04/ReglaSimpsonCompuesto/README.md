# Práctica: Implementación de Simpson 1/3 Compuesto y Análisis Comparativo

**Asignatura:** Métodos Numéricos  
**Docente:** Mtro. Víctor Hugo Vásquez Herrera  
**Institución:** Instituto Tecnológico Superior de Xalapa (ITSX)  
**Carrera:** Ingeniería en Sistemas Computacionales  
**Paquete Java:** `dif_e_Integracion`  

---

## I. Descripción General

Este proyecto implementa y compara los métodos de integración numérica de **Trapecio Compuesto** y **Simpson 1/3 Compuesta** en Java. Ambos métodos utilizan una estrategia iterativa basada en duplicar el número de subintervalos ($n \to 2n$) hasta que la diferencia entre iteraciones consecutivas cumpla con la tolerancia de error ($\epsilon = 0.0001$) establecida por el docente.

El objetivo principal es verificar experimentalmente la superioridad en convergencia y precisión de las aproximaciones parabólicas (segundo orden) frente a las aproximaciones lineales (primer orden).

---

## II. Estructura del Código

El proyecto está organizado bajo el paquete `dif_e_Integracion` con las siguientes clases:

- **`TrapecioCompuesto.java`**: Define la función matemática $f(x) = x^2$, evalúa el tamaño del paso $h = \frac{b-a}{n}$ e implementa la regla del Trapecio Compuesto con tolerancia iterativa.
- **`SimpsonCompuesto.java`**: Implementa la Regla de Simpson 1/3 Compuesta aplicando el patrón de coeficientes alternados $(1, 4, 2, 4, \dots, 2, 4, 1)$ e imponiendo la restricción geométrica de paridad sobre $n$.
- **`Main.java`**: Clase orquestadora que ejecuta de forma secuencial ambos métodos bajo las mismas condiciones del intervalo $[0, 2]$ y tolerancia $\epsilon = 0.0001$.

---

## III. Instrucciones de Compilación y Ejecución

### Opción A: Desde la Terminal (CLI)

1. Ubícate en la carpeta raíz del proyecto (`src`):
   ```bash
   cd src
   ```

2. Compila todas las clases dentro del paquete:
   ```bash
   javac dif_e_Integracion/*.java
   ```

3. Ejecuta la clase principal `Main`:
   ```bash
   java dif_e_Integracion.Main
   ```

### Opción B: Desde IntelliJ IDEA

1. Abre el proyecto en IntelliJ IDEA.
2. Abre la clase `Main.java` dentro de `src/dif_e_Integracion/`.
3. Haz clic en el botón verde **Run / Play** (▶) o presiona `Shift + F10`.

---

## IV. Ejemplo de Salida por Consola

```text
==================================================
  ANÁLISIS COMPARATIVO: TRAPECIO VS SIMPSON 1/3
==================================================
Intervalo de integración: [0.0, 2.0]
Tolerancia objetivo: 0.0001
Función evaluada: f(x) = x^2

[MÉTODO DEL TRAPECIO COMPUESTO]
  - Valor de la integral: 2.66671753
  - Subintervalos requeridos (n): 128
--------------------------------------------------
[MÉTODO DE SIMPSON 1/3 COMPUESTO]
  - Valor de la integral: 2.66666667
  - Subintervalos requeridos (n): 4
==================================================
CONCLUSIÓN TÉCNICA:
Simpson 1/3 Compuesto alcanza la convergencia con un
número drásticamente menor de subintervalos (n) debido
a su aproximación mediante arcos de parábola de mayor orden.
```

---

## V. Respuestas al Análisis Conceptual

### 1. Paridad Estricta de Subintervalos ($n$ par en Simpson 1/3)
La regla básica de Simpson 1/3 aproxima la función integrable mediante tramos de parábolas (polinomios de segundo grado). Geométricamente, determinar una parábola requiere de **tres puntos consecutivos** (nodo inicial, nodo medio y nodo final), los cuales abarcan exactamente **dos subintervalos de ancho $h$**. Por lo tanto, cualquier regla compuesta de Simpson 1/3 se compone de una suma de arcos parabólicos donde cada uno consume un par de subintervalos. Si $n$ fuese impar, el último subintervalo quedaría "huérfano" al no contar con un par para construir la parábola.

### 2. Patrón Alternado de Coeficientes $(1, 4, 2, 4, \dots, 2, 4, 1)$
- **Trapecio Compuesto $(1, 2, 2, \dots, 2, 1)$:** Los puntos interiores $x_k$ son compartidos como extremo derecho de un trapecio y extremo izquierdo del adyacente. Al sumar áreas de polinomios de grado 1 (rectas), cada punto interno recibe un peso acumulado de $1 + 1 = 2$.
- **Simpson 1/3 Compuesto $(1, 4, 2, 4, \dots, 2, 4, 1)$:** Cada parábola abarca dos subintervalos. El nodo central/medio de la parábola (índice $k$ impar) pertenece únicamente a esa parábola y recibe el coeficiente numérico $4$ derivado de la integración del polinomio de Lagrange de grado 2. Los nodos donde se conectan dos parábolas consecutivas (índice $k$ par) son compartidos por ambas parabolas, sumando sus contribuciones para resultar en un coeficiente de $2$.