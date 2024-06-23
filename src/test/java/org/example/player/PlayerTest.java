package org.example.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    //prueba para verificar los valores iniciales de la base y score
    @Test
    void pruebaValoresIniciales() {
        assertEquals(0, player.getScore(), "El puntaje inicial debe ser 0");
        assertEquals(100, player.getBaseHealth(), "La salud inicial de la base debe ser 100");
    }

    //prueba para verificar que cuando se agreguen 10 puntos, el metodo getScore los suma correctamente
    @Test
    void pruebaAniadirPuntos() {
        player.addScore(10);
        assertEquals(10, player.getScore());
    }
    //prueba para verificar que cuando se ataque la base, esta pierde 10 puntos de vida
    @Test
    void pruebaReducirVidaALaBase() {
        player.deductBaseHealth(10);
        assertEquals(90, player.getBaseHealth());
    }
    //prueba para verificar que cuando se agreguen 20 puntos y luego se agreguen 30 puntos, el metodo getScore los suma correctamente
    @Test
    void pruebaObtenerPuntuacion() {
        player.addScore(20);
        player.addScore(30);
        assertEquals(50, player.getScore());
    }
    //prueba para verificar que cuando se ataque la base, esta pierde 10 puntos de vida y luego pierde otros 20 puntos de vida
    @Test
    void pruebaObtenerVidaDeBase() {
        player.deductBaseHealth(10);
        player.deductBaseHealth(20);
        assertEquals(70, player.getBaseHealth());
    }
}