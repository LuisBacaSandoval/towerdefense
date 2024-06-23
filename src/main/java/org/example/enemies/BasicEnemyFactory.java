package org.example.enemies;

//Implementan EnemyFactory y el metodo createEnemy devuelve un BasicEnemy
public class BasicEnemyFactory implements EnemyFactory{
    @Override
    public Enemy createEnemy() {
        return new BasicEnemy();
    }
}
