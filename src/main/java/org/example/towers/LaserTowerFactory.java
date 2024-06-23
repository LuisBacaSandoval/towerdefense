package org.example.towers;

//Implementan TowerFactory y el metodo createTower devuelve un LaserTower

public class LaserTowerFactory implements TowerFactory{
    @Override
    public Tower createTower() {
        return new LaserTower();
    }
}
