package org.example.enemies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicEnemyFactoryTest {
    
    /**
     * Caso de prueba para verificar que el método createEnemy de BasicEnemyFactory
     * devuelve un objeto Enemy no nulo.
     */
    @Test
    public void testCreateEnemyNotNull() {
        BasicEnemyFactory factory = new BasicEnemyFactory();
        Enemy enemy = factory.createEnemy();
        assertNotNull(enemy, "El metodo createEnemy debe devolver un objeto no nulo");
    }

    /**
     * Caso de prueba para el método createEnemy de BasicEnemyFactory.
     * Verifica que el método createEnemy devuelve una instancia de BasicEnemy.
     */
    @Test
    public void testCreateBasicEnemy() {
        BasicEnemyFactory factory = new BasicEnemyFactory();
        Enemy enemy = factory.createEnemy();
        assertTrue(enemy instanceof BasicEnemy, "El metodo createEnemy debe devolver un enemigo BasicEnemy");
    }
}