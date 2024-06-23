package org.example.wave;

import org.example.enemies.*;
import org.example.map.Map;
import org.example.towers.Tower;

import java.util.*;

// Los enemigos llegan en oleadas que aumentan en dificultad a medida que avanza el
//juego. Cada oleada puede tener más enemigos o enemigos más fuertes.
public class Wave {
    private List<Enemy> enemies;// Variedad de enemigos que aparecen en la oleada
    private int waveNumber;// Cantidad de enemigos por oleada
    BasicEnemyFactory basicEnemyFactory;//fabrica de enemigos basicos
    BossEnemyFactory bossEnemyFactory;//fabrica de enemigos boss
    //constructor de la clase
    public Wave(int waveNumber, BasicEnemyFactory basicEnemyFactory, BossEnemyFactory bossEnemyFactory) {
        this.basicEnemyFactory = basicEnemyFactory;
        this.bossEnemyFactory = bossEnemyFactory;
        this.waveNumber = waveNumber;
    }
    //Metodo que genera enemigos segun la oleada, en la oleada 1 se generan 5 enemigos basicos
    private List<Enemy> generateEnemies(int waveNumber) {
        List<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < waveNumber * 5; i++) { // más enemigos cada oleada
            enemies.add(basicEnemyFactory.createEnemy());
        }
        if (waveNumber % 5 == 0) { // jefe cada 5 oleadas
            enemies.add(bossEnemyFactory.createEnemy());
        }
        return enemies;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
    // Métodos para manejar el progreso de la oleada
    public void moveEnemies(Enemy enemy, List<Tower> towers, Map map){
        //ponemos el enemigo en la casilla 4,0
        int x = 4;
        int y = 0;
        do {
            if (map.colocarEnemigo(x, y) && enemy.getHealth()>0){
                for (Tower tower : towers){//todas las torres atacan al enemigo si esta en su rango
                    tower.attack(enemy);
                }
                map.mostrarMapa();
                System.out.println("********************");
                if (x==1 && y==3){
                    map.removerEnemigo(x,y);
                }
            }else {
                break;
            }
            x--;
            y++;
        }while (true);
    }
    public void  spawnEnemies(){
        this.enemies = generateEnemies(waveNumber);
    }
}