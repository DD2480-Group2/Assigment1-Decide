package se.kth.DD2480;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LCMTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Creating an LCM with createLCM with parameter 0 as mode will return the LCM full of NOTUSED.
     * Test returns true is all elements in matrix is NOTUSED.
     */
    @Test
    void creatLCMwith0isFilledWithNOTUSED() {
        LCM lcm = LCM.createLCM(0);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                assertEquals(CONNECTORS.NOTUSED, lcm.getArr()[i][j]);
            }
        }
    }

    /**
     * Creating an LCM with createLCM with parameter 1 as mode will return the LCM full of ANDD.
     * Test returns true is all elements in matrix is ANDD.
     */
    @Test
    void creatLCMwith1isFilledWithANDD() {
        LCM lcm = LCM.createLCM(1);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                assertEquals(CONNECTORS.ANDD, lcm.getArr()[i][j]);
            }
        }

    }

    /**
     * Creating an LCM with createLCM with parameter 2 as mode will return the LCM full of ORR.
     * Test returns true is all elements in matrix is ORR.
     */
    @Test
    void creatLCMwith2isFilledWithORR() {
        LCM lcm = LCM.createLCM(2);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                assertEquals(CONNECTORS.ORR, lcm.getArr()[i][j]);
            }
        }

    }

    /**
     * Creating an LCM with createLCM with parameter that is not 0, 1 or 2 as mode will Throw IllegalArgumentException.
     * Test returns true if IllegalArgumentException is thrown when we call the method with all other values than 0, 1 and 2q
     */
    @Test
    void creatLCMwithInvalidThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> LCM.createLCM(-1));
        assertThrows(IllegalArgumentException.class, () -> LCM.createLCM(3));
    }
}