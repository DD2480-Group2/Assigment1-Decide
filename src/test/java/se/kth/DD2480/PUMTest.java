package se.kth.DD2480;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PUMTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    //All elements in lcm are NOTUSED, therefore all elements of PUM must be true.
    @Test
    void makePUM_NOTUSED_ResultsInAllTrueEvenWhenCMVAllTrue() {

        boolean[] cmv = {true, true, true, true,
                true, true, true, true, true, true, true, true, true, true, true
        };

        CONNECTORS[][] lcm = new CONNECTORS[15][15];
        //CONNECTORS[][] lcm = LCM.createLCMParameters(1);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                lcm[i][j] = CONNECTORS.NOTUSED;
            }
        }

        PUM pum = new PUM();
        boolean[][] pumArray = pum.makePUM(lcm, cmv);

        boolean[][] expectedPumArray = new boolean[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                expectedPumArray[i][j] = true;
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                assertEquals(expectedPumArray[i][j], pumArray[i][j]);
            }
        }
    }

    @Test
    void makePUM_NOTUSED_ResultsInAllTrueEvenWhenCMVAllFalse() {

        boolean[] cmv = {false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false
        };

        CONNECTORS[][] lcm = new CONNECTORS[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                lcm[i][j] = CONNECTORS.NOTUSED;
            }
        }

        PUM pum = new PUM();
        boolean[][] pumArray = pum.makePUM(lcm, cmv);

        boolean[][] expectedPumArray = new boolean[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                expectedPumArray[i][j] = true;
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                assertEquals(expectedPumArray[i][j], pumArray[i][j]);
            }
        }
    }

    //Sets cmv[0] and cmv[7] to false.
    @Test
    void makePUM_ORR_allTrueExceptFirstInCMVAndSeventhInCMVReturnsCorrectlyForPUM() {

        boolean[] cmv = {false, true, true, true,
                true, true, true, false, true, true, true, true, true, true, true
        };

        CONNECTORS[][] lcm = new CONNECTORS[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                lcm[i][j] = CONNECTORS.ORR;
            }
        }

        PUM pum = new PUM();
        boolean[][] pumArray = pum.makePUM(lcm, cmv);

        boolean[][] expectedPumArray = new boolean[15][15];
        expectedPumArray[0][0] = false;
        expectedPumArray[7][7] = false;
        expectedPumArray[0][7] = false;
        expectedPumArray[7][0] = false;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if((i == 0 && j == 0) || (i == 7 && j == 7) || (i == 0 && j == 7) || (i == 7 && j == 0)) continue; //Don't override these indices value
                expectedPumArray[i][j] = true; //All other set to true
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                assertEquals(expectedPumArray[i][j], pumArray[i][j]);
            }
        }
    }

    @Test
    void makePUM_ANDD_whenOnlyFirstCMVFalseOnlyCol0AndRow0False() {

        boolean[] cmv = {false, true, true, true,
                true, true, true, true, true, true, true, true, true, true, true
        };

        CONNECTORS[][] lcm = new CONNECTORS[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                lcm[i][j] = CONNECTORS.ANDD;
            }
        }

        PUM pum = new PUM();
        boolean[][] pumArray = pum.makePUM(lcm, cmv);

        boolean[][] expectedPumArray = new boolean[15][15];

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if(i == 0 || j == 0) continue; //Any ANDD involving cmv[0] is false.
                expectedPumArray[i][j] = true; //All other set to true
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                assertEquals(expectedPumArray[i][j], pumArray[i][j]);
            }
        }
    }

    @Test
    void makePUM_Mix_NOTUSED_ORR_ANDD_ReturnsCorrectlyForPUM() {

        boolean[] cmv = {false, true, true, true,
                true, true, true, true, true, true, true, true, true, true, true
        };

        CONNECTORS[][] lcm = new CONNECTORS[15][15];
        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 15; j++) {
                lcm[i][j] = CONNECTORS.NOTUSED;
            }
        }
        lcm[0][2] = CONNECTORS.ANDD; //expected false in PUM
        lcm[2][0] = CONNECTORS.ANDD; //expected false in PUM
        lcm[0][3] = CONNECTORS.ORR;  //expected true in PUM
        lcm[3][0] = CONNECTORS.ORR;  //expected true in PUM

        PUM pum = new PUM();
        boolean[][] pumArray = pum.makePUM(lcm, cmv);

        boolean[][] expectedPumArray = new boolean[15][15];

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                expectedPumArray[i][j] = true;
            }
        }
        expectedPumArray[0][2] = false;
        expectedPumArray[2][0] = false;
        expectedPumArray[0][3] = true;
        expectedPumArray[3][0] = true;

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                assertEquals(expectedPumArray[i][j], pumArray[i][j]);
            }
        }
    }
}