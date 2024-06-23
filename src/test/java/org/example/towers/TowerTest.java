package org.example.towers;

import org.example.enemies.BasicEnemy;
import org.example.enemies.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TowerTest {
    private Tower tower;

    @BeforeEach
    public void setUp() {
        // Inicializa una torre con valores conocidos antes de cada prueba
        tower = new Tower(10, 5, 2);
    }

    @Test
    public void testConstructor() {
        assertEquals(10, tower.getDamage(), "El daño inicial debe ser 10");
        assertEquals(5, tower.getRange(), "El alcance inicial debe ser 5");
        assertEquals(2, tower.getFireRate(), "La velocidad de disparo inicial debe ser 2");
    }

    //Test para los getter y setter de la clase Tower
    @Test
    public void testGetDamage() {
        assertEquals(10, tower.getDamage());
    }

    @Test
    public void testSetDamage() {
        tower.setDamage(15);
        assertEquals( 15, tower.getDamage());
    }

    @Test
    public void testGetRange() {
        assertEquals( 5, tower.getRange());
    }

    @Test
    public void testSetRange() {
        tower.setRange(8);
        assertEquals(8, tower.getRange());
    }

    @Test
    public void testGetFireRate() {
        assertEquals(2, tower.getFireRate());
    }

    @Test
    public void testSetFireRate() {
        tower.setFireRate(3);
        assertEquals(3, tower.getFireRate());
    }

    @Test
    public void testAttack_EnemyInRange() {
        List<Enemy> enemies = Arrays.asList(new BasicEnemy());
        enemies.get(0).setPosX(2);
        enemies.get(0).setPosY(2);
        Tower tower = new CannonTower();
        tower.setPosX(2);
        tower.setPosY(1);
        tower.attack(enemies.get(0));
        // Verificar que el enemigo ha recibido daño
        assertEquals(50, enemies.get(0).getHealth());
    }
    @Test
    public void testAttack_EnemyOutOfRange() {
        List<Enemy> enemies = Arrays.asList(new BasicEnemy());
        enemies.get(0).setPosX(5);
        enemies.get(0).setPosY(5);
        Tower tower = new CannonTower();
        tower.setPosX(2);
        tower.setPosY(1);
        tower.attack(enemies.get(0));
        // Verificar que el enemigo no ha recibido daño
        assertEquals(100, enemies.get(0).getHealth());
    }
}