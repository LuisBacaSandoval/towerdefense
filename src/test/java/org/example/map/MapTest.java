package org.example.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MapTest {
    Map map;
    @BeforeEach
    public void setUp(){
        map = new Map();
    }
    //Test para validar que se coloca una torre en la posicion correcta
    //tener en cuenta que el mapa es un arreglo binimensional de 5x5
    //Pruebas fuera del limite
    @Test
    public void pruebaFilaIncorrectaNegativa(){
        Boolean result = map.placeTower(-5, 3);

        assertFalse(result);
    }
    @Test
    public void pruebaColumnaIncorrectaNegativa(){
        Boolean result = map.placeTower(3, -5);

        assertFalse(result);
    }
    @Test
    public void pruebaFilaIncorrectaPositiva(){
        Boolean result = map.placeTower(5, 2);

        assertFalse(result);
    }
    @Test
    public void pruebaColumnaIncorrectaPositiva(){
        Boolean result = map.placeTower(2, 5);

        assertFalse(result);
    }
    @Test
    public void pruebaFilaYColumnaIncorrecta(){
        Boolean result = map.placeTower(-5, -5);

        assertFalse(result);
    }
    //Pruebas dentro del limite
    @Test
    public void pruebaFilaYColumnaCorrecta(){
        Boolean result = map.placeTower(2, 3);

        assertTrue(result);
    }
    //Pruebas justo en el limite
    @Test
    public void pruebaLimiteInferiorFila(){
        Boolean result = map.placeTower(0, 3);

        assertTrue(result);
    }
    @Test
    public void pruebaLimiteInferiorColumna(){
        Boolean result = map.placeTower(3, 0);

        assertTrue(result);
    }
    @Test
    public void pruebaLimiteSuperiorFila(){
        Boolean result = map.placeTower(4, 2);

        assertTrue(result);
    }
    @Test
    public void pruebaLimiteSuperiorColumna(){
        Boolean result = map.placeTower(2, 4);

        assertTrue(result);
    }
}