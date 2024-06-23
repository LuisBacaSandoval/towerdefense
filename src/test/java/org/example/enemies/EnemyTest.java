package org.example.enemies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
    private Enemy enemy;

    @BeforeEach
    public void setUp() {
        // Inicializa un enemigo con valores conocidos antes de cada prueba
        enemy = new Enemy(5, 100, 10);
    }

    @Test
    public void testConstructor() {
        assertEquals(5, enemy.getSpeed(),"La velocidad inicial debe ser 5");
        assertEquals(100, enemy.getHealth(), "La salud inicial debe ser 100");
        assertEquals(10, enemy.getReward(), "La recompensa inicial debe ser 10");
    }

    //Test para los getter y setter de la clase Enemy
    @Test
    public void testGetSpeed() {
        assertEquals(5, enemy.getSpeed());
    }

    @Test
    public void testSetSpeed() {
        enemy.setSpeed(10);
        assertEquals(10, enemy.getSpeed());
    }

    @Test
    public void testGetHealth() {
        assertEquals(100, enemy.getHealth());
    }

    @Test
    public void testSetHealth() {
        enemy.setHealth(50);
        assertEquals(50, enemy.getHealth());
    }

    @Test
    public void testGetReward() {
        assertEquals(10, enemy.getReward());
    }

    @Test
    public void testSetReward() {
        enemy.setReward(20);
        assertEquals(20, enemy.getReward());
    }
}