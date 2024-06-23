package org.example.enemies;

//Los enemigos son las entidades que el jugador debe detener.
// Tienen varias características que determinan su comportamiento y dificultad.
public class Enemy {
    private int speed; // Velocidad: Determina cuántas celdas se mueve el enemigo por turno
    private int health;// Vida: Cantidad de daño que puede recibir antes de ser derrotado.
    private int reward;// Recompensa: Puntos que el jugador gana al derrotar al enemigo.
    private int posX;//fila
    private int posY;//columna
    //constructor de la clase
    public Enemy(int speed, int health, int reward) {
        this.speed = speed;
        this.health = health;
        this.reward = reward;
    }

    //getters y setters de los atributos de la clase
    public int getSpeed() {return speed;}
    public void setSpeed(int speed) {this.speed = speed;}

    public int getHealth() {return health;}
    public void setHealth(int health) {this.health = health;}

    public int getReward() {return reward;}
    public void setReward(int reward) {this.reward = reward;}

    public int getPosX() {return posX;}
    public void setPosX(int posX) {this.posX = posX;}

    public int getPosY() {return posY;}
    public void setPosY(int posY) {this.posY = posY;}
}

