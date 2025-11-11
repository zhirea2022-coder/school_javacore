package assignments.misc.v2;

import assignments.figures.v2.Point;
import assignments.iface.v2.Colored;
import assignments.iface.v2.HasArea;
import assignments.iface.v2.Movable;
import assignments.iface.v2.Stretchable;

import java.util.Objects;

public class StretchableWindow implements Movable, Stretchable, Colored, HasArea {

    private Point topLeft;
    private int width;
    private int height;
    private int color;

    public StretchableWindow(int x, int y, int width, int height, int color) {
        this.topLeft = new Point(x, y);
        this.width = Math.max(0, width);
        this.height = Math.max(0, height);
        this.color = color;
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

    public int getColor() {
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
    public void setColor(int color) {
        this.color = color;
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