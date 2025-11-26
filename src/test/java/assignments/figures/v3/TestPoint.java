package assignments.figures.v3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPoint {

    @Test
    public void testSetters() {
        Point point = new Point(10, 20);
        point.setX(30);
        point.setY(40);

        assertAll(
                () -> assertEquals(30, point.getX()),
                () -> assertEquals(40, point.getY())
        );
    }

    @Test
    public void testMoveTo() {
        Point point = new Point(10, 20);
        point.moveTo(5, 7);

        assertAll(
                () -> assertEquals(5, point.getX()),
                () -> assertEquals(7, point.getY())
        );
    }

    @Test
    public void testMoveRel() {
        Point point = new Point(1, 2);
        point.moveRel(3, 4);

        assertAll(
                () -> assertEquals(4, point.getX()),
                () -> assertEquals(6, point.getY())
        );
    }

    @Test
    public void testEqualsPoint() {
        Point p1 = new Point(10, 20);
        Point p2 = new Point(10, 20);
        Point p3 = new Point(11, 20);
        Point p4 = new Point(10, 21);

        assertEquals(p1, p2);
        assertNotEquals(p1, null);
        assertNotEquals(p1, new Object());
        assertNotEquals(p1, p3);
        assertNotEquals(p1, p4);
    }
}
