package assignments.misc.v3;

import assignments.colors.v3.Color;
import assignments.colors.v3.ColorErrorCode;
import assignments.colors.v3.ColorException;
import assignments.figures.v3.Point;
import assignments.iface.v3.Colored;
import assignments.iface.v3.HasArea;
import assignments.iface.v3.Movable;
import assignments.iface.v3.Stretchable;

import java.util.Objects;

public class StretchableWindow implements Movable, Stretchable, Colored, HasArea {

    private Point topLeft;
    private int width;
    private int height;
    private Color color;

    public StretchableWindow(int x, int y, int width, int height, Color color) throws ColorException {
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.topLeft = new Point(x, y);
        this.width = Math.max(0, width);
        this.height = Math.max(0, height);
        this.color = color;
    }

    public StretchableWindow(int x, int y, int width, int height, String color) throws ColorException {
        this(x, y, width, height, Color.colorFromString(color));
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public void setTopLeft(Point p) {
        this.topLeft = p;
    }

    public void setWidth(int width) {
        this.width = Math.max(0, width);
    }

    public void setHeight(int height) {
        this.height = Math.max(0, height);
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
    public void moveTo(int x, int y) {
        topLeft.moveTo(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        topLeft.moveRel(dx, dy);
    }

    @Override
    public void resize(double ratio) {
        stretch(ratio, ratio);
    }

    @Override
    public void stretch(double xRatio, double yRatio) {
        width = (int) Math.floor(width * xRatio);
        height = (int) Math.floor(height * yRatio);
        if (width < 0) width = 0;
        if (height < 0) height = 0;
    }

    @Override
    public double getArea() {
        return (double) width * height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StretchableWindow)) return false;
        StretchableWindow that = (StretchableWindow) o;
        return width == that.width &&
                height == that.height &&
                color == that.color &&
                Objects.equals(topLeft, that.topLeft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, width, height, color);
    }
}