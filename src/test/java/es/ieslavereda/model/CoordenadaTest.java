package es.ieslavereda.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CoordenadaTest {
    @BeforeAll
    static void initialize(){
        System.out.println("Ejecutando beforeAll");
    }

    @BeforeEach
    void before(){
        System.out.println("Ejecutando beforeEach");
    }

    @Test
    @DisplayName("Prueba del método up")
    void up() {
        Coordenada c1 = new Coordenada('C', 5);
        Coordenada c2 = new Coordenada('C', 4);

        assertEquals(c1.up(), c2);
    }

    @Test
    @DisplayName("Prueba del método down")
    void down() {
        Coordenada b1 = new Coordenada('B',4);
        Coordenada b2 = new Coordenada('b', 5);

        assertEquals(b1.down(), b2);
    }

    @Test
    @DisplayName("Prueba del método left")
    void left() {
        Coordenada b = new Coordenada('B',4);
        Coordenada a = new Coordenada('a', 4);

        assertEquals(b.left(), a);
    }

    @Test
    @DisplayName("Prueba del método right")
    void right() {
        Coordenada b = new Coordenada('B',4);
        Coordenada c = new Coordenada('c', 4);

        assertEquals(b.right(), c);
    }

    @Test
    @DisplayName("Prueba del método upRight")
    void upRight() {
        Coordenada b = new Coordenada('B',4);
        Coordenada c = new Coordenada('c', 3);

        assertEquals(b.upRight(), c);
    }

    @Test
    @DisplayName("Prueba del método upLeft")
    void upLeft() {
        Coordenada b = new Coordenada('B',4);
        Coordenada c = new Coordenada('a', 3);

        assertEquals(b.upLeft(), c);
    }

    @Test
    @DisplayName("Prueba del método downRight")
    void downRight() {
        Coordenada b = new Coordenada('B',4);
        Coordenada c = new Coordenada('c', 5);

        assertEquals(b.downRigth(), c);
    }

    @Test
    @DisplayName("Prueba del método downLeft")
    void downLeft() {
        Coordenada b = new Coordenada('B',4);
        Coordenada c = new Coordenada('a', 5);

        assertEquals(b.downLeft(), c);
    }
}