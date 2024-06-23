package org.example.enemies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BossEnemyFactoryTest {
    /**
     * Caso de prueba para verificar que el método createEnemy de BossEnemyFactory
     * devuelve un objeto Enemy no nulo.
     */
    @Test
    public void testCreateEnemyNotNull() {
        BossEnemyFactory factory = new BossEnemyFactory();
        Enemy enemy = factory.createEnemy();
        assertNotNull(enemy, "El metodo createEnemy debe devolver un objeto no nulo");
    }

    /**
     * Caso de prueba para crear un BossEnemy utilizando BossEnemyFactory.
     * Verifica que el método createEnemy devuelve una instancia de BossEnemy.
     */
    @Test
    public void testCreateBossEnemy() {
        BossEnemyFactory factory = new BossEnemyFactory();
        Enemy enemy = factory.createEnemy();
        assertTrue(enemy instanceof BossEnemy, "El metodo createEnemy debe devolver un enemigo BossEnemy");
    }
}