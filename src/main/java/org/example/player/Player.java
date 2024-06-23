package org.example.player;

import org.example.enemies.Enemy;

//El jugador gana puntos por derrotar enemigos y pierde puntos si los enemigos alcanzan
//la base.
public class Player {
    private int score;//puntuación del jugador. Cada enemigo tiene una recompensa que se suma a la puntuacion
    private int baseHealth;// puntos de la base. Si un enemigo llega a la base se restan 10 puntos
    public Player() {
        this.score = 0;
        this.baseHealth = 100;
    }
    public void addScore(int points) {
        this.score += points;
    }
    public void deductBaseHealth(int damage) {
        this.baseHealth -= damage;
    }
    public int getScore() {
        return score;
    }
    public int getBaseHealth() {
        return baseHealth;
    }
    // Metodo para actualizar el score y la vida de la base
    public void  updateScoreAndHealth(Enemy enemy, boolean defeated){
        if (defeated){
            addScore(enemy.getReward());
        }else{
            deductBaseHealth(10);
        }

    }
}

