package org.example.towers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CannonTowerFactoryTest {
    @Test
    public void testCreateTowerNotNull() {
        CannonTowerFactory factory = new CannonTowerFactory();
        Tower tower = factory.createTower();
        assertNotNull(tower, "El metodo createTower debe devolver un objeto no nulo");
    }

    @Test
    public void testCreateBasicEnemy() {
        CannonTowerFactory factory = new CannonTowerFactory();
        Tower tower = factory.createTower();
        assertTrue(tower instanceof CannonTower, "El metodo createTower debe devolver una torre CannonTower");
    }
}