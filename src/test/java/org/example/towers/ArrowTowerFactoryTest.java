package org.example.towers;

import org.example.enemies.BasicEnemy;
import org.example.enemies.BasicEnemyFactory;
import org.example.enemies.Enemy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrowTowerFactoryTest {
    @Test
    public void testCreateTowerNotNull() {
        ArrowTowerFactory factory = new ArrowTowerFactory();
        Tower tower = factory.createTower();
        assertNotNull(tower, "El metodo createTower debe devolver un objeto no nulo");
    }

    @Test
    public void testCreateBasicEnemy() {
        ArrowTowerFactory factory = new ArrowTowerFactory();
        Tower tower = factory.createTower();
        assertTrue(tower instanceof ArrowTower, "El metodo createTower debe devolver una torre ArrowTower");
    }
}