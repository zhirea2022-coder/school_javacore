package assignments.misc.v2;

import assignments.figures.v2.Point;
import assignments.iface.v2.Colored;

import java.util.Objects;

public class ColoredPoint extends Point implements Colored {

    private int color;

    public ColoredPoint(int x, int y, int color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColoredPoint)) return false;
        if (!super.equals(o)) return false;
        ColoredPoint that = (ColoredPoint) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}