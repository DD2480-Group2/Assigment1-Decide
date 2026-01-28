package se.kth.DD2480;

public class PUV {
    private boolean[] arr;

    public PUV() {
        arr = new boolean[15];
    }

    public void setIndex(int i, boolean value) {
        checkIndex(i);
        arr[i] = value;
    }

    public boolean getIndex(int i) {
        checkIndex(i);
        return arr[i];
    }

    private void checkIndex(int i) {
        if (i < 0 || i > 14) throw new IndexOutOfBoundsException("Allowed index is [0, 14]");
    }

    /**
     * Used to make test where no LIC stops the launch. By using this method the FUV should be all true
     */
    public void setAllFalse() {
        for (int i = 0; i < 15; i++) {
            setIndex(i, false);
        }
    }
}
