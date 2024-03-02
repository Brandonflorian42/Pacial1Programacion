package edu.umg;

public class PosicionesAdyacentes {

    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int fila = 1, columna = 1;

        int[][] adyacentes = obtenerPosicionesAdyacentes(matriz, fila, columna);

        System.out.println("Posición dada: (" + fila + ", " + columna + ")");
        System.out.println("Posiciones adyacentes:");
        for (int[] posicion : adyacentes) {
            System.out.println("(" + posicion[0] + ", " + posicion[1] + ")");
        }
    }

    public static int[][] obtenerPosicionesAdyacentes(int[][] matriz, int fila, int columna) {
        int[][] adyacentes = {{fila - 1, columna}, {fila + 1, columna}, {fila, columna - 1}, {fila, columna + 1}};
        int cantidadAdyacentes = 0;

        for (int[] pos : adyacentes) {
            if (esPosicionValida(matriz, pos[0], pos[1])) {
                cantidadAdyacentes++;
            }
        }

        int[][] posicionesValidas = new int[cantidadAdyacentes][2];
        int indice = 0;

        for (int[] pos : adyacentes) {
            if (esPosicionValida(matriz, pos[0], pos[1])) {
                posicionesValidas[indice++] = pos;
            }
        }

        return posicionesValidas;
    }

    public static boolean esPosicionValida(int[][] matriz, int fila, int columna) {
        return fila >= 0 && fila < matriz.length && columna >= 0 && columna < matriz[0].length;
    }
}
