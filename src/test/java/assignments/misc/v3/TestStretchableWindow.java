package assignments.misc.v3;

import assignments.colors.v3.Color;
import assignments.colors.v3.ColorErrorCode;
import assignments.colors.v3.ColorException;
import assignments.figures.v3.Point;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class TestStretchableWindow {

    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testStretchableWindow1() throws ColorException {
        StretchableWindow w = new StretchableWindow(10, 20, 30, 40, Color.RED);
        assertAll(
                () -> assertEquals(10, w.getTopLeft().getX()),
                () -> assertEquals(20, w.getTopLeft().getY()),
                () -> assertEquals(30, w.getWidth()),
                () -> assertEquals(40, w.getHeight()),
                () -> assertEquals(Color.RED, w.getColor()),
                () -> assertEquals(1200.0, w.getArea(), DOUBLE_EPS)
        );

        w.setTopLeft(new Point(-1, -2));
        w.setWidth(11);
        w.setHeight(22);
        w.setColor(Color.BLUE);
        assertAll(
                () -> assertEquals(-1, w.getTopLeft().getX()),
                () -> assertEquals(-2, w.getTopLeft().getY()),
                () -> assertEquals(11, w.getWidth()),
                () -> assertEquals(22, w.getHeight()),
                () -> assertEquals(Color.BLUE, w.getColor())
        );
    }

    @Test
    public void testStretchableWindow2() throws ColorException {
        StretchableWindow w = new StretchableWindow(10, 20, 30, 40, "RED");
        assertAll(
                () -> assertEquals(10, w.getTopLeft().getX()),
                () -> assertEquals(20, w.getTopLeft().getY()),
                () -> assertEquals(30, w.getWidth()),
                () -> assertEquals(40, w.getHeight()),
                () -> assertEquals(Color.RED, w.getColor()),
                () -> assertEquals(1200.0, w.getArea(), DOUBLE_EPS)
        );

        w.setTopLeft(new Point(-1, -2));
        w.setWidth(11);
        w.setHeight(22);
        w.setColor("BLUE");
        assertAll(
                () -> assertEquals(-1, w.getTopLeft().getX()),
                () -> assertEquals(-2, w.getTopLeft().getY()),
                () -> assertEquals(11, w.getWidth()),
                () -> assertEquals(22, w.getHeight()),
                () -> assertEquals(Color.BLUE, w.getColor())
        );
    }

    @Test
    public void testCoordinatesAndColor3() {
        assertThrows(ColorException.class, () -> new StretchableWindow(10, 20, 30, 40, (Color) null));
    }

    @Test
    public void testCoordinatesAndColor4() {
        assertThrows(ColorException.class, () -> new StretchableWindow(10, 20, 30, 40, (String) null));
    }

    @Test
    @SuppressWarnings("unused")
    public void testSetWrongColor() {
        try {
            StretchableWindow stretchableWindow = new StretchableWindow(10, 20, 30, 40, "YELLOW");
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.WRONG_COLOR_STRING, ex.getErrorCode());
        }
        try {
            StretchableWindow stretchableWindow = new StretchableWindow(10, 20, 30, 40, (Color) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            StretchableWindow stretchableWindow = new StretchableWindow(10, 20, 30, 40, (String) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            StretchableWindow stretchableWindow = new StretchableWindow(10, 20, 30, 40, "GREEN");
            stretchableWindow.setColor((Color) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            StretchableWindow stretchableWindow = new StretchableWindow(10, 20, 30, 40, "GREEN");
            stretchableWindow.setColor((String) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
    }

    @Test
    public void testMoveAndResizeAndStretch() throws ColorException {
        StretchableWindow w = new StretchableWindow(0, 0, 10, 20, Color.RED);

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
    public void testEqualsHashCode() throws ColorException {
        StretchableWindow w1 = new StretchableWindow(1, 2, 10, 20, Color.RED);
        StretchableWindow w2 = new StretchableWindow(1, 2, 10, 20, Color.RED);
        StretchableWindow w3 = new StretchableWindow(1, 2, 10, 21, Color.RED);
        assertEquals(w1, w2);
        assertEquals(w1.hashCode(), w2.hashCode());
        assertNotEquals(w1, w3);
    }
}