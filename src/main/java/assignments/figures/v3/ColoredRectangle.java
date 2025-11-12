package assignments.figures.v3;

import assignments.colors.v3.Color;
import assignments.colors.v3.ColorErrorCode;
import assignments.colors.v3.ColorException;
import assignments.iface.v3.Colored;

import java.util.Objects;

public class ColoredRectangle extends Rectangle implements Colored {

    Color color;

    public ColoredRectangle(Point leftTop, Point rightBottom, Color color) throws ColorException {
        super(leftTop, rightBottom);
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;    }

    public ColoredRectangle(Point leftTop, Point rightBottom, String color) throws ColorException {
        this(leftTop, rightBottom, Color.colorFromString(color));
    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, Color color) throws ColorException {
        super(xLeft, yTop, xRight, yBottom);
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, String color) throws ColorException {
        this(xLeft, yTop, xRight, yBottom, Color.colorFromString(color));
    }

    public ColoredRectangle(int length, int width, Color color) throws ColorException {
        super(length, width);
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;    }

    public ColoredRectangle(int length, int width, String color) throws ColorException {
        this(length, width, Color.colorFromString(color));
    }

    public ColoredRectangle(Color color) throws ColorException {
        super(0, -1, 1, 0);
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    public ColoredRectangle(String color) throws ColorException {
        this(Color.colorFromString(color));
    }

    public ColoredRectangle() throws ColorException {
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
        ColoredRectangle that = (ColoredRectangle) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}