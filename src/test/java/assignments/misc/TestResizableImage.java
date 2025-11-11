package assignments.misc;

import assignments.misc.v2.ResizableImage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestResizableImage {

    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testCtorAndGettersSetters() {
        ResizableImage img = new ResizableImage(10, 20);
        assertAll(
                () -> assertEquals(10, img.getWidth()),
                () -> assertEquals(20, img.getHeight()),
                () -> assertEquals(200.0, img.getArea(), DOUBLE_EPS)
        );
        img.setWidth(7);
        img.setHeight(9);
        assertAll(
                () -> assertEquals(7, img.getWidth()),
                () -> assertEquals(9, img.getHeight()),
                () -> assertEquals(63.0, img.getArea(), DOUBLE_EPS)
        );
    }

    @Test
    public void testResizeFloorAndNonNegative() {
        ResizableImage img = new ResizableImage(10, 10);
        img.resize(0.3);
        assertAll(
                () -> assertEquals(3, img.getWidth()),
                () -> assertEquals(3, img.getHeight()),
                () -> assertEquals(9.0, img.getArea(), DOUBLE_EPS)
        );
        img.resize(-1.0);
        assertAll(
                () -> assertTrue(img.getWidth() >= 0),
                () -> assertTrue(img.getHeight() >= 0)
        );
    }

    @Test
    public void testEqualsHashCode() {
        ResizableImage a = new ResizableImage(5, 6);
        ResizableImage b = new ResizableImage(5, 6);
        ResizableImage c = new ResizableImage(6, 5);
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
        assertNotEquals(a, c);
    }
}