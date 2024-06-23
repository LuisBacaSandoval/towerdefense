package org.example.towers;

//Implementan TowerFactory y el metodo createTower devuelve un ArrowTower
public class ArrowTowerFactory implements TowerFactory{
    @Override
    public Tower createTower() {
        return new ArrowTower();
    }
}
