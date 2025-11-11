package assignments.misc;

import assignments.iface.v2.HasArea;
import assignments.iface.v2.Resizable;

import java.util.Objects;

public class ResizableImage implements Resizable, HasArea {

    private int width;
    private int height;

    public ResizableImage(int width, int height) {
        this.width = Math.max(0, width);
        this.height = Math.max(0, height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = Math.max(0, width);
    }

    public void setHeight(int height) {
        this.height = Math.max(0, height);
    }

    @Override
    public void resize(double ratio) {
        width = (int) Math.floor(width * ratio);
        height = (int) Math.floor(height * ratio);
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
        if (!(o instanceof ResizableImage)) return false;
        ResizableImage that = (ResizableImage) o;
        return width == that.width && height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}