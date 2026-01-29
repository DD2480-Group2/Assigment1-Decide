package se.kth.DD2480;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PUVTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Passing 0 as a parameter should return an array with all elements as false.
     * Test goes through array created with 0 and checks that each index is false.
     */
    @Test
    void creatPUVwith0isFilledWithFalse() {
        PUV puv = PUV.createPUV(0);
        for (int i = 0; i < 15; i++) {
            assertFalse(puv.getArray()[i]);
        }
    }

    /**
     * Passing 1 as a parameter should return an array with all elements as true.
     * Test goes through array created with 0 and checks that each index is true.
     */
    @Test
    void creatPUVwith1isFilledWithTrue() {
        PUV puv = PUV.createPUV(1);
        for (int i = 0; i < 15; i++) {
            assertTrue(puv.getArray()[i]);
        }
    }
}