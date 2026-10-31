# Actividad 03 - Método de Gauss

## Alumno
Diego Esteban Aguilar García

## Materia
Métodos Numéricos

## Descripción
Programa desarrollado en Java para resolver sistemas de ecuaciones lineales mediante el método de eliminación de Gauss utilizando una arquitectura modular.

## Estructura del proyecto

- Main.java
- Gauss.java
- LectorDatos.java

## Ejecución

1. Ejecutar la clase `Main`.
2. Ingresar el número de incógnitas.
3. Capturar los coeficientes de la matriz uno por uno cuando el programa los solicite.
4. Capturar los términos independientes del vector.
5. El programa mostrará la solución del sistema.

## Forma de ingresar los datos

Para el siguiente sistema:

2x + y - z = 8

-3x - y + 2z = -11

-2x + y + 2z = -3

La matriz de coeficientes es:

| 2  | 1  | -1 |
|----|----|----|
| -3 | -1 | 2  |
| -2 | 1  | 2  |

Y el vector de términos independientes es:

| 8 |
|---|
| -11 |
| -3 |

Al ejecutar el programa se deberá capturar cada valor individualmente:

```text
Ingrese el número de incógnitas: 3

A[0][0] = 2
A[0][1] = 1
A[0][2] = -1

A[1][0] = -3
A[1][1] = -1
A[1][2] = 2

A[2][0] = -2
A[2][1] = 1
A[2][2] = 2

B[0] = 8
B[1] = -11
B[2] = -3
