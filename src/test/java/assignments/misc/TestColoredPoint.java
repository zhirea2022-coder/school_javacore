package assignments.misc;

import assignments.figures.v2.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestColoredPoint {

    @Test
    public void testCoordinatesAndColor() {
        ColoredPoint p = new ColoredPoint(3, 4, 7);
        assertAll(
                () -> assertEquals(3, p.getX()),
                () -> assertEquals(4, p.getY()),
                () -> assertEquals(7, p.getColor())
        );

        p.setColor(42);
        assertEquals(42, p.getColor());
    }

    @Test
    public void testMoveIntAndRelAndPoint() {
        ColoredPoint p = new ColoredPoint(0, 0, 1);
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
    public void testEqualsHashCode() {
        ColoredPoint p1 = new ColoredPoint(1, 2, 3);
        ColoredPoint p2 = new ColoredPoint(1, 2, 3);
        ColoredPoint p3 = new ColoredPoint(1, 2, 99);
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
        assertNotEquals(p1, p3);
    }
}
