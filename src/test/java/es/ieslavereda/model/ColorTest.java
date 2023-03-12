package es.ieslavereda.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Color test.
 */
class ColorTest {
    /**
     * The W.
     */
    Color w, /**
     * The B.
     */
    b;

    /**
     * Initialize.
     */
    @BeforeEach
    void initialize(){
        w = Color.WHITE;
        b = Color.BLACK;
    }

    /**
     * Next.
     */
    @Test
    @DisplayName("Prueba cambio color")
    void next() {

        assertEquals(w.next(), Color.BLACK);
        assertEquals(b.next(), Color.WHITE);
//        assertEquals(w.next(), Color.WHITE);


    }
}