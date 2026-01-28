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
}
