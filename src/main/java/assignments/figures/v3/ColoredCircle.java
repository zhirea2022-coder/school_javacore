package assignments.figures.v3;

import assignments.colors.v3.Color;
import assignments.colors.v3.ColorErrorCode;
import assignments.colors.v3.ColorException;
import assignments.iface.v3.Colored;

import java.util.Objects;

public class ColoredCircle extends Circle implements Colored {

    Color color;

    public ColoredCircle(Point center, int radius, Color color) throws ColorException {
        super(center, radius);
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;    }

    public ColoredCircle(Point center, int radius, String color) throws ColorException {
        this(center, radius, Color.colorFromString(color));
    }

    public ColoredCircle(int xCenter, int yCenter, int radius, Color color) throws ColorException {
        super(xCenter, yCenter, radius);
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;    }

    public ColoredCircle(int xCenter, int yCenter, int radius, String color) throws ColorException {
        this(xCenter,yCenter, radius, Color.colorFromString(color));
    }

    public ColoredCircle(int radius, Color color) throws ColorException {
        super(radius);
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;    }

    public ColoredCircle(int radius, String color) throws ColorException {
        this(radius, Color.colorFromString(color));
    }

    public ColoredCircle(Color color) throws ColorException {
        super(0, 0, 1);
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;    }

    public ColoredCircle(String color) throws ColorException {
        this(Color.colorFromString(color));
    }

    public ColoredCircle() throws ColorException {
        this(Color.RED);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) throws ColorException {
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    public void setColor(String color) throws ColorException {
        this.color = Color.colorFromString(color);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ColoredCircle that = (ColoredCircle) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}