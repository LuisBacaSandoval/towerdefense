package org.example.towers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LaserTowerFactoryTest {
    @Test
    public void testCreateTowerNotNull() {
        LaserTowerFactory factory = new LaserTowerFactory();
        Tower tower = factory.createTower();
        assertNotNull(tower, "El metodo createTower debe devolver un objeto no nulo");
    }

    @Test
    public void testCreateBasicEnemy() {
        LaserTowerFactory factory = new LaserTowerFactory();
        Tower tower = factory.createTower();
        assertTrue(tower instanceof LaserTower, "El metodo createTower debe devolver una torre LaserTower");
    }
}