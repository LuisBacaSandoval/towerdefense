package org.example.enemies;

//Implementan EnemyFactory y el metodo createEnemy devuelve un FastEnemy
public class FastEnemyFactory implements EnemyFactory{
    @Override
    public Enemy createEnemy() {
        return new FastEnemy();
    }
}
