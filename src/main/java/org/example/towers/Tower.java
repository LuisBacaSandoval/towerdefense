package org.example.towers;

//Las torres son las defensas que el jugador coloca en el mapa para
// detener a los enemigos. Tienen diferentes características y habilidades.

import org.example.enemies.Enemy;

public class Tower {
    private int damage; // Daño: Cantidad de daño que inflige a los enemigos.
    private int range;  // Alcance: Número de celdas a las que puede atacar desde su posición.
    private int fireRate;  // Velocidad de disparo: Frecuencia con la que puede atacar, turnos entre disparo
    private int posX;//fila
    private int posY;//columna

    //constructor de la clase
    public Tower(int damage, int range, int fireRate) {
        this.damage = damage;
        this.range = range;
        this.fireRate = fireRate;
    }

    //getters y setters de los atributos de la clase
    public int getDamage() { return damage; }
    public void setDamage(int damage) { this.damage = damage; }

    public int getRange() { return range; }
    public void setRange(int range) { this.range = range; }

    public int getFireRate() { return fireRate; }
    public void setFireRate(int fireRate) { this.fireRate = fireRate; }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    //Metodo para atacar enemigos que estan dentro del rango de la torre
    public void attack(Enemy enemies){
        double length = Math.sqrt(Math.pow(Math.abs(enemies.getPosX()-getPosX()), 2)+Math.pow(Math.abs(enemies.getPosY()-getPosY()), 2));
        if (length <= getRange()){
            enemies.setHealth(enemies.getHealth() - getDamage());
        }
    }
}
