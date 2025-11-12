package assignments.misc.v3;

import assignments.figures.v3.Point;
import assignments.iface.v3.Movable;

import java.util.Objects;

public class MovableLabel implements Movable {

    private String text;
    private Point position;

    public MovableLabel(String text, int x, int y) {
        this.text = text;
        this.position = new Point(x, y);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public void moveTo(int x, int y) {
        position.moveTo(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        position.moveRel(dx, dy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovableLabel)) return false;
        MovableLabel that = (MovableLabel) o;
        return Objects.equals(text, that.text) &&
                Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, position);
    }
}