package se.kth.DD2480;

public class LCM {

    CONNECTORS[][] arr;
    static final int SIZE = 15;

    public LCM(CONNECTORS[][] arr) {
        this.arr = arr;
    }

    //A random comment1 1223123132141234123
    public CONNECTORS[][] getArr() {
        return arr;
    }

    private static CONNECTORS[][] filled(CONNECTORS c) {
        CONNECTORS[][] m = new CONNECTORS[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                m[i][j] = c;
            }
        }

        return m;
    }

    /**
     * Method that creates a LCM depending on what input is given.
     * @param mode, 0 = ALL NOTUSED, 1 = ALL ANDD, 2 = ALL ORR
     * @return
     */
    public static LCM createLCM(int mode) {
        return switch (mode) {
            case 0 -> new LCM(filled(CONNECTORS.NOTUSED));
            case 1 -> new LCM(filled(CONNECTORS.ANDD));
            case 2 -> new LCM(filled(CONNECTORS.ORR));
            default -> throw new IllegalArgumentException("Only allow whole numbers 0-2 as input");
        };
    }
}
