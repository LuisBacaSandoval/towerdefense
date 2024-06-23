package org.example.towers;

//Implementan TowerFactory y el metodo createTower devuelve un CannonTower
public class CannonTowerFactory implements TowerFactory{
    @Override
    public Tower createTower() {
        return new CannonTower();
    }
}
