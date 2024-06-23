package org.example.enemies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FastEnemyFactoryTest {
    /**
        * Caso de prueba para verificar que el método createEnemy de FastEnemyFactory
        * devuelve un objeto enemigo no nulo.
    */
    @Test
    public void testCreateEnemyNotNull() {
        FastEnemyFactory factory = new FastEnemyFactory();
        Enemy enemy = factory.createEnemy();
        assertNotNull(enemy, "El metodo createEnemy debe devolver un objeto no nulo");
    }

    /**
     * Caso de prueba para el método createFastEnemy de la clase FastEnemyFactory.
     * Verifica que el método createEnemy devuelve una instancia de FastEnemy.
     */
    @Test
    public void testCreateFastEnemy() {
        FastEnemyFactory factory = new FastEnemyFactory();
        Enemy enemy = factory.createEnemy();
        assertTrue(enemy instanceof FastEnemy, "El metodo createEnemy debe devolver un enemigo FastEnemy");
    }
}