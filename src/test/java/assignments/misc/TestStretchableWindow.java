package assignments.misc;

import assignments.figures.v2.Point;
import assignments.misc.v2.StretchableWindow;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestStretchableWindow {

    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testCtorAndGettersSetters() {
        StretchableWindow w = new StretchableWindow(10, 20, 30, 40, 7);
        assertAll(
                () -> assertEquals(10, w.getTopLeft().getX()),
                () -> assertEquals(20, w.getTopLeft().getY()),
                () -> assertEquals(30, w.getWidth()),
                () -> assertEquals(40, w.getHeight()),
                () -> assertEquals(7, w.getColor()),
                () -> assertEquals(1200.0, w.getArea(), DOUBLE_EPS)
        );

        w.setTopLeft(new Point(-1, -2));
        w.setWidth(11);
        w.setHeight(22);
        w.setColor(99);
        assertAll(
                () -> assertEquals(-1, w.getTopLeft().getX()),
                () -> assertEquals(-2, w.getTopLeft().getY()),
                () -> assertEquals(11, w.getWidth()),
                () -> assertEquals(22, w.getHeight()),
                () -> assertEquals(99, w.getColor())
        );
    }

    @Test
    public void testMoveAndResizeAndStretch() {
        StretchableWindow w = new StretchableWindow(0, 0, 10, 20, 1);

        w.moveRel(3, 4);
        assertAll(
                () -> assertEquals(3, w.getTopLeft().getX()),
                () -> assertEquals(4, w.getTopLeft().getY())
        );

        w.moveTo(100, 200);
        assertAll(
                () -> assertEquals(100, w.getTopLeft().getX()),
                () -> assertEquals(200, w.getTopLeft().getY())
        );

        w.moveTo(new Point(-10, -20));
        assertAll(
                () -> assertEquals(-10, w.getTopLeft().getX()),
                () -> assertEquals(-20, w.getTopLeft().getY())
        );

        w.resize(0.3);
        assertAll(
                () -> assertEquals(3, w.getWidth()),
                () -> assertEquals(6, w.getHeight())
        );

        w.stretch(2.5, 1.2);
        assertAll(
                () -> assertEquals(7, w.getWidth()),
                () -> assertEquals(7, w.getHeight())
        );
    }

    @Test
    public void testEqualsHashCode() {
        StretchableWindow w1 = new StretchableWindow(1, 2, 10, 20, 3);
        StretchableWindow w2 = new StretchableWindow(1, 2, 10, 20, 3);
        StretchableWindow w3 = new StretchableWindow(1, 2, 10, 21, 3);
        assertEquals(w1, w2);
        assertEquals(w1.hashCode(), w2.hashCode());
        assertNotEquals(w1, w3);
    }
}