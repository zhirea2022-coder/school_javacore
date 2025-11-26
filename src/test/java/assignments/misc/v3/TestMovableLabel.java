package assignments.misc.v3;

import assignments.figures.v3.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMovableLabel {

    @Test
    public void testConstructorAndGettersSetters() {
        MovableLabel label = new MovableLabel("Hello", 10, 20);
        assertAll(
                () -> assertEquals("Hello", label.getText()),
                () -> assertEquals(10, label.getPosition().getX()),
                () -> assertEquals(20, label.getPosition().getY())
        );
        label.setText("World");
        label.setPosition(new Point(-5, 7));
        assertAll(
                () -> assertEquals("World", label.getText()),
                () -> assertEquals(-5, label.getPosition().getX()),
                () -> assertEquals(7, label.getPosition().getY())
        );
    }

    @Test
    public void testMoveIntRelPoint() {
        MovableLabel label = new MovableLabel("A", 0, 0);
        label.moveRel(3, 4);
        assertAll(
                () -> assertEquals(3, label.getPosition().getX()),
                () -> assertEquals(4, label.getPosition().getY())
        );
        label.moveTo(100, 200);
        assertAll(
                () -> assertEquals(100, label.getPosition().getX()),
                () -> assertEquals(200, label.getPosition().getY())
        );
        label.moveTo(new Point(-1, -2));
        assertAll(
                () -> assertEquals(-1, label.getPosition().getX()),
                () -> assertEquals(-2, label.getPosition().getY())
        );
    }

    @Test
    public void testEqualsHashCode() {
        MovableLabel l1 = new MovableLabel("X", 1, 2);
        MovableLabel l2 = new MovableLabel("X", 1, 2);
        MovableLabel l3 = new MovableLabel("Y", 1, 2);
        assertEquals(l1, l2);
        assertEquals(l1.hashCode(), l2.hashCode());
        assertNotEquals(l1, l3);
    }
}