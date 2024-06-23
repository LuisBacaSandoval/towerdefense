package org.example.wave;

import org.example.enemies.BasicEnemyFactory;
import org.example.enemies.BossEnemyFactory;
import org.example.enemies.Enemy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WaveTest {
    private Wave wave;
    private BasicEnemyFactory basicEnemyFactory;
    private BossEnemyFactory bossEnemyFactory;

    @Test
    public void testGenerateEnemies_BasicEnemiesCount() {
        basicEnemyFactory = new BasicEnemyFactory();
        bossEnemyFactory = new BossEnemyFactory();
        wave = new Wave(1, basicEnemyFactory, bossEnemyFactory); // Inicializar con la oleada 1
        wave.spawnEnemies();
        List<Enemy> enemies = wave.getEnemies();
        // Verificar que se generan 5 enemigos para la oleada 1
        assertEquals(5, enemies.size());
    }

    @Test
    public void testGenerateEnemies_BossEveryFiveWaves() {
        basicEnemyFactory = new BasicEnemyFactory();
        bossEnemyFactory = new BossEnemyFactory();
        wave = new Wave(5, basicEnemyFactory, bossEnemyFactory); // Inicializar con la oleada 5
        wave.spawnEnemies();
        List<Enemy> enemies = wave.getEnemies();
        // Verificar que se generan 25 enemigos básicos + 1 jefe para la oleada 5
        assertEquals(26, enemies.size());
    }
}