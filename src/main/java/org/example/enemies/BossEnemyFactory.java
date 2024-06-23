package org.example.enemies;

//Implementan EnemyFactory y el metodo createEnemy devuelve un BossEnemy
public class BossEnemyFactory implements EnemyFactory{
    @Override
    public Enemy createEnemy() {
        return new BossEnemy();
    }
}
