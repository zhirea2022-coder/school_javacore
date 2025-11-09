package assignments.figures.v2;

import assignments.iface.v2.HasArea;
import assignments.iface.v2.Movable;
import assignments.iface.v2.Resizable;

public abstract class Figure implements Movable, Resizable, HasArea {

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    public abstract void moveTo(int x, int y);

    public abstract void moveRel(int dx, int dy);

    public abstract void resize(double ratio);

    public abstract double getArea();

    public abstract boolean isInside(int x, int y);

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public abstract double getPerimeter();
}