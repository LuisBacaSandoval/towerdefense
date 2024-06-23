package org.example;

import org.example.enemies.BasicEnemyFactory;
import org.example.enemies.BossEnemyFactory;
import org.example.enemies.Enemy;
import org.example.map.Map;
import org.example.player.Player;
import org.example.towers.*;
import org.example.towers.TowerFactory;
import org.example.wave.Wave;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//Flujo del juego
//Se inicializa el mapa, el jugador y la primera oleada de enemigos.
//El jugador coloca torres en el mapa.
//El jugador inicia una oleada y los enemigos comienzan a moverse hacia la base.
//Las torres atacan a los enemigos dentro de su alcance
//Se actualiza el estado del juego: se verifican las vidas de los enemigos, se calcula la puntuación y la salud de la base
//Al finalizar una oleada, el jugador puede colocar nuevas torres o mejorar las existentes antes de iniciar la siguiente oleada
//El juego termina si la salud de la base llega a cero.
public class TowerDefenseGame {
    private Map map;
    private Player player;
    private Wave wave;
    private List<Tower> towers;

    private static final java.util.Map<String, TowerFactory> towerTypeMap;
    static {
        towerTypeMap = new HashMap<>();
        towerTypeMap.put("cannon", new CannonTowerFactory());
        towerTypeMap.put("arrow", new ArrowTowerFactory());
        towerTypeMap.put("laser", new LaserTowerFactory());
    }
    private TowerFactory towerType(String type) {
        return towerTypeMap.getOrDefault(type.toLowerCase(), null);
    }
    public TowerDefenseGame() {
        this.map = new Map();
        this.player = new Player();
        this.towers = new ArrayList<>();
    }
    //Metodos getters
    public Map getMap() {
        return map;
    }
    public Player getPlayer() {
        return player;
    }
    public Wave getWave() {
        return wave;
    }
    //Metodo para poner una torre en la posicion (x,y)
    public void placeTower(TowerFactory towerType, int x, int y) {
        if (map.isValidPosition(x, y)){
            towers.add(towerType.createTower());
            map.placeTower(x, y);
        }
    }
    //Metodo para comenzar la oleada de enemigos
    private void startWave() {
        BasicEnemyFactory basicEnemyFactory = new BasicEnemyFactory();
        BossEnemyFactory bossEnemyFactory = new BossEnemyFactory();
        wave = new Wave(1, basicEnemyFactory, bossEnemyFactory);
        wave.spawnEnemies();
        int i = 1;
        for (Enemy enemy : wave.getEnemies()){
            System.out.println("Enemigo " + i);
            wave.moveEnemies(enemy, towers, map);
            i++;
            System.out.println("********************");
        }
    }

    public static void main(String[] args) {
        TowerDefenseGame towerDefenseGame = new TowerDefenseGame();
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("Ingresa un comando ('PLACE_TOWER TipoTorre x y' o 'START_WAVE'): ");
            input = scanner.nextLine();

            if ("START_WAVE".equalsIgnoreCase(input)) {
                break; // Rompe el bucle para iniciar la oleada
            } else if (input.toUpperCase().startsWith("PLACE_TOWER")) {
                String[] parts = input.split(" ");
                if (parts.length == 4) {
                    String towerType = parts[1];
                    int x = Integer.parseInt(parts[2]);
                    int y = Integer.parseInt(parts[3]);
                    // Llamamos al metodo para colocar la torre en la posicion (x,y)
                    towerDefenseGame.placeTower(towerDefenseGame.towerType(towerType), x, y);
                    System.out.println("Torre " + towerType + " colocada en (" + x + ", " + y + ")");
                } else {
                    System.out.println("Formato de comando incorrecto. Usa: 'PLACE_TOWER TipoTorre x y'");
                }
            } else {
                System.out.println("Comando no reconocido.");
            }
        }

        // Inicia la oleada
        System.out.println("Iniciando oleada...");
        towerDefenseGame.startWave();
        System.out.println("Tower");
    }
}