package se.kth.DD2480;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PUVTest {
    private PUV puv;

    @BeforeEach
    void setUp() {
        puv = new PUV();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void constructor_initializesAllToFalse() {
        for (int i = 0; i < 15; i++) {
            assertFalse(puv.getIndex(i));
        }
    }

    @Test
    void setIndexAnd_getIndexWorkForValidIndices() {
        PUV puv = new PUV();

        puv.setIndex(0, true);
        puv.setIndex(14, true);
        puv.setIndex(7, false);

        assertTrue(puv.getIndex(0));
        assertTrue(puv.getIndex(14));
        assertFalse(puv.getIndex(7));
    }

    @Test
    void setAllFalseSetsAllValuesToFalse() {
        PUV puv = new PUV();

        puv.setIndex(0, true);
        puv.setIndex(14, true);
        puv.setIndex(7, true);

        puv.setAllFalse();

        for (int i = 0; i < 15; i++) {
            assertFalse(puv.getIndex(i));
        }
    }

    @Test
    void setIndexThrowsWhenIndexTooLow() {
        PUV puv = new PUV();

        IndexOutOfBoundsException error = assertThrows(IndexOutOfBoundsException.class, () ->
                puv.setIndex(-1, true));

        assertEquals("Allowed index is [0, 14]", error.getMessage());
    }

    @Test
    void setIndexThrowsWhenIndexTooHigh() {
        PUV puv = new PUV();

        IndexOutOfBoundsException error = assertThrows(IndexOutOfBoundsException.class, () ->
                puv.setIndex(15, true));

        assertEquals("Allowed index is [0, 14]", error.getMessage());
    }

    @Test
    void getIndexThrowsWhenIndexTooLow() {
        PUV puv = new PUV();

        IndexOutOfBoundsException error = assertThrows(IndexOutOfBoundsException.class, () ->
                puv.getIndex(-1));

        assertEquals("Allowed index is [0, 14]", error.getMessage());
    }

    @Test
    void getIndexThrowsWhenIndexTooHigh() {
        PUV puv = new PUV();

        IndexOutOfBoundsException error = assertThrows(IndexOutOfBoundsException.class, () ->
                puv.getIndex(15));

        assertEquals("Allowed index is [0, 14]", error.getMessage());
    }
}