package se.kth.DD2480;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CMVTest {
    CMV cmv;
    @BeforeEach
    void setUp() {
        CMV cmv = new CMV();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void lic0_returnsFalse_whenPointsIsNull() {
        CMV cmv = new CMV();
        assertFalse(cmv.lic0(null, 6, 0));
    }

    @Test
    void lic0_returnsFalse_whenNoDistanceGreaterThanLength() {
        CMV cmv = new CMV();
        Point[] points = {
                new Point(0, 0),
                new Point(3, 4), // distance = 5
                new Point(6, 8)  // distance = 5
        };

        assertFalse(cmv.lic0(points, 5.0, points.length));
    }
    @Test
    void lic0_returnsTrue_whenDistanceGreaterThanLength() {
        CMV cmv = new CMV();
        Point[] points = {
                new Point(0, 0),
                new Point(10, 0) // distance = 10
        };

        assertTrue(cmv.lic0(points, 5.0, points.length));
    }
 
    void lic1_anyinput() {
        CMV cmv = new CMV();
        Point p1 = new Point(0,0);
        Point p2 = new Point(10,0);
        Point[] points = {p1, p2};
        assertFalse(cmv.lic1(points, 2, 1));
    }

    @Test
    void lic1_returnsTrue_whenRadiusBiggerThanRADIUS1() {
        CMV cmv = new CMV();
        Point p1 = new Point(0,0);
        Point p2 = new Point(1,0);
        Point p3 = new Point(10,0);
        Point p4 = new Point(0,10);
        Point[] points = {p1, p2, p3, p4};
        assertTrue(cmv.lic1(points, 4, 5));
    }



    @Test
    void lic1_invalid_input() {
        CMV cmv = new CMV();
        Point p1 = new Point(0,0);
        Point p2 = new Point(10,0);
        Point p3 = new Point(0,10);
        Point[] points = {p1, p2, p3};
        assertFalse(cmv.lic1(points, 3, -1));
    }

    @Test
    void lic2() {
    }

    @Test
    void lic3() {
    }

    @Test
    void lic4_ReturnsFalseForIllegalQuads() {
        CMV cmv = new CMV();
        Point[] points = {new Point(0, 0), new Point(1,1), new Point(0,1),
                new Point(-1,0), new Point(0,-1)};
        assertFalse(cmv.lic4(points, points.length, 2, 0));
    }

    @Test
    void lic4_ReturnsFalseForIllegalQ_PTS() {
        CMV cmv = new CMV();
        Point[] points = {new Point(1, 1), new Point(-1,1), new Point(-1,-1),
                new Point(1,-1), new Point(0,-1)};
        assertFalse(cmv.lic4(points, points.length, 1, 3));
    }

    @Test
    void lic4_ReturnsTrueForConsecutiveBoundaryPoints() {
        CMV cmv = new CMV();
        Point[] points = {new Point(0, 0), new Point(1,1), new Point(0,1),
        new Point(-1,0), new Point(0,-1)};
        assertTrue(cmv.lic4(points, points.length, 5, 2));
    }

    @Test
    void lic4_ReturnsFalseWhenPointsIsNull() {
        CMV cmv = new CMV();
        Point[] points = {new Point(0, 0), new Point(-1, -1)};
        assertFalse(cmv.lic4(null, points.length, 2, 1));
    }

    @Test
    void lic4_ReturnsFalseWhenSetIsClearedWhenItWouldHaveReturnedTrueOtherwise() {
        CMV cmv = new CMV();
        Point[] points = {new Point(0, 0), new Point(-1, 1), new Point(-1,-1), new Point(-2,1),
            new Point(1,-1)};
        assertFalse(cmv.lic4(points, points.length, 4, 3));
    }

    @Test
    void lic4_ReturnsFalseWhenQuad4IsExcluded() {
        CMV cmv = new CMV();
        Point[] points = {new Point(0, 0), new Point(1,1)};
        assertFalse(cmv.lic4(points, points.length, 2, 1));
    }

    @Test
    void lic4_ReturnsFalseWhenAllPointsInOneQuad() {
        CMV cmv = new CMV();
        Point[] points = {new Point(0, 0), new Point(1,1)};
        assertFalse(cmv.lic4(points, points.length, 2, 1));
    }

    @Test
    void lic4_ReturnsTrueWhenTwoConsecutiveSpreadInTwoDistinctQuads() {
        CMV cmv = new CMV();
        Point[] points = {new Point(0, 0), new Point(-1, -1)};
        assertTrue(cmv.lic4(points, points.length, 2, 1));
    }

    @Test
    void lic4_ReturnsFalseWhenTwoConsecutiveSpreadInTwoDistinctQuadsButQ_PTSEqualsQuads() {
        CMV cmv = new CMV();
        Point[] points = {new Point(0, 0), new Point(-1, -1)};
        assertFalse(cmv.lic4(points, points.length, 2, 2));
    }

    @Test
    void lic4_ReturnsFalseWhenQ_PointsMoreThanNumPoints() {
        CMV cmv = new CMV();
        Point[] points = {new Point(0, 0), new Point(-1, -1)};
        assertFalse(cmv.lic4(points, points.length, 3, 2));
    }

    @Test
    void lic4_ReturnsTrueForConsecutivelyPlacedCorrectElementsAreFirstInPointsArray() {
        CMV cmv = new CMV();
        Point[] points = {new Point(0, 0), new Point(-1, -1), new Point(-1, 0), new Point(-1, 1)};
        assertTrue(cmv.lic4(points, points.length, 3, 2));
    }
    @Test
    void lic4_ReturnsTrueForConsecutivelyPlacedCorrectElementsAreLastInPointsArray() {
        CMV cmv = new CMV();
        Point[] points = {new Point(0, 0), new Point(1, 15), new Point(-1, 0), new Point(-1, -1)};
        assertTrue(cmv.lic4(points, points.length, 3, 2));
    }

    @Test
    void lic4_returnsFalseWhenNotSpreadInDistinctQuadsButNotConsecutively() {
        CMV cmv = new CMV();
        Point[] points = {new Point(0, 0), new Point(-1, 15), new Point(1, 1), new Point(11, 10), new Point(10, 10),
                new Point(0, -10), new Point(1, 15)};
        assertFalse(cmv.lic4(points, points.length, 3, 2));
    }

    @Test
    void lic4_returnsFalseWhenSpreadInDistinctQuadsConsecutivelyButNotQ_PTSEqualQuads() {
        CMV cmv = new CMV();
        Point[] points = {new Point(0, 0), new Point(-1, 15), new Point(1, 1), new Point(11, 10), new Point(10, 10),
                new Point(0, -10), new Point(-1, -12)};
        assertFalse(cmv.lic4(points, points.length, 3, 3));
    }



    @Test
    void lic5_returnsFalse_whenNotEnoughPoints() {
        CMV cmv = new CMV();
        Point[] points = { new Point(1,1)};
        assertFalse(cmv.lic5(points, 1));
    }
    @Test
    void lic5_returnsFalse_whenXNeverDecreases() {
        CMV cmv = new CMV();
        Point[] points = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(2, 0)
        };

        assertFalse(cmv.lic5(points, points.length));
    }
    @Test
    void lic5_returnsTrue_whenXDecreases() {
        CMV cmv = new CMV();
        Point[] points = {
                new Point(5, 0),
                new Point(3, 0)
        };

        assertTrue(cmv.lic5(points, points.length));
    }




    @Test
    void lic6() {
    }

    @Test
    void lic7() {
    }

    @Test
    void lic8() {
    }

    @Test
    void lic9() {
    }

    @Test
    void lic10_returnsFalse_whenParametersInvalid() {
        CMV cmv = new CMV();
        Point[] points = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(2, 0)
        };

        assertFalse(cmv.lic10(points, 0, 0, 1.0, points.length));
    }
    @Test
    void lic10_returnsFalse_whenAllTriangleAreasTooSmall() {
        CMV cmv = new CMV();
        Point[] points = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(2, 0),
                new Point(3, 0),
                new Point(4, 0)
        };

        assertFalse(cmv.lic10(points, 1, 1, 1.0, points.length));
    }
    @Test
    void lic10_returnsTrue_whenTriangleAreaGreaterThanAREA1() {
        CMV cmv = new CMV();
        Point[] points = {
                new Point(6, 1),
                new Point(0, 4),
                new Point(3, 3),
                new Point(8, 0),
                new Point(0, 0)
        };

        assertTrue(cmv.lic10(points, 1, 1, 5.0, points.length));
    }



    @Test
    void lic11() {
    }

    /**
     * Tests if two separate pairs K_PTS apart fit criteria.
     * Criteria for LIC to be true: One pair more than LENGHT1 apart and one pair less than LENGTH2 apart
     */
    @Test
    void lic12_returnsTrue_whenTwoSeparatePairsOfPointsK_PTSapartFitCriteria() {
        CMV cmv = new CMV();
        // points[0] and points[2] are more than 3 apart
        // points[1] and points[3] are less than 2 apart
        Point[] points = {new Point(-1, -1), new Point(1, 0), new Point(5, 5), new Point(0, 1) };

        assertTrue(cmv.lic12(points, 4, 3, 2, 1)); // POINTS, NUMPOINTS, LENGHT1, LENGHT2, K_PTS
    }

    /**
     * Criteria for LIC to be true: One pair more than LENGHT1 apart and one pair less than LENGTH2 apart
     */
    @Test
    void lic12_returnsFalse_whenOnlyOnePairFitsCriteria() {
        CMV cmv = new CMV();
        // points[0] and points[2] are more than 3 apart
        // No pair of paint with 1 element in between are less than 1 distance apart.
        Point[] points = {new Point(-1, -1), new Point(1, 0), new Point(5, 5), new Point(0, 1) };

        assertFalse(cmv.lic12(points, 4, 3, 1, 1)); // POINTS, NUMPOINTS, LENGHT1, LENGHT2, K_PTS
    }

    @Test
    void lic12_returnsFalse_whenNoPairFitsCriteria() {
        CMV cmv = new CMV();
        // No pair of paint with 1 element in between are more than 10 distance apart.
        // No pair of paint with 1 element in between are less than 1 distance apart.
        Point[] points = {new Point(-1, -1), new Point(1, 0), new Point(5, 5), new Point(0, 1) };

        assertFalse(cmv.lic12(points, 4, 10, 1, 1)); // POINTS, NUMPOINTS, LENGHT1, LENGHT2, K_PTS
    }

    @Test
    void lic12_returnsFalse_whenInputParamIsInvalid() {
        CMV cmv = new CMV();
        // Valid points for LIC to return true
        Point[] points = {new Point(-1, -1), new Point(1, 0), new Point(5, 5), new Point(0, 1) };

        assertFalse(cmv.lic12(points, 2, 10, 1, 1));        // NUMPOINTS invalid
        assertFalse(cmv.lic12(points, 4, 10, -1, 1));       // LENGTH2   invalid
        assertFalse(cmv.lic12(points, 4, 10, 1, 3));        // K_PTS     invalid in regard to NUMPOINTS
        assertFalse(cmv.lic12(null, 4, 10, 1, 1));    // POINTS    invalid



    }

    @Test
    void lic13() {
    }

    @Test
    void lic14() {
    }

    @Test
    void lic15() {
    }

    @Test
    void verifyAllLics() {
    }
}