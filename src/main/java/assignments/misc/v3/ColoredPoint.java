package assignments.misc.v3;

import assignments.colors.v3.Color;
import assignments.colors.v3.ColorErrorCode;
import assignments.colors.v3.ColorException;
import assignments.figures.v3.Point;
import assignments.iface.v3.Colored;

import java.util.Objects;

public class ColoredPoint extends Point implements Colored {

    private Color color;

    public ColoredPoint(int x, int y, Color color) throws ColorException {
        super(x, y);
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    public ColoredPoint(int x, int y, String color) throws ColorException {
        this(x, y, Color.colorFromString(color));
    }

    @Override
    public void setColor(Color color) throws ColorException {
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    @Override
    public void setColor(String color) throws ColorException {
        this.color = Color.colorFromString(color);
    }

    @Override
    public Color getColor() {
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