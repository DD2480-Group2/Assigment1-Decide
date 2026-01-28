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

    @Test
    void creatLCMwith0isFilledWithNOTUSED() {
        LCM lcm = LCM.createLCM(0);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                assertEquals(CONNECTORS.NOTUSED, lcm.getArr()[i][j]);
            }
        }
    }

    @Test
    void creatLCMwith1isFilledWithANDD() {
        LCM lcm = LCM.createLCM(1);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                assertEquals(CONNECTORS.ANDD, lcm.getArr()[i][j]);
            }
        }

    }

    @Test
    void creatLCMwith2isFilledWithORR() {
        LCM lcm = LCM.createLCM(2);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                assertEquals(CONNECTORS.ORR, lcm.getArr()[i][j]);
            }
        }

    }

    @Test
    void creatLCMwithInvalidThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> LCM.createLCM(-1));
        assertThrows(IllegalArgumentException.class, () -> LCM.createLCM(3));
    }
}