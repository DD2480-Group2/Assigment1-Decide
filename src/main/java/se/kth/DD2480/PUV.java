package se.kth.DD2480;

public class PUV {
    static final int SIZE = 15;
    boolean[] arr;

    public PUV(boolean[] arr) {
        if (arr == null || arr.length != SIZE) {
            throw new IllegalArgumentException("PUV must be atleast: " + SIZE);
        }
        this.arr = arr;
    }

    public boolean[] getArray() {
        return arr;
    }

    private static boolean[] filled(boolean value) {
        boolean[] v = new boolean[SIZE];
        for (int i = 0; i < SIZE; i++) {
            v[i] = value;
        }
        return v;
    }

    /**
     * Method that creates a PUV depending on what input is given.
     * @param mode, 0 = filled with false, 1 = filled with true
     */
    public static PUV createPUV(int mode) {
        return switch (mode) {
            case 0 -> new PUV(filled(false));
            case 1 -> new PUV(filled(true));
            default -> throw new IllegalArgumentException("Only allow whole numbers 0-1 as input");
        };
    }
}