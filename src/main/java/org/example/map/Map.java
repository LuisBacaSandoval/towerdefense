package org.example.map;

// El mapa es el escenario donde se desarrolla el juego.
// Está representado por una matriz que define los caminos por los
// que se moverán los enemigos y las posiciones donde se pueden colocar las torres.
// Una celda vacia('') representa un espacio disponible para colocar una torre
// Una celda de camino('C') representa el camino por el que los enemigos se desplazan
// La base ('B') representa el objetivo que los enemigos deben alcanzar
// Nota:  El mapa se inicializa con un diseño predefinido que incluye caminos y posiciones
// disponibles para las torres. El diseño del mapa no cambia durante el juego. Y tiene un tamaño de 5x5

public class Map {
    private final char[][] mapa;

    public Map() {
        // Inicializa el mapa con un diseño predefinido de 5x5
        mapa = new char[][]{
            {' ', ' ', ' ', ' ', 'B'},
            {' ', ' ', ' ', 'C', ' '},
            {' ', ' ', 'C', ' ', ' '},
            {' ', 'C', ' ', ' ', ' '},
            {'C', ' ', ' ', ' ', ' '}
        };
    }

    // Método para mostrar el mapa
    public void mostrarMapa() {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                System.out.print("[" + mapa[i][j] + "]");
            }
            System.out.println();
        }
    }
    // Método para colocar una torre en una posición específica
    public boolean placeTower(int fila, int columna) {
        if (fila >= 0 && fila < mapa.length && columna >= 0 && columna < mapa.length) {
            if (isValidPosition(fila, columna)) {
                mapa[fila][columna] = 'T'; // 'T' representa una torre
                return true;
            }
        }
        return false;
    }
    // Método para colocar un enemigo en una posición específica
    public boolean colocarEnemigo(int fila, int columna){
        if (esCamino(fila, columna)){
            mapa[fila][columna] = 'E';
            if (fila+1 >= 0 && fila+1 < mapa.length && columna-1 >= 0 && columna-1 < mapa.length){
                mapa[fila+1][columna-1] = 'C';
            }
            return true;
        }
        return false;
    }
    // Método para verificar si una posición es camino
    public boolean esCamino(int fila, int columna) {
        return fila >= 0 && fila < mapa.length && columna >= 0 && columna < mapa.length && mapa[fila][columna] == 'C';
    }
    // Método para remover una torre de una posición específica
    public boolean removerTorre(int fila, int columna) {
        if (fila >= 0 && fila < mapa.length && columna >= 0 && columna < mapa.length && mapa[fila][columna] == 'T') {
            mapa[fila][columna] = ' ';
            return true;
        }
        return false;
    }
    // Método para remover un enemigo de una posición específica
    public boolean removerEnemigo(int fila, int columna) {
        if (fila >= 0 && fila < mapa.length && columna >= 0 && columna < mapa.length && mapa[fila][columna] == 'E') {
            mapa[fila][columna] = 'C';
            return true;
        }
        return false;
    }
    // Método para verificar si una posición es válida para colocar una torre
    public boolean isValidPosition(int x, int y) {
        // Verifica si la posición está dentro de los límites del mapa
        if (x >= 0 && x < mapa.length && y >= 0 && y < mapa.length) {
            // Verifica si la posición está vacía
            return mapa[x][y] == ' ';
        }
        return false;
    }
}
