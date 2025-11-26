package assignments.misc.v3;

import assignments.colors.v3.Color;
import assignments.colors.v3.ColorErrorCode;
import assignments.colors.v3.ColorException;
import assignments.figures.v3.Point;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class TestColoredPoint {

    @Test
    public void testCoordinatesAndColor1() throws ColorException {
        ColoredPoint p = new ColoredPoint(3, 4, Color.GREEN);
        assertAll(
                () -> assertEquals(3, p.getX()),
                () -> assertEquals(4, p.getY()),
                () -> assertEquals(Color.GREEN, p.getColor())
        );

        p.setColor(Color.RED);
        assertEquals(Color.RED, p.getColor());
    }

    @Test
    public void testCoordinatesAndColor2() throws ColorException {
        ColoredPoint p = new ColoredPoint(3, 4, "GREEN");
        assertAll(
                () -> assertEquals(3, p.getX()),
                () -> assertEquals(4, p.getY()),
                () -> assertEquals(Color.GREEN, p.getColor())
        );

        p.setColor(Color.RED);
        assertEquals(Color.RED, p.getColor());
    }

    @Test
    public void testCoordinatesAndColor3() {
        assertThrows(ColorException.class, () -> new ColoredPoint(3, 4, (Color) null));
    }

    @Test
    public void testCoordinatesAndColor4() {
        assertThrows(ColorException.class, () -> new ColoredPoint(3, 4, (String) null));
    }

    @Test
    @SuppressWarnings("unused")
    public void testSetWrongColor() {
        try {
            ColoredPoint point = new ColoredPoint(3, 4, "YELLOW");
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.WRONG_COLOR_STRING, ex.getErrorCode());
        }
        try {
            ColoredPoint point = new ColoredPoint(3, 4, (Color) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            ColoredPoint point = new ColoredPoint(3, 4, (String) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            ColoredPoint point = new ColoredPoint(3, 4, "GREEN");
            point.setColor((Color) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            ColoredPoint point = new ColoredPoint(3, 4, "GREEN");
            point.setColor((String) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
    }

    @Test
    public void testMoveIntAndRelAndPoint() throws ColorException {
        ColoredPoint p = new ColoredPoint(0, 0, Color.BLUE);
        p.moveRel(10, 5);
        assertAll(
                () -> assertEquals(10, p.getX()),
                () -> assertEquals(5, p.getY())
        );
        p.moveTo(7, 9);
        assertAll(
                () -> assertEquals(7, p.getX()),
                () -> assertEquals(9, p.getY())
        );
        p.moveTo(new Point(-1, -2));
        assertAll(
                () -> assertEquals(-1, p.getX()),
                () -> assertEquals(-2, p.getY())
        );
    }

    @Test
    public void testEqualsHashCode() throws ColorException {
        ColoredPoint p1 = new ColoredPoint(1, 2, Color.RED);
        ColoredPoint p2 = new ColoredPoint(1, 2, Color.RED);
        ColoredPoint p3 = new ColoredPoint(1, 2, Color.BLUE);
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
        assertNotEquals(p1, p3);
    }
}
