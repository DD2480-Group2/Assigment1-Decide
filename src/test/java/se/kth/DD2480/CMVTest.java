package se.kth.DD2480;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CMVTest {
    CMV cmv;

    @BeforeEach
    void setUp() {
        cmv = new CMV();
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
    void lic2_returnsTrue_whenAngleIsLessThanPiMinusEpsilon() {
        CMV cmv = new CMV();
        Point[] points90degrees = {new Point(0, 1), new Point(0, 0), new Point(1, 0)};

        assertTrue(cmv.lic2(points90degrees, 3, 3.1415926535, 0.000001)); // Points, NUMPOINTS, PI, EPSILON
    }

    @Test
    void lic2_returnsFalse_whenPointsCollide() {
        CMV cmv = new CMV();
        Point[] collidingPoints = {new Point(0, 1), new Point(0, 0), new Point(0, 0)};

        assertFalse(cmv.lic2(collidingPoints, 3, 3.1415926535, 0.000001)); // Points, NUMPOINTS, PI, EPSILON
    }

    @Test
    void lic2_returnsFalse_whenInputParametersAreWrong() {
        CMV cmv = new CMV();
        Point[] validPoints = {new Point(0, 1), new Point(0, 0), new Point(1, 0)};

        assertFalse(cmv.lic2(null, 3, 3.1415926535, 1));              // Points is invalid
        assertFalse(cmv.lic2(validPoints, 2, 3.1415926535, 1));             // NUMPOINTS is invalid
        assertFalse(cmv.lic2(validPoints, 3, 1, 0));                        // EPSILON is invalid
        assertFalse(cmv.lic2(validPoints, 3, 3.1415926535, 3.1415926535));  // EPSILON is invalid
    }

    @Test
    void lic2_returnsFalse_whenPointsAreOnStraightLine() {
        CMV cmv = new CMV();
        Point[] straightLine = {new Point(0, 0), new Point(1, 1), new Point(2, 2)};

        assertFalse(cmv.lic2(straightLine, 3, 3.1415926535, 0.000001)); // Points, NUMPOINTS, PI, EPSILON
    }

    @Test
    void lic3_returnsFalse_whenPointsAreaLessThanArea1() {
        CMV cmv = new CMV();
        Point[] points = {new Point(0, 10), new Point(0, 0), new Point(10, 0)};
        assertFalse(cmv.lic3(points, points.length, 100.0));
    }

    @Test
    void lic3_returnsFalse_whenPointsAreaEqualToArea1() {
        CMV cmv = new CMV();
        Point[] points = {new Point(0, 0), new Point(0, 10), new Point(10, 0)};
        assertFalse(cmv.lic3(points, points.length, 50.0));
    }

    @Test
    void lic3_returnsFalse_whenNumpointsIsLessThanThree() {
        CMV cvm = new CMV();
        Point[] points = {new Point(0, 0), new Point(0, 10), new Point(10, 0)};
        assertFalse(cvm.lic3(points, 2, 0.0));
    }

    @Test
    void lic3_returnsFalse_whenPointsIsNull() {
        CMV cvm = new CMV();
        assertFalse(cvm.lic3(null, 3, 10.0));
    }

    @Test
    void lic3_returnsTrue_whenFirstPointsHaveValidArea() {
        CMV cmv = new CMV();
        Point[] points = {
                new Point(10, 0),
                new Point(0, 10),
                new Point(0, 0),
                new Point(3, 6)
        };
        assertTrue(cmv.lic3(points, points.length, 49.0));
    }

    @Test
    void lic3_returnsTrue_whenLastPointsHaveValidArea() {
        CMV cmv = new CMV();
        Point[] points = {
                new Point(4, 2),
                new Point(20, 0),
                new Point(0, 10),
                new Point(0, 0)
        };
        assertTrue(cmv.lic3(points, points.length, 99.0));
    }

    @Test
    void lic3_returnsTrue_whenPointsHaveValidAreaAndArea1IsZero() {
        CMV cmv = new CMV();
        Point[] points = {new Point(0, 0), new Point(0, 1), new Point(1, 0)};
        assertTrue(cmv.lic3(points, points.length, 0.0));
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
    void lic6_returnsFalseForNoPointFurtherAwayThanDist() {
        CMV cmv = new CMV();
        Point[] points = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(0, 0),
                new Point(0, 3)
        };

        assertFalse(cmv.lic6(points, points.length, 3, 2.0));
    }

    @Test
    void lic6_returnsFalseForNegativeDist() {
        CMV cmv = new CMV();
        Point[] points = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(3, 0),
                new Point(1, 0)
        };

        assertFalse(cmv.lic6(points, points.length, 3, -1));
    }

    @Test
    void lic6_returnsFalseForN_PTSBeingLargerThanNUMPOINTS() {
        CMV cmv = new CMV();
        Point[] points = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(3, 0),
                new Point(1, 0)
        };

        assertFalse(cmv.lic6(points, points.length, 5, 1));
    }

    @Test
    void lic6_returnsTrueForLastThreeElements() {
        CMV cmv = new CMV();
        Point[] points = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(3, 0),
                new Point(1, 0)
        };

        assertTrue(cmv.lic6(points, points.length, 3, 1));
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

    @Test
    void lic12() {
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