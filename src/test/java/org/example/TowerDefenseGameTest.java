package org.example;

import org.example.enemies.BasicEnemy;
import org.example.map.Map;
import org.example.towers.CannonTower;
import org.example.towers.CannonTowerFactory;
import org.example.wave.Wave;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TowerDefenseGameTest {
    private TowerDefenseGame game;
    @Mock
    Map mockMap;
    @Mock
    Wave mockWave;
    @InjectMocks
    private TowerDefenseGame towerDefenseGame;

    @BeforeEach
    public void setUp() {
        game = new TowerDefenseGame();
    }

    /**
        * Caso de prueba para verificar que el método getMap() devuelve una instancia no nula de Map.
    */
    @Test
    public void testGetMap_ReturnsNonNullMap() {
        assertNotNull(game.getMap(), "El método getMap debe devolver una instancia no nula de Map");
    }

    /**
        * Caso de prueba para verificar que el método getPlayer devuelve una instancia no nula de Player.
    */
    @Test
    public void testGetPlayer_ReturnsNonNullPlayer() {
        assertNotNull(game.getPlayer(), "El método getPlayer debe devolver una instancia no nula de Player");
    }

    /**
        * Caso de prueba para verificar que el método getWave devuelve nulo inicialmente cuando la onda no se ha inicializado.
    */
    @Test
    public void testGetWave_InitiallyNull() {
        assertNull(game.getWave(), "Inicialmente, el método getWave debe devolver null ya que la oleada no ha sido inicializada");
    }
    /**
        * Caso de prueba para verificar que se puede colocar una torre en una posición válida en el mapa.
    */
    @Test
    public void testPlaceTower_ValidPosition() {
        // Configurar mock para posición válida
        when(mockMap.isValidPosition(3, 4)).thenReturn(true);
        towerDefenseGame.placeTower(new CannonTowerFactory(), 3, 4);
        // Verificar que la torre se haya colocado
        verify(mockMap).placeTower(eq(3), eq(4));
    }
    /**
        * Caso de prueba para verificar que una torre no esté colocada en una posición no válida.
    */
    @Test
    public void testPlaceTower_InvalidPosition() {
        // Configurar mock para posición inválida
        when(mockMap.isValidPosition(3, 4)).thenReturn(false);
        towerDefenseGame.placeTower(new CannonTowerFactory(), 3, 4);
        // Verificar que la torre no se haya colocado
        verify(mockMap, never()).placeTower(eq(3), eq(4));
    }
}